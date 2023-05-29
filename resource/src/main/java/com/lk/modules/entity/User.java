package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * user
 *
 * @author lk
 * @since 1.0.0 2022-12-29
 */
@Data
@TableName("user")
public class User {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 用户名
     */
    	private String userName;
	    /**
     * 密码
     */
    	private String password;
	    /**
     * 姓名
     */
    	private String realName;
	    /**
     * 地址
     */
    	private String address;
	    /**
     * 联系方式
     */
    	private String phone;
	    /**
     * 用户类型
     */
    	private Integer userType;
	    /**
     * 头像
     */
    	private String imageUrl;

    	private String sex;

    	private String email;
	}