package testWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testWeb.dao.impl.*;
public class UserinfoDeleteServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

    }


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        int userinfoid = Integer.parseInt(req.getParameter("userinfoid"));
        UserDAOImpl dao = new UserDAOImpl();
        boolean success = dao.deleteUserInfo(userinfoid);
        if (success == true) {
            res.sendRedirect("./index.jsp");

        } else {
            res.sendRedirect("./error.jsp");
        }


    }
}


