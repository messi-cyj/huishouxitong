package com.lk.modules.service;

import com.lk.modules.args.StaffSearchArgs;
import com.lk.modules.dto.StaffDto;
import com.lk.modules.po.StaffPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffService {

    Boolean saveStaff(StaffDto dto);

    Boolean updateStaff(StaffDto dto);

    Boolean deleteStaff(@Param("id") Integer id);

    List<StaffPo> getStaffList(StaffSearchArgs args);

    StaffPo getStaffDetails(@Param("id") Integer id);
}
