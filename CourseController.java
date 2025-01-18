package com.lms.controller;

import com.lms.model.Course;
import com.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
}
