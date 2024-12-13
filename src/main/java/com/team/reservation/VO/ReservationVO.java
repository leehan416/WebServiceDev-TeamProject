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
    private Integer id;             // Reservation ID (Primary Key)
    private Integer userId;         // User ID making the reservation
    private Integer performanceId;  // Performance ID associated with the reservation
    private Timestamp regDate;      // Reservation creation timestamp
}