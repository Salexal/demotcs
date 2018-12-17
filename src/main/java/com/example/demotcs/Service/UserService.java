package com.example.demotcs.Service;

import com.example.demotcs.entity.User;

import java.util.List;

public interface UserService {

    /** 増 改*/
    public String addUser(User user);

    /** 删 */
    public void deleteUser(Integer id);

    /** 查all */
    public List<User> queryAll();

    /** 查一个 */
    public User queryByUserName(String userName);
}
