package com.team.user.mapper;

import com.team.user.VO.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserVO getUserById(Integer id);
}