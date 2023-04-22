package com.red.service.impl;

import cn.hutool.core.lang.Dict;
import com.red.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Override
    public Dict add() {
        log.info("teacher:add");
        return new Dict().set("code", 200).set("message", "新增成功");
    }

    @Override
    public Dict update() {
        log.info("teacher:update");
        return new Dict().set("code", 200).set("message", "修改成功");
    }

    @Override
    public Dict delete() {
        log.info("teacher:delete");
        return new Dict().set("code", 200).set("message", "删除成功");
    }

    @Override
    public Dict query() {
        log.info("teacher:query");
        return new Dict().set("code", 200).set("message", "查询成功");
    }
}
