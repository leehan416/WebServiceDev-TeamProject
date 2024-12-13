package com.team.reservation.mapper;

import com.team.reservation.VO.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {

    // Retrieve all reservations for a specific user
    List<ReservationVO> selectReservationsByUserId(Integer userId);
}