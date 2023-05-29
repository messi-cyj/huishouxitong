package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * donate
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("donate")
public class Donate {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 捐赠名
     */
    	private String donateName;
	    /**
     * 备注
     */
    	private String remark;
	    /**
     * 创建时间
     */
    	private String createTime;
	}