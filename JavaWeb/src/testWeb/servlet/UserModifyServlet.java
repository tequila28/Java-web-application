package testWeb.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testWeb.dao.impl.*;
import testWeb.vo.UserInfo;
public class UserModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单提交的数据
        String userinfoid = request.getParameter("userinfoid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String robotname = request.getParameter("robotname");
        String robotmodel = request.getParameter("robotmodel");
        // 创建一个UserInfo对象，用于保存更新后的用户信息
        UserInfo updatedUserInfo = new UserInfo();
        UserInfo userInfo = null;
        updatedUserInfo.setUserinfoid(Integer.parseInt(userinfoid));
        updatedUserInfo.setUsername(username);
        updatedUserInfo.setPassword(password);
        updatedUserInfo.setRobotname(robotname);
        updatedUserInfo.setRobotmodel(robotmodel);
        // 调用DAO层的方法，更新数据库中的用户信息
        UserDAOImpl userInfoDAO = new  UserDAOImpl();
        UserDAOImpl dao = new UserDAOImpl();
        boolean success = userInfoDAO.updateUserInfo(updatedUserInfo);

        try{
            userInfo = dao.queryByUserinfoid(userinfoid);
        }catch (Exception e) {

            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);
        if (success) {
            // 更新成功，重定向到成功页面或其他操作
            response.sendRedirect("./welcome.jsp");
        } else {
            // 更新失败，重定向到失败页面或其他操作
            response.sendRedirect("./error.jsp");
        }
    }
}
