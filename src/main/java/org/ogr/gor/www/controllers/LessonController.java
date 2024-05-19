package org.ogr.gor.www.controllers;

import org.ogr.gor.www.entities.database.Lesson;
import org.ogr.gor.www.entities.requests.lessons.*;
import org.ogr.gor.www.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.ILessonService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@Validated
public class LessonController {
    private final ILessonService lessonService;

    public LessonController(ILessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/lessons/getByGroup")
    public Lesson[] getLessonsByGroup(@RequestBody @Valid GetLessonsByGroupRequest request) {
        try {
            return lessonService.getLessonsByGroup(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @GetMapping("/lessons/getByTeacher")
    public Lesson[] getLessonsByTeacher(@RequestBody @Valid GetLessonsByTeacherRequest request) {
        try {
            return lessonService.getLessonsByTeacher(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @GetMapping("/lessons/{request}")
    public Lesson getLessonsById(@PathVariable @Valid GetLessonByIdRequest request) {
        try {
            return lessonService.getLessonById(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PostMapping("/lessons/add")
    public long addLessons(@RequestBody @Valid AddLessonRequest request) {
        try {
            return lessonService.addLesson(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PutMapping("/lessons/edit")
    public void editLessons(@RequestBody @Valid EditLessonRequest request) {
        try {
            lessonService.editLesson(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @DeleteMapping("/lessons/delete")
    public void deleteLessons(@RequestParam @Valid DeleteLessonRequest id) {
        try {
            lessonService.deleteLesson(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }
}
