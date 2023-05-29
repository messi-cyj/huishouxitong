package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.User;

/**
 * user
 *
 * @author lk
 * @since 1.0.0 2022-12-29
 */
public interface UserService extends IService<User>{

    PageInfo<User> selectUserInfo(User user, Integer pageNum, Integer pageSize);

    void saveUserInfo(User user);

    void updateUserInfo(User user);

    void delUserInfo(Integer id);

    void delBatchUserInfo(String idList);

    User login(String userName, String password);
    
}