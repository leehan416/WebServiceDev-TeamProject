package com.team.reservation.mapper;

import com.team.reservation.VO.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {

    /**
     * Fetch a reservation by its ID.
     * @param id Reservation ID
     * @return ReservationVO object
     */
    ReservationVO getReservationById(Integer id);

    /**
     * Fetch a reservation by its details (e.g., user ID and performance ID).
     * @param reservation ReservationVO containing the query parameters
     * @return ReservationVO object
     */
    ReservationVO getReservation(ReservationVO reservation);

    /**
     * Insert a new reservation into the database.
     * @param reservation ReservationVO containing the reservation details
     */
    void insertReservation(ReservationVO reservation);

    /**
     * Fetch all reservations for a specific user by user ID.
     * @param userId User ID
     * @return List of ReservationVO objects
     */
    List<ReservationVO> selectReservationsByUserId(Integer userId);
}