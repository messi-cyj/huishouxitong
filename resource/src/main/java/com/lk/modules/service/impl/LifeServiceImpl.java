package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.LifeMapper;
import com.lk.modules.entity.Life;
import com.lk.modules.service.LifeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;

/**
 * life
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Service
public class LifeServiceImpl extends ServiceImpl<LifeMapper, Life> implements LifeService {

    @Autowired
    private LifeMapper lifeMapper;


    @Override
    public PageInfo<Life> selectLifeInfo(Life life, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Life> wrapper = new QueryWrapper<>();
        if (life.getLifeName() !=null){
            wrapper.like("life_name",life.getLifeName());
        }
        List<Life> data = lifeMapper.selectList(wrapper);
        return new PageInfo<>(data);
    }

    @Override
    public void saveLifeInfo(Life life) {
        lifeMapper.insert(life);
    }

    @Override
    public void updateLifeInfo(Life life) {
        lifeMapper.updateById(life);
    }

    @Override
    public void delLifeInfo(Integer id) {
        lifeMapper.deleteById(id);
    }

    @Override
    public void delBatchLifeInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        lifeMapper.deleteBatchIds(list);
    }


}