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
     * Fetch a reservation by its ID.
     * @param id The ID of the reservation
     * @return ReservationVO object
     */
    public ReservationVO getReservationById(Integer id) {
        log.info("Fetching reservation with ID: {}", id);
        ReservationVO reservation = reservationMapper.getReservationById(id);
        if (reservation != null) {
            log.info("Reservation found: {}", reservation);
        } else {
            log.warn("No reservation found with ID: {}", id);
        }
        return reservation;
    }

    /**
     * Fetch a reservation by details (userId and performanceId).
     * @param reservation ReservationVO containing the userId and performanceId
     * @return ReservationVO object
     */
    public ReservationVO getReservation(ReservationVO reservation) {
        log.info("Fetching reservation with details: {}", reservation);
        ReservationVO result = reservationMapper.getReservation(reservation);
        if (result != null) {
            log.info("Reservation found: {}", result);
        } else {
            log.warn("No reservation found for userId: {} and performanceId: {}",
                    reservation.getUserId(), reservation.getPerformanceId());
        }
        return result;
    }

    /**
     * Add a new reservation.
     * @param reservation ReservationVO object to be added
     */
    public void addReservation(ReservationVO reservation) {
        log.info("Adding new reservation: {}", reservation);
        reservationMapper.insertReservation(reservation);
        log.info("Reservation added successfully for userId: {} and performanceId: {}",
                reservation.getUserId(), reservation.getPerformanceId());
    }

    /**
     * Fetch all reservations for a specific user.
     * @param userId The ID of the user
     * @return List of ReservationVO objects
     */
    public List<ReservationVO> getUserReservations(Integer userId) {
        log.info("Fetching all reservations for userId: {}", userId);
        List<ReservationVO> reservations = reservationMapper.selectReservationsByUserId(userId);
        log.info("Total reservations found for userId {}: {}", userId, reservations.size());
        return reservations;
    }
}