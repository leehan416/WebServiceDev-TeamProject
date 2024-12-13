package com.team.performance.service;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.mapper.PerformanceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PerformanceService {

    @Autowired
    public PerformanceMapper performanceMapper;

    public PerformanceVO getPerformanceById(Integer id) {
        log.info("Fetching performance with ID: {}", id);
        PerformanceVO performance = performanceMapper.getPerformanceById(id);

        log.info("Performance title: {}", performance.getTitle());
        return performance;
    }

    public PerformanceVO getPerformance(PerformanceVO vo) {
        log.info("Fetching performance with details: {}", vo);
        return performanceMapper.getPerformance(vo);
    }
}
