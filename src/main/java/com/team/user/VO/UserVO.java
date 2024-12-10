package com.team.user.VO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Integer id;
    private String user_name;
    private String user_id;
    private String password;
    private Boolean is_admin;
    private Boolean is_manager;
    private Timestamp reg_date;
}
