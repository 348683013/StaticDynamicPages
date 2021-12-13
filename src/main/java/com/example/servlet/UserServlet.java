package com.example.servlet; /**
 * author:zhouzhongzhong
 * date:2021/12/13,13:31
 */

import com.example.dao.UserDao;
import com.zzz.baseservlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserServlet extends BaseServlet {
    private UserDao userDao = new UserDao();

    public String findAll(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("userList", userDao.findAll());
            return "forward:/show.jsp";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String findByName(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            request.setAttribute("userList",userDao.findByName(name));
            return "forward:/show.jsp";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
