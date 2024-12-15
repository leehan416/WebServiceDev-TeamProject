package com.team.reservation.mapper;

import com.team.reservation.VO.ReservationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {

    Integer addReservation(ReservationVO reservationVO);
    Integer getUserIdByReservationId(Integer id);
    Integer deleteReservationById(Integer id);
    List<ReservationVO> getReservationsByUserId(Integer userId);

}