package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.Donate;

/**
 * donate
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
public interface DonateService extends IService<Donate>{

    PageInfo<Donate> selectDonateInfo(Donate donate, Integer pageNum, Integer pageSize);

    void saveDonateInfo(Donate donate);

    void updateDonateInfo(Donate donate);

    void delDonateInfo(Integer id);

    void delBatchDonateInfo(String idList);


}