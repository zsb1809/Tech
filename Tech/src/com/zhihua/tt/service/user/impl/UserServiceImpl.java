package com.zhihua.tt.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhihua.tt.dao.impl.BaseDaoImpl;
import com.zhihua.tt.entity.user.User;
import com.zhihua.tt.service.user.UserService;


@Service("userService")
@Transactional
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

}
