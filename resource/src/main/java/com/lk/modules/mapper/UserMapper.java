package com.lk.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lk.modules.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * user
 *
 * @author lk
 * @since 1.0.0 2022-12-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

	
}