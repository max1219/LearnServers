package org.ogr.gor.www.old.repositories.samples.array_repositories;

import org.ogr.gor.www.old.entities.database.*;
import org.ogr.gor.www.old.updated.entities.database.*;
import org.springframework.stereotype.Component;

@Component
public class Database {
    final Attendance[] attendances;
    final Lesson[] lessons;
    final StudentGroup[] studentGroups;
    final Student[] students;
    final Subject[] subjects;
    final Teacher[] teachers;

    public Database() {
        this.attendances = new Attendance[100];
        this.lessons = new Lesson[100];
        this.studentGroups = new StudentGroup[100];
        this.students = new Student[100];
        this.subjects = new Subject[100];
        this.teachers = new Teacher[100];
    }
}
