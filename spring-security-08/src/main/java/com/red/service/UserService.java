package com.red.service;

import com.red.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 新增用户
     *
     * @param user User对象
     * @return User
     */
    User insertUser(User user);

    /**
     * 根据ID删除用户
     *
     * @param id Long ID
     */
    void deleteUser(Long id);

    /**
     * 修改用户
     *
     * @param user 需要修改的用户信息
     * @return 修改后返回的用户
     */
    User updateUser(User user);

    /**
     * 查询所有用户
     *
     * @return List
     */
    List<User> findAllUser();

    /**
     * 根据id查询用户
     *
     * @param id ID
     * @return User
     */
    User findUserById(Long id);
}
