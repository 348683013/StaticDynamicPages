package com.example.dao;

import com.example.domain.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * author:zhouzhongzhong
 * date:2021/12/13,13:58
 */
public class UserDao {
    QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource("test"));

    //查询所有用户
    public List<User> findAll() throws SQLException {
        String sql = "select * from user";
        List<User> userList = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        return userList;
    }

    //查询指定姓名的用户
    public List<User> findByName(String name) throws SQLException {
        String sql = "select * from user where name = ?";
        Object[] params={name};
        List<User> userList = queryRunner.query(sql, new BeanListHandler<User>(User.class), params);
        return userList;
    }
}
