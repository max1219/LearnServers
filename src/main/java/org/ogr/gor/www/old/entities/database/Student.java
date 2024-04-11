package org.ogr.gor.www.old.entities.database;

import java.util.Objects;

public class Student {
    private final Long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final long groupId;
    private final String status;

    public Student(Long id, String lastName, String firstName, String middleName, Long groupId, String status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(middleName, student.middleName) && Objects.equals(groupId, student.groupId) && Objects.equals(status, student.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, groupId, status);
    }
}
