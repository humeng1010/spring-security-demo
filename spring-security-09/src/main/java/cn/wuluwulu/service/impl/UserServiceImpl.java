package cn.wuluwulu.service.impl;

import cn.wuluwulu.entity.User;
import cn.wuluwulu.mapper.UserMapper;
import cn.wuluwulu.service.UserService;
import cn.wuluwulu.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Result<User> getUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = this.getOne(queryWrapper);
        return Result.ok(user);
    }
}
