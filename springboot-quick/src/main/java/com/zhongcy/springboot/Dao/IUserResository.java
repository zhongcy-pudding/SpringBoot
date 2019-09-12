package com.zhongcy.springboot.Dao;

/**
 * Created by zhongcy on 2019/9/12.
 */

import com.zhongcy.springboot.entity.JpaUser;
import com.zhongcy.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userResository")
public interface IUserResository extends JpaRepository<JpaUser,Long>{
}
