package testWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import testWeb.vo.*;
import testWeb.dao.UserDAO;
import testWeb.dao.impl.*;

public class UserLoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

    }


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        UserInfo userinfo = new UserInfo();
        userinfo.setUsername(req.getParameter("username"));
        userinfo.setPassword(req.getParameter("password"));

        UserDAOImpl dao = new UserDAOImpl();
        int flag = 0;
        try {
            flag = dao.queryByUserInfo(userinfo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        if (flag == 1) {
            HttpSession session = req.getSession();


            session.setAttribute("username", userinfo.getUsername());
            UserInfo userInfo = null;
            try {
                userInfo = dao.queryByUsername(userinfo.getUsername());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            session.setAttribute("userInfo", userInfo);

            res.sendRedirect("./welcome.jsp");
        } else {
            res.sendRedirect("./error.jsp");
        }
    }
}
