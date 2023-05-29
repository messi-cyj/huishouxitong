package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * store
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("store")
public class Store {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 仓库名
     */
    	private String storeName;
	}