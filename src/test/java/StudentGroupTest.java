import controllers.StudentGroupController;
import entities.responses.ResponseEntity;
import entities.responses.student_groups.AddStudentGroupResponse;
import entities.responses.student_groups.GetStudentGroupResponse;
import jsonMapper.JacksonDataBindMapper;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import repositories.samples.array_repositories.ArrayStudentGroupRepository;
import repositories.samples.array_repositories.Database;
import server.Server;
import services.samples.SampleStudentGroupService;
import validators.primes.samples.SampleIdValidator;
import validators.primes.samples.SampleNameValidator;
import validators.requests.student_groups.AddStudentGroupRequestValidator;
import validators.requests.student_groups.DeleteStudentGroupRequestValidator;
import validators.requests.student_groups.EditStudentGroupRequestValidator;
import validators.requests.student_groups.GetStudentGroupRequestValidator;

import java.util.List;

class StudentGroupTest {

    Server server;

    @BeforeEach
    void setUp() {
        Database database = new Database(20, 20, 3, 20, 20, 20);
        server = new Server(
                new JacksonDataBindMapper(),
                null,
                new StudentGroupController(new SampleStudentGroupService(new ArrayStudentGroupRepository(database)), new AddStudentGroupRequestValidator(new SampleNameValidator()), new DeleteStudentGroupRequestValidator(new SampleIdValidator()), new EditStudentGroupRequestValidator(new SampleIdValidator(), new SampleNameValidator()), new GetStudentGroupRequestValidator(new SampleIdValidator())));
    }

    @Test
    void getByIdTest() {
        ResponseEntity<AddStudentGroupResponse> responseAdd1 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        ResponseEntity<AddStudentGroupResponse> responseAdd2 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"BBM\"}");

        ResponseEntity<GetStudentGroupResponse> responseGet1 = (ResponseEntity<GetStudentGroupResponse>) server.process("getStudentGroupById", "{\"id\": " + responseAdd1.getArg().getId() + "}");
        ResponseEntity<GetStudentGroupResponse> responseGet2 = (ResponseEntity<GetStudentGroupResponse>) server.process("getStudentGroupById", "{\"id\": " + responseAdd2.getArg().getId() + "}");

        Assert.assertEquals("MMB", responseGet1.getArg().getGroupName());
        Assert.assertEquals("BBM", responseGet2.getArg().getGroupName());
    }

    @Test
    void getAllTest() {
        server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        server.process("addStudentGroup", "{\"name\": \"BBM\"}");

        ResponseEntity<List<GetStudentGroupResponse>> response = (ResponseEntity<List<GetStudentGroupResponse>>) server.process("getStudentGroups", "");
        List<GetStudentGroupResponse> resultList = response.getArg();

        Assert.assertEquals(2, resultList.size());
        Assert.assertTrue(
                resultList.stream()
                        .map(GetStudentGroupResponse::getGroupName)
                        .allMatch(name -> name.equals("MMB") || name.equals("BBM"))
                        && !resultList.get(0).getGroupName().equals(resultList.get(1).getGroupName()));
    }

    @Test
    void deleteTest() {
        ResponseEntity<AddStudentGroupResponse> responseAdd1 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        ResponseEntity<AddStudentGroupResponse> responseAdd2 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"BBM\"}");

        server.process("deleteStudentGroup", "{\"id\": " + responseAdd2.getArg().getId() + "}");

        ResponseEntity<List<GetStudentGroupResponse>> response = (ResponseEntity<List<GetStudentGroupResponse>>) server.process("getStudentGroups", "");
        Assert.assertEquals(1, response.getArg().size());
        Assert.assertEquals("MMB", response.getArg().get(0).getGroupName());

        server.process("deleteStudentGroup", "{\"id\": " + responseAdd1.getArg().getId() + "}");

        response = (ResponseEntity<List<GetStudentGroupResponse>>) server.process("getStudentGroups", "");
        Assert.assertEquals(0, response.getArg().size());
    }

    @Test
    void editTest() {
        server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        ResponseEntity<AddStudentGroupResponse> responseAdd2 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"BBM\"}");

        server.process("editStudentGroup", "{\"id\": " + responseAdd2.getArg().getId() + ", \"newName\": \"BBB\"}");

        ResponseEntity<List<GetStudentGroupResponse>> response = (ResponseEntity<List<GetStudentGroupResponse>>) server.process("getStudentGroups", "");
        List<GetStudentGroupResponse> resultList = response.getArg();
        Assert.assertEquals(2, resultList.size());
        Assert.assertTrue(
                resultList.stream()
                        .map(GetStudentGroupResponse::getGroupName)
                        .allMatch(name -> name.equals("MMB") || name.equals("BBB"))
                        && !resultList.get(0).getGroupName().equals(resultList.get(1).getGroupName()));

    }

    @Test
    void idNotFoundTest() {
        ResponseEntity<AddStudentGroupResponse> responseAdd1 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        ResponseEntity<AddStudentGroupResponse> responseAdd2 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"BBM\"}");

        ResponseEntity<?> responseGet = server.process("getStudentGroupById", "{\"id\": " + (responseAdd1.getArg().getId() + responseAdd2.getArg().getId() + 1) + "}");
        ResponseEntity<?> responseDelete = server.process("deleteStudentGroup", "{\"id\": " + (responseAdd1.getArg().getId() + responseAdd2.getArg().getId() + 1) + "}");
        ResponseEntity<?> responseEdit = server.process("editStudentGroup", "{\"id\": " + (responseAdd1.getArg().getId() + responseAdd2.getArg().getId() + 1) + ", \"newName\": \"BBB\"}");

        Assert.assertEquals(404, responseGet.getStatusCode());
        Assert.assertEquals(404, responseDelete.getStatusCode());
        Assert.assertEquals(404, responseEdit.getStatusCode());
    }

    @Test
    void validationFailTest() {
        ResponseEntity<AddStudentGroupResponse> responseAdd1 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        ResponseEntity<AddStudentGroupResponse> responseAdd2 = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"BBM\"}");

        ResponseEntity<?> responseGet = server.process("getStudentGroupById", "{\"id\": -1}");
        ResponseEntity<?> responseDelete = server.process("deleteStudentGroup", "{\"id\": -1}");
        ResponseEntity<?> responseEdit = server.process("editStudentGroup", "{\"id\": -1, \"newName\": \"BBB\"}");

        Assert.assertEquals(422, responseGet.getStatusCode());
        Assert.assertEquals(422, responseDelete.getStatusCode());
        Assert.assertEquals(422, responseEdit.getStatusCode());
    }

    @Test
    void wrongEndPointPest() {
        ResponseEntity<?> response = server.process("dsfgd", "dfb");

        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    void notEnoughMemoryTest(){
        server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        ResponseEntity<AddStudentGroupResponse> responseGood = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"MMB\"}");
        ResponseEntity<AddStudentGroupResponse> responseBad = (ResponseEntity<AddStudentGroupResponse>) server.process("addStudentGroup", "{\"name\": \"MMB\"}");

        Assert.assertEquals(200, responseGood.getStatusCode());
        Assert.assertEquals(422, responseBad.getStatusCode());
    }
}