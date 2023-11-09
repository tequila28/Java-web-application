package testWeb.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import testWeb.dao.impl.*;
import testWeb.vo.HistoryItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class UserHistoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

    }


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        int userinfoid=Integer.parseInt(req.getParameter("userinfoid"));

        UserDAOImpl dao=new UserDAOImpl();

        // 将history数据按行封装为一个List对象
        List<HistoryItem> historyItems = dao.getHistory(userinfoid);

        // 将historyItems设置为请求的属性
        req.setAttribute("historyItems", historyItems);
        // 转发请求到JSP页面
        req.getRequestDispatcher("./history.jsp").forward(req, res);



    }
}
