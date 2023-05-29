package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.ProductMapper;
import com.lk.modules.entity.Product;
import com.lk.modules.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;
import com.lk.modules.utils.TimeUtil;

/**
 * product
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public PageInfo<Product> selectProductInfo(Product product, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        List<Product> data = productMapper.selectListInfo(product);
        return new PageInfo<>(data);
    }

    @Override
    public void saveProductInfo(Product product) {
        product.setStatus(1);
        product.setCreateTime(TimeUtil.getCurrentTime());
        productMapper.insert(product);
    }

    @Override
    public void updateProductInfo(Product product) {
        productMapper.updateById(product);
    }

    @Override
    public void delProductInfo(Integer id) {
        productMapper.deleteById(id);
    }

    @Override
    public void delBatchProductInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        productMapper.deleteBatchIds(list);
    }


}