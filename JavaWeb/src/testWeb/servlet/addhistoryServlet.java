package testWeb.servlet;

import testWeb.dao.impl.RobotDAOlmpl;
import testWeb.vo.HistoryItem;
import testWeb.vo.HistoryItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addhistoryServlet extends HttpServlet {

    private static final long serialVersionUTD = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        boolean success = false;
        HistoryItem robotInfo = new HistoryItem();
        RobotDAOlmpl dao = new RobotDAOlmpl();
        robotInfo.setRobotName(req.getParameter("robotname"));
        robotInfo.setDate(req.getParameter("date"));
        robotInfo.setTime(req.getParameter("time"));
        robotInfo.setTreasureNumber(req.getParameter("treasurenumber"));
        robotInfo.setObj(req.getParameter("object"));
        robotInfo.setUserinfoid(Integer.parseInt(req.getParameter("userinfoid")));
        try {

            success = dao.addRobotInfo(robotInfo);

        } catch (Exception e) {
            e.getStackTrace();
        }
        if (success == true) {
            resp.sendRedirect("./welcome.jsp");
        } else {
            return;
        }
    }

}
