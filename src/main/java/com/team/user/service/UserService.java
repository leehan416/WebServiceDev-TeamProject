package com.team.user.service;

import com.team.user.VO.UserVO;
import com.team.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public UserVO getUserById(Integer id) {
        System.out.println("!!!");
        log.info("id : {}", id);
        UserVO user = userMapper.getUserById(id);

        log.info("user_id : {}", user.getUser_id());
        System.out.println("!!!");
        return user;
    }

    public UserVO getUser(UserVO vo) {
        return userMapper.getUser(vo);
    }
}
