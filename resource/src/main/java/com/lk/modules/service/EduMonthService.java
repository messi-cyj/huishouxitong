package com.lk.modules.service;

import com.lk.modules.args.EduMonthSearchArgs;
import com.lk.modules.dto.EduMonthDto;
import com.lk.modules.po.EduMonthPo;
import com.lk.modules.vo.EduMonthVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduMonthService {

    Boolean saveMonthEdu(EduMonthDto dto);

    Boolean updateMonthEdu(EduMonthDto dto);

    Boolean deleteMonthEdu(@Param("id") Integer id);

    List<EduMonthVo> getMonthEduList(EduMonthSearchArgs args);

    EduMonthPo getMonthEduDetails(@Param("id") Integer id);
}
