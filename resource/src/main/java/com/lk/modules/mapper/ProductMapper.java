package com.lk.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lk.modules.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * product
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> selectListInfo(Product product);
	
}