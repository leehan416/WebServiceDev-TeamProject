package com.team.reservation.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationVO {
    private Integer id;
    private Integer user_id;
    private Integer performance_id;
    private Timestamp reg_date;
}