package com.lk.modules.service;

import com.lk.modules.args.EduYearSearchArgs;
import com.lk.modules.dto.EduYearDto;
import com.lk.modules.po.EduYearPo;
import com.lk.modules.vo.EduYearVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduYearService {

    Boolean saveYearEdu(EduYearDto dto);

    Boolean updateYearEdu(EduYearDto dto);

    Boolean deleteYearEdu(@Param("id") Integer id);

    List<EduYearVo> getYearEduList(EduYearSearchArgs args);

    EduYearPo getYearEduDetails(@Param("id") Integer id);
}
