package com.lk.modules.service.impl;

import com.lk.modules.args.EduYearSearchArgs;
import com.lk.modules.dto.EduYearDto;
import com.lk.modules.exception.CommonException;
import com.lk.modules.mapper.EduYearMapper;
import com.lk.modules.po.EduYearPo;
import com.lk.modules.service.EduYearService;
import com.lk.modules.vo.EduYearVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EduYearServiceImpl implements EduYearService {

    @Autowired
    private EduYearMapper eduYearMapper;

    @Override
    @Transactional
    public Boolean saveYearEdu(EduYearDto dto) {
        try {
            eduYearMapper.saveYearEdu(dto);
            if (dto.getFileIdList() != null && dto.getFileIdList().size() != 0) {
                eduYearMapper.saveYearEduFileLink(dto.getId(), dto.getFileIdList());
            }
            return true;
        } catch (Exception e) {
            throw new CommonException("添加失败");
        }
    }

    @Override
    @Transactional
    public Boolean updateYearEdu(EduYearDto dto) {
        try {
            eduYearMapper.updateYearEdu(dto);
            if (dto.getFileIdList() != null && dto.getFileIdList().size() != 0) {
                eduYearMapper.deleteYearFileLink(dto.getId());
                eduYearMapper.saveYearEduFileLink(dto.getId(), dto.getFileIdList());
            } else {
                eduYearMapper.deleteYearFileLink(dto.getId());
            }
            return true;
        } catch (Exception e) {
            throw new CommonException("修改失败");
        }
    }

    @Override
    public Boolean deleteYearEdu(Integer id) {
        try {
            eduYearMapper.deleteYearEdu(id);
            eduYearMapper.deleteYearFileLink(id);
            return true;
        } catch (Exception e) {
            throw new CommonException("删除失败");
        }
    }

    @Override
    public List<EduYearVo> getYearEduList(EduYearSearchArgs args) {
        return eduYearMapper.getYearEduList(args).stream().map(po ->{
            EduYearVo vo = new EduYearVo();
            BeanUtils.copyProperties(po,vo);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public EduYearPo getYearEduDetails(Integer id) {
        return eduYearMapper.getYearEduDetails(id);
    }
}
