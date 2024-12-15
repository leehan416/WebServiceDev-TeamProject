package com.team.reservation.service;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.mapper.PerformanceMapper;
import com.team.reservation.VO.ReservationVO;
import com.team.reservation.mapper.ReservationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ReservationService {

    @Autowired
    private PerformanceMapper performanceMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    public List<ReservationVO> getUserReservations(Integer userId) {
        log.info("reservations for userId: {}", userId);

        List<ReservationVO> reservationVOS = reservationMapper.getReservationsByUserId(userId);

//        List<PerformanceVO> performanceVOS = new ArrayList<>();
//
//
//        for (ReservationVO reservation : reservationVOS) {
//            PerformanceVO performance = performanceMapper.getPerformanceById(reservation.getPerformanceId());
//            performanceVOS.add(performance);
//        }
        return reservationVOS;
    }

    public Integer addReservation(Integer userId, Integer performanceId) {
        Integer curNum = performanceMapper.getPerformanceById(performanceId).getCurrentNum();
        Integer maxNum = performanceMapper.getPerformanceById(performanceId).getMaxNum();

        if (curNum > maxNum){
            return -1;
        }

        ReservationVO vo = new ReservationVO(null, userId, performanceId, null);

        // log
        log.info("add reservation user = {} performance = {}", userId, performanceId);

        return reservationMapper.addReservation(vo);
    }

    public Integer removeReservation(Integer userId, Integer id) {

        // check
        if (Objects.equals(reservationMapper.getUserIdByReservationId(id), userId))
            return reservationMapper.deleteReservationById(id);

            // TODO : 공연에서 예약자 1 줄여야 함
        else return -1;
    }
}