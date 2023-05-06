package cn.wuluwulu.service;

import cn.wuluwulu.entity.User;
import cn.wuluwulu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    Result<User> getUserByUsername(String user);
}
