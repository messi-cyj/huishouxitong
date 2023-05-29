package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.Store;

/**
 * store
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
public interface StoreService extends IService<Store>{

    PageInfo<Store> selectStoreInfo(Store store, Integer pageNum, Integer pageSize);

    void saveStoreInfo(Store store);

    void updateStoreInfo(Store store);

    void delStoreInfo(Integer id);

    void delBatchStoreInfo(String idList);


}