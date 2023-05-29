package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * dictionary
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("dictionary")
public class Dictionary {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 名称
     */
    	private String name;
	    /**
     * 状态
     */
    	private Integer status;
	}