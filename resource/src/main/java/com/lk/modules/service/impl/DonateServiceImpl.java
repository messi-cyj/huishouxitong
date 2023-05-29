package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.DonateMapper;
import com.lk.modules.entity.Donate;
import com.lk.modules.service.DonateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;
import com.lk.modules.utils.TimeUtil;

/**
 * donate
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Service
public class DonateServiceImpl extends ServiceImpl<DonateMapper, Donate> implements DonateService {

    @Autowired
    private DonateMapper donateMapper;


    @Override
    public PageInfo<Donate> selectDonateInfo(Donate donate, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Donate> wrapper = new QueryWrapper<>();
        if (donate.getDonateName() !=null){
            wrapper.like("donate_name",donate.getDonateName());
        }
        List<Donate> data = donateMapper.selectList(wrapper);
        return new PageInfo<>(data);
    }

    @Override
    public void saveDonateInfo(Donate donate) {
        donate.setCreateTime(TimeUtil.getCurrentTime());
        donateMapper.insert(donate);
    }

    @Override
    public void updateDonateInfo(Donate donate) {
        donateMapper.updateById(donate);
    }

    @Override
    public void delDonateInfo(Integer id) {
        donateMapper.deleteById(id);
    }

    @Override
    public void delBatchDonateInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        donateMapper.deleteBatchIds(list);
    }


}