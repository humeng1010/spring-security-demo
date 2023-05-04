package cn.wuluwulu.controller;

import cn.wuluwulu.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user, @RequestHeader String auth) {
        log.info("登陆的用户名:{},密码:{}", user.getUsername(), user.getPassword());
        log.info("token:{}", auth);

        HashMap<String, Object> res = new HashMap<>();
        res.put("success", 200);
        res.put("data", user);
        res.put("message", "登录成功");
        return res;

    }
}
