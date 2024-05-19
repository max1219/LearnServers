package org.ogr.gor.www.controllers;


import org.ogr.gor.www.entities.database.Attendance;
import org.ogr.gor.www.entities.requests.lessons.DeleteAttendanceRequest;
import org.ogr.gor.www.entities.requests.lessons.GetAttendanceRequest;
import org.ogr.gor.www.entities.requests.lessons.SetAttendanceRequest;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.IAttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@Validated
public class AttendanceController {

    private final IAttendanceService attendanceService;

    public AttendanceController(IAttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }


    @GetMapping("/attendances/{request}")
    public Attendance getAttendance(@PathVariable @Valid GetAttendanceRequest request) {
        try {
            return attendanceService.getAttendance(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PostMapping("/attendances/add")
    public void addSubject(@RequestBody @Valid SetAttendanceRequest request) {
        try {
            attendanceService.addAttendance(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @DeleteMapping("/attendances/delete")
    public void deleteSubject(@RequestParam @Valid DeleteAttendanceRequest id) {
        try {
            attendanceService.deleteAttendance(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }
}