package com.team.reservation.service;

import com.team.reservation.VO.ReservationVO;
import com.team.reservation.mapper.ReservationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    /**
     * Fetch all reservations for a specific user.
     * @param userId The ID of the user
     * @return List of ReservationVO objects
     */
    public List<ReservationVO> getUserReservations(Integer userId) {
        log.info("Fetching reservations for userId: {}", userId);
        List<ReservationVO> reservations = reservationMapper.selectReservationsByUserId(userId);

        if (reservations == null || reservations.isEmpty()) {
            log.warn("No reservations found for userId: {}", userId);
        } else {
            log.info("Total reservations found: {}", reservations.size());
        }

        return reservations;
    }
}