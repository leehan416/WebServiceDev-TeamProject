package com.team.performance.mapper;

import com.team.performance.VO.PerformanceVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PerformanceMapper {

    PerformanceVO getPerformanceById(Integer id);

    PerformanceVO getPerformance(PerformanceVO vo);

    void insertPerformance(PerformanceVO performance);
}