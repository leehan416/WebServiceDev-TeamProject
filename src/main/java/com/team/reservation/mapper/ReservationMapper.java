package com.team.reservation.mapper;

import com.team.reservation.VO.ReservationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {

    /**
     * Retrieve reservations for a specific user.
     * @param userId The ID of the user
     * @return List of ReservationVO objects
     */
    List<ReservationVO> selectReservationsByUserId(@Param("userId") Integer userId);
}