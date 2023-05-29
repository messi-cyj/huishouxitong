package com.lk.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * product
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("product")
public class Product {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 回收物名
     */
    	private String productName;
	    /**
     * 图片
     */
    	private String imageUrl;
	    /**
     * 分类
     */
    	private Integer sortId;
	    /**
     * 备注信息
     */
    	private String remark;
	    /**
     * 用户
     */
    	private Integer userId;
	    /**
     * 员工
     */
    	private Integer employeeId;
	    /**
     * 仓库名
     */
    	private Integer storeId;
	    /**
     * 状态
     */
    	private Integer status;
	    /**
     * 创建时间
     */
    	private String createTime;
		/**
	 * 分类名
	 */
	@TableField(exist = false)
	private String sortName;
	/**
	 * 姓名
	 */
	@TableField(exist = false)
	private String realName;
	/**
	 * 员工2
	 */
	@TableField(exist = false)
	private String employeeName;
	/**
	 * 仓库名
	 */
	@TableField(exist = false)
	private String storeName;
}