package repositories.samples.array_repositories;

import entities.database.*;

public class Database {
    final Attendance[] attendances;
    final Lesson[] lessons;
    final StudentGroup[] studentGroups;
    final Student[] students;
    final Subject[] subjects;
    final Teacher[] teachers;

    public Database(
            int attendancesLength,
            int lessonsLength,
            int studentGroupsLength,
            int studentsLength,
            int subjectsLength,
            int teachersLength) {
        this.attendances = new Attendance[attendancesLength];
        this.lessons = new Lesson[lessonsLength];
        this.studentGroups = new StudentGroup[studentGroupsLength];
        this.students = new Student[studentsLength];
        this.subjects = new Subject[subjectsLength];
        this.teachers = new Teacher[teachersLength];
    }
}
