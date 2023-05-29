package com.lk.modules.mapper;

import com.lk.modules.args.EduQuarterSearchArgs;
import com.lk.modules.dto.EduQuarterDto;
import com.lk.modules.po.EduQuarterPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EduQuarterMapper {

    Boolean saveQuarterEdu(EduQuarterDto dto);

    Boolean saveQuarterEduFileLink(@Param("trainId") Integer trainId,@Param("fileIdList") List<Integer> fileIdList);

    void updateQuarterEdu(EduQuarterDto dto);

    void deleteQuarterFileLink(@Param("id") Integer id);

    Boolean deleteQuarterEdu(Integer id);

    List<EduQuarterPo> getQuarterEduList(EduQuarterSearchArgs args);

    EduQuarterPo getQuarterEduDetails(@Param("id") Integer id);
}
