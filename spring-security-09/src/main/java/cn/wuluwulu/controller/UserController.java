package cn.wuluwulu.controller;

import cn.wuluwulu.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
// @CrossOrigin
@Slf4j
public class UserController {

    @GetMapping
    // @PreAuthorize("isAuthenticated()")
    public Result<String> getAllUser() {
        return Result.ok("查询用户成功", null);
    }
}
