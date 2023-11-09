package testWeb.dao.impl;

import testWeb.dao.RobotDAO;
import testWeb.db.DBConnect;
import testWeb.vo.HistoryItem;
import testWeb.vo.HistoryItem;
import testWeb.vo.UserInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RobotDAOlmpl {
    public boolean addRobotInfo(HistoryItem robotInfo) {     //添加历史记录信息

        boolean success = false;
        String sql = "INSERT INTO history (robotname,date,time,treasurenumber,object,userinfoid) VALUES (?,?, ?,?,?,?)";
        DBConnect dbc = null;
        PreparedStatement stmt = null;

        try {
            dbc = new DBConnect();
            stmt = dbc.getConnection().prepareStatement(sql);

            stmt.setString(1, robotInfo.getRobotName());
            stmt.setString(2, robotInfo.getDate());
            stmt.setString(3, robotInfo.getTime());
            stmt.setString(4, robotInfo.getTreasureNumber());
            stmt.setString(5, robotInfo.getObj());
            stmt.setInt(6, robotInfo.getUserinfoid());


            int register = stmt.executeUpdate();

            if (register > 0) {
                success = true;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
//关闭数据库连接
            dbc.close();
            return success;
        }

    }
}