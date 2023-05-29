package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * sort
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("sort")
public class Sort {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 分类名
     */
    	private String sortName;
	}