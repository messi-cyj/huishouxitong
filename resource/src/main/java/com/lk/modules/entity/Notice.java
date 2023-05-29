package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * notice
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("notice")
public class Notice {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 标题
     */
    	private String title;
	    /**
     * 内容
     */
    	private String content;
	    /**
     * 接收人
     */
    	private Integer userId;
	    /**
     * 类型
     */
    	private Integer type;
	    /**
     * 创建时间
     */
    	private String createTime;
		/**
	 * 接收人
	 */
	@TableField(exist = false)
	private String realName;
}