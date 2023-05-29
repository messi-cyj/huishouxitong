package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.UserMapper;
import com.lk.modules.entity.User;
import com.lk.modules.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;

/**
 * user
 *
 * @author lk
 * @since 1.0.0 2022-12-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
        @Override
        public User login(String userName, String password) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("user_name",userName).eq("password",password);
            return userMapper.selectOne(wrapper);
        }


    @Override
    public PageInfo<User> selectUserInfo(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (user.getRealName() !=null){
            wrapper.like("real_name",user.getRealName());
        }
        if (user.getAddress() !=null){
            wrapper.like("address",user.getAddress());
        }
        if (user.getUserType() !=null){
            wrapper.eq("user_type",user.getUserType());
        }
        if (user.getId() !=null){
            wrapper.eq("id",user.getId());
        }
        List<User> data = userMapper.selectList(wrapper);
        return new PageInfo<>(data);
    }

    @Override
    public void saveUserInfo(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void delUserInfo(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void delBatchUserInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        userMapper.deleteBatchIds(list);
    }
}