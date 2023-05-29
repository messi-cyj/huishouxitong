package com.lk.modules.mapper;

import com.lk.modules.args.EduMonthSearchArgs;
import com.lk.modules.dto.EduMonthDto;
import com.lk.modules.po.EduMonthPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EduMonthMapper {

    Boolean saveMonthEdu(EduMonthDto dto);

    Boolean saveMonthEduFileLink(@Param("trainId") Integer trainId,@Param("fileIdList") List<Integer> fileIdList);

    void updateMonthEdu(EduMonthDto dto);

    void deleteMonthFileLink(@Param("id") Integer id);

    Boolean deleteMonthEdu(Integer id);

    List<EduMonthPo> getMonthEduList(EduMonthSearchArgs args);

    EduMonthPo getMonthEduDetails(@Param("id") Integer id);
}
