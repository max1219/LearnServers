package org.ogr.gor.www.services.interfaces;

import org.ogr.gor.www.entities.database.Lesson;
import org.ogr.gor.www.entities.requests.lessons.*;
import org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.service_exceptions.NotFoundException;

public interface ILessonService {
    Lesson[] getLessonsByGroup(GetLessonsByGroupRequest request);

    Lesson[] getLessonsByTeacher(GetLessonsByTeacherRequest request);

    Lesson getLessonById(GetLessonByIdRequest request) throws NotFoundException;

    long addLesson(AddLessonRequest request) throws NotEnoughMemoryException;

    void editLesson(EditLessonRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteLesson(DeleteLessonRequest request) throws NotFoundException;

}
