package com.lk.modules.controller;

import com.lk.modules.service.UserService;
import com.lk.modules.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;


/**
 * user
 *
 * @author lk
 * @since 1.0.0 2022-12-29
 */
@RestController
@RequestMapping("/common/user")
@Api(tags = "用户管理模块")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取所有用户信息
     *
     * @param pageNum
     * @param pageSize
     * @param user
     * @return
     */

    @GetMapping("/getUserInfo")
    @ApiOperation("获取所有用户信息")
    public Result getUserInfo(User user, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<User> data = userService.selectUserInfo(user, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/saveUserInfo")
    @ApiOperation("保存用户信息")
    public Result saveUserInfo(@RequestBody User user) {
        userService.saveUserInfo(user);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */

    @PutMapping("/updateUserInfo")
    @ApiOperation("更新用户信息")
    public Result updateUserInfo(@RequestBody User user) {
        userService.updateUserInfo(user);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除用户信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delUserInfo")
    @ApiOperation("根据id删除用户信息")
    public Result delUserInfo(Integer id) {
        userService.delUserInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除用户信息
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchUserInfo")
    @ApiOperation("根据id集合批量删除用户信息")
    public Result delBatchUserInfo(String idList) {
        userService.delBatchUserInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 登录接口(根据用户名和密码)
     *
     * @param userName
     * @param password
     * @return
     */


    @PostMapping("/login")
    @ApiOperation("用户登录接口")
    public Result login(String userName, String password) {
        User user = userService.login(userName, password);
        if (user == null) {
            return ResultUtil.error(-1, "登录失败,用户名或者密码错误");
        } else {
            return ResultUtil.success(1, "登录成功", user);
        }
    }

}