package com.lk.modules.service.impl;

import com.lk.modules.args.StaffSearchArgs;
import com.lk.modules.dto.StaffDto;
import com.lk.modules.mapper.StaffMapper;
import com.lk.modules.po.StaffPo;
import com.lk.modules.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Boolean saveStaff(StaffDto dto) {
        return staffMapper.saveStaff(dto);
    }

    @Override
    public Boolean updateStaff(StaffDto dto) {
        return staffMapper.updateStaff(dto);
    }

    @Override
    public Boolean deleteStaff(Integer id) {
        return staffMapper.deleteStaff(id);
    }

    @Override
    public List<StaffPo> getStaffList(StaffSearchArgs args) {
        return staffMapper.getStaffList(args);
    }

    @Override
    public StaffPo getStaffDetails(Integer id) {
        return staffMapper.getStaffDetails(id);
    }
}
