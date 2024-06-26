package org.ogr.gor.www.services.interfaces;

import org.ogr.gor.www.entities.database.Subject;
import org.ogr.gor.www.entities.requests.subjects.AddSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.DeleteSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.EditSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.GetSubjectByIdRequest;
import org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.service_exceptions.NotFoundException;

public interface ISubjectService {
    Subject[] getSubjects();

    Subject getSubjectById(GetSubjectByIdRequest request) throws NotFoundException;

    long addSubject(AddSubjectRequest request) throws NotEnoughMemoryException;

    void editSubject(EditSubjectRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteSubject(DeleteSubjectRequest request) throws NotFoundException;
}
