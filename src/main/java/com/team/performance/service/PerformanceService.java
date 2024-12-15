package com.team.performance.service;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.mapper.PerformanceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PerformanceService {

    @Autowired
    private PerformanceMapper performanceMapper;

    // Retrieve all performances
    public List<PerformanceVO> getAllPerformances() {
        log.info("Fetching all performances.");
        List<PerformanceVO> performances = performanceMapper.getAllPerformances();
        log.info("Total performances fetched: {}", performances.size());
        return performances;
    }

    // Retrieve a specific performance by ID
    public PerformanceVO getPerformanceById(Integer id) {
        log.info("Fetching performance with ID: {}", id);
        PerformanceVO performance = performanceMapper.getPerformanceById(id);
        if (performance != null) {
            log.info("Performance title: {}", performance.getTitle());
        } else {
            log.warn("No performance found with ID: {}", id);
        }
        return performance;
    }

    // Insert a new performance
    public void addPerformance(PerformanceVO performance) {
        log.info("Adding new performance: {}", performance);
        performanceMapper.insertPerformance(performance);
        log.info("Performance added successfully.");
    }

    // Delete a performance by ID
    public void deletePerformanceById(Integer id) {
        log.info("Deleting performance with ID: {}", id);
        performanceMapper.deletePerformanceById(id);
        log.info("Performance deleted successfully.");
    }

    // Update an existing performance
    public void updatePerformance(PerformanceVO performance) {
        log.info("Updating performance with ID: {}", performance.getId());
        performanceMapper.updatePerformance(performance);
        log.info("Performance updated successfully.");
    }

    // Retrieve performances sorted by date in ascending order
    public List<PerformanceVO> getPerformancesSortedByDateAsc() {
        log.info("Fetching performances sorted by date (ascending).");
        List<PerformanceVO> performances = performanceMapper.selectPerformancesSortedByDateAsc();
        log.info("Total performances fetched: {}", performances.size());
        return performances;
    }

    // Retrieve performances sorted by date in descending order
    public List<PerformanceVO> getPerformancesSortedByDateDesc() {
        log.info("Fetching performances sorted by date (descending).");
        List<PerformanceVO> performances = performanceMapper.selectPerformancesSortedByDateDesc();
        log.info("Total performances fetched: {}", performances.size());
        return performances;
    }
}