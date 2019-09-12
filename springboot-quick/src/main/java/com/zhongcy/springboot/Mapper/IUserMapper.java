package com.zhongcy.springboot.Mapper;

import com.zhongcy.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhongcy on 2019/9/11.
 */
@Mapper
@Repository("userMapper")
public interface IUserMapper {
    List<User> queryUserList();
}
