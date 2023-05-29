package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.StoreMapper;
import com.lk.modules.entity.Store;
import com.lk.modules.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;

/**
 * store
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

    @Autowired
    private StoreMapper storeMapper;


    @Override
    public PageInfo<Store> selectStoreInfo(Store store, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        if (store.getStoreName() !=null){
            wrapper.like("store_name",store.getStoreName());
        }
        List<Store> data = storeMapper.selectList(wrapper);
        return new PageInfo<>(data);
    }

    @Override
    public void saveStoreInfo(Store store) {
        storeMapper.insert(store);
    }

    @Override
    public void updateStoreInfo(Store store) {
        storeMapper.updateById(store);
    }

    @Override
    public void delStoreInfo(Integer id) {
        storeMapper.deleteById(id);
    }

    @Override
    public void delBatchStoreInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        storeMapper.deleteBatchIds(list);
    }


}