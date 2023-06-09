package com.red.controller;

import cn.hutool.core.lang.Dict;
import com.red.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")// 预授权
    public Dict add() {
        return teacherService.add();
    }

    @GetMapping("/update")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    public Dict update() {
        return teacherService.update();
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Dict delete() {
        return teacherService.delete();
    }

    @GetMapping("/query")
    public Dict query() {
        return teacherService.query();
    }
}
