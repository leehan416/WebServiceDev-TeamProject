package com.team.performance.mapper;

import com.team.performance.VO.PerformanceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PerformanceMapper {

    // Retrieve all performances
    List<PerformanceVO> getAllPerformances();

    // Retrieve a specific performance by its ID
    PerformanceVO getPerformanceById(Integer id);

    // Insert a new performance
    void insertPerformance(PerformanceVO performance);

    // Delete a performance by its ID
    void deletePerformanceById(Integer id);

    // Update a performance
    void updatePerformance(PerformanceVO performance);

    // Retrieve performances sorted by date in ascending order
    List<PerformanceVO> selectPerformancesSortedByDateAsc();

    // Retrieve performances sorted by date in descending order
    List<PerformanceVO> selectPerformancesSortedByDateDesc();
}