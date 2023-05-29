package com.lk.modules.service.impl;

import com.lk.modules.args.EduQuarterSearchArgs;
import com.lk.modules.dto.EduQuarterDto;
import com.lk.modules.exception.CommonException;
import com.lk.modules.mapper.EduQuarterMapper;
import com.lk.modules.po.EduQuarterPo;
import com.lk.modules.service.EduQuarterService;
import com.lk.modules.vo.EduQuarterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EduQuarterServiceImpl implements EduQuarterService {

    @Autowired
    private EduQuarterMapper eduQuarterMapper;

    @Override
    @Transactional
    public Boolean saveQuarterEdu(EduQuarterDto dto) {
        try {
            eduQuarterMapper.saveQuarterEdu(dto);
            if (dto.getFileIdList() != null && dto.getFileIdList().size() != 0) {
                eduQuarterMapper.saveQuarterEduFileLink(dto.getId(), dto.getFileIdList());
            }
            return true;
        } catch (Exception e) {
            throw new CommonException("添加失败");
        }
    }

    @Override
    @Transactional
    public Boolean updateQuarterEdu(EduQuarterDto dto) {
        try {
            eduQuarterMapper.updateQuarterEdu(dto);
            if (dto.getFileIdList() != null && dto.getFileIdList().size() != 0) {
                eduQuarterMapper.deleteQuarterFileLink(dto.getId());
                eduQuarterMapper.saveQuarterEduFileLink(dto.getId(), dto.getFileIdList());
            } else {
                eduQuarterMapper.deleteQuarterFileLink(dto.getId());
            }
            return true;
        } catch (Exception e) {
            throw new CommonException("修改失败");
        }
    }

    @Override
    public Boolean deleteQuarterEdu(Integer id) {
        try {
            eduQuarterMapper.deleteQuarterEdu(id);
            eduQuarterMapper.deleteQuarterFileLink(id);
            return true;
        } catch (Exception e) {
            throw new CommonException("删除失败");
        }
    }

    @Override
    public List<EduQuarterVo> getQuarterEduList(EduQuarterSearchArgs args) {
        return eduQuarterMapper.getQuarterEduList(args).stream().map(po ->{
            EduQuarterVo vo = new EduQuarterVo();
            BeanUtils.copyProperties(po,vo);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public EduQuarterPo getQuarterEduDetails(Integer id) {
        return eduQuarterMapper.getQuarterEduDetails(id);
    }
}
