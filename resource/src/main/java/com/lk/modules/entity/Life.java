package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * life
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("life")
public class Life {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 服务名
     */
    	private String lifeName;
	    /**
     * 开始时间
     */
    	private String startTime;
	    /**
     * 结束时间
     */
    	private String endTime;
	    /**
     * 备注信息
     */
    	private String remark;
	    /**
     * 图片
     */
    	private String imageUrl;
	}