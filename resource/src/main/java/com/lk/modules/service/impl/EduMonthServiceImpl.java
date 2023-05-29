package com.lk.modules.service.impl;

import com.lk.modules.args.EduMonthSearchArgs;
import com.lk.modules.dto.EduMonthDto;
import com.lk.modules.exception.CommonException;
import com.lk.modules.mapper.EduMonthMapper;
import com.lk.modules.po.EduMonthPo;
import com.lk.modules.service.EduMonthService;
import com.lk.modules.vo.EduMonthVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EduMonthServiceImpl implements EduMonthService {

    @Autowired
    private EduMonthMapper eduMonthMapper;

    @Override
    @Transactional
    public Boolean saveMonthEdu(EduMonthDto dto) {
        try {
            eduMonthMapper.saveMonthEdu(dto);
            if (dto.getFileIdList() != null && dto.getFileIdList().size() != 0) {
                eduMonthMapper.saveMonthEduFileLink(dto.getId(), dto.getFileIdList());
            }
            return true;
        } catch (Exception e) {
            throw new CommonException("添加失败");
        }
    }

    @Override
    @Transactional
    public Boolean updateMonthEdu(EduMonthDto dto) {
        try {
            eduMonthMapper.updateMonthEdu(dto);
            if (dto.getFileIdList() != null && dto.getFileIdList().size() != 0) {
                eduMonthMapper.deleteMonthFileLink(dto.getId());
                eduMonthMapper.saveMonthEduFileLink(dto.getId(), dto.getFileIdList());
            } else {
                eduMonthMapper.deleteMonthFileLink(dto.getId());
            }
            return true;
        } catch (Exception e) {
            throw new CommonException("修改失败");
        }
    }

    @Override
    public Boolean deleteMonthEdu(Integer id) {
        try {
            eduMonthMapper.deleteMonthEdu(id);
            eduMonthMapper.deleteMonthFileLink(id);
            return true;
        } catch (Exception e) {
            throw new CommonException("删除失败");
        }
    }

    @Override
    public List<EduMonthVo> getMonthEduList(EduMonthSearchArgs args) {
        return eduMonthMapper.getMonthEduList(args).stream().map(po ->{
            EduMonthVo vo = new EduMonthVo();
            BeanUtils.copyProperties(po,vo);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public EduMonthPo getMonthEduDetails(Integer id) {
        return eduMonthMapper.getMonthEduDetails(id);
    }
}
