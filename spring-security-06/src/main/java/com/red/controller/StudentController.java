package com.red.controller;

import cn.hutool.core.lang.Dict;
import com.red.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('student:add') or hasAuthority('/student/**')")// 预授权
    public Dict add() {
        return new Dict().set("code", 200).set("message", "新增成功");
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('student:update') or hasAuthority('/student/**')")
    public Dict update() {
        return new Dict().set("code", 200).set("message", "新增成功");
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('student:delete') or hasAuthority('/student/**')")
    public Dict delete() {
        return new Dict().set("code", 200).set("message", "删除成功");
    }

    @GetMapping("/query")
    public Dict query() {
        return teacherService.query();
    }
}
