package com.lk.modules.service;

import com.lk.modules.args.EduQuarterSearchArgs;
import com.lk.modules.dto.EduQuarterDto;
import com.lk.modules.po.EduQuarterPo;
import com.lk.modules.vo.EduQuarterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduQuarterService {

    Boolean saveQuarterEdu(EduQuarterDto dto);

    Boolean updateQuarterEdu(EduQuarterDto dto);

    Boolean deleteQuarterEdu(@Param("id") Integer id);

    List<EduQuarterVo> getQuarterEduList(EduQuarterSearchArgs args);

    EduQuarterPo getQuarterEduDetails(@Param("id") Integer id);
}
