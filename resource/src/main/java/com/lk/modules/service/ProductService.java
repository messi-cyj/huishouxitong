package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.Product;

/**
 * product
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
public interface ProductService extends IService<Product>{

    PageInfo<Product> selectProductInfo(Product product, Integer pageNum, Integer pageSize);

    void saveProductInfo(Product product);

    void updateProductInfo(Product product);

    void delProductInfo(Integer id);

    void delBatchProductInfo(String idList);


}