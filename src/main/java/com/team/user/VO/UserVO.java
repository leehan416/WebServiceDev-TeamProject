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
    private Integer is_admin;
    private Integer is_manager;
    private Timestamp reg_date;


    public Boolean checkAuth_admin() {
        return is_admin == 1;
    }

    public Boolean checkAuth_manager() {
        if (is_manager == 1 || is_admin == 1) return true;
        return false;
    }
}
