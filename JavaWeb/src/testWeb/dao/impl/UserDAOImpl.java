package testWeb.dao.impl;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import testWeb.dao.UserDAO;
import testWeb.db.DBConnect;
import testWeb.vo.HistoryItem;
import testWeb.vo.UserInfo;

import javax.servlet.http.Part;

public class UserDAOImpl implements UserDAO {
    public int queryByUserInfo(UserInfo userinfo) throws Exception {   //查询是否有当前用户
        int flag = 0;
        String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null;
        DBConnect dbc = null;
//下面是针对数据库的具体操作 try{
// 连接数据库
        try {
            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, userinfo.getUsername());//进行数据库查询操作
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
//查询出内容，将其与用户提交的内容对比
                if (rs.getString("password").equals(userinfo.getPassword())) {

                    flag = 1;
                }
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
//关闭数据库连接
            dbc.close();
        }
        return flag;
    }

    public UserInfo queryByUsername(String username) throws Exception { //返回当前用户所有信息
        DBConnect dbs = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserInfo userinfo = null;
        try {
            dbs = new DBConnect();
            String sql = "select * from userinfo where username=?";
            pstmt = dbs.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                userinfo = new UserInfo();
                userinfo.setUserinfoid(rs.getInt("userinfoid"));
                userinfo.setUsername(rs.getString("username"));
                userinfo.setPassword(rs.getString("password"));
                userinfo.setRobotname(rs.getString("robotname"));
                userinfo.setRobotmodel(rs.getString("robotmodel"));

            }
        } finally {
            dbs.close();
        }
        return userinfo;
    }
    public UserInfo queryByUserinfoid(String userinfoid) throws Exception { //返回当前用户所有信息
        DBConnect dbs = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserInfo userinfo = null;
        try {
            dbs = new DBConnect();
            String sql = "select * from userinfo where userinfoid=?";
            pstmt = dbs.getConnection().prepareStatement(sql);
            pstmt.setString(1, userinfoid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                userinfo = new UserInfo();
                userinfo.setUserinfoid(rs.getInt("userinfoid"));
                userinfo.setUsername(rs.getString("username"));
                userinfo.setPassword(rs.getString("password"));
                userinfo.setRobotname(rs.getString("robotname"));
                userinfo.setRobotmodel(rs.getString("robotmodel"));

            }
        } finally {
            dbs.close();
        }
        return userinfo;
    }
    public boolean updateUserInfo(UserInfo userInfo) {     //更新用户信息
        DBConnect dbc = null;
        PreparedStatement pstmt = null;
        boolean success = false;
        try {
            dbc=new DBConnect();
            // 创建更新语句
            String sql = "UPDATE userinfo SET username=?, password=?, robotname=? ,robotmodel=? WHERE userinfoid=?";
            pstmt = dbc.getConnection().prepareStatement(sql);
            // 设置参数
            pstmt.setString(1, userInfo.getUsername());
            pstmt.setString(2, userInfo.getPassword());
            pstmt.setString(3, userInfo.getRobotname());
            pstmt.setString(4, userInfo.getRobotmodel());
            pstmt.setInt(5, userInfo.getUserinfoid());

            // 执行更新操作
            int rowsAffected = pstmt.executeUpdate();
            // 判断更新是否成功
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接和释放资源
            dbc.close();
        }
        return success;
    }
    public boolean registerUserInfo(UserInfo userInfo) {     //注册新用户信息

        boolean success = false;
        String sql = "INSERT INTO userinfo (username, password,robotname,robotmodel,image) VALUES (?, ?,?,?,?)";
        DBConnect dbc = null;
        PreparedStatement stmt = null;

        // TODO: 将用户注册信息保存到数据库中
        try {
            dbc = new DBConnect();
            stmt = dbc.getConnection().prepareStatement(sql);
            stmt.setString(1, userInfo.getUsername());
            stmt.setString(2, userInfo.getPassword());
            stmt.setString(3, userInfo.getRobotname());
            stmt.setString(4, userInfo.getRobotmodel());
            stmt.setBlob(5,userInfo.getImage());






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

    public List<HistoryItem> getHistory(int userId) {  //查询比赛历史记录
        DBConnect dbc = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<HistoryItem> history = new ArrayList<>();
        String sql = "SELECT*  FROM history WHERE userinfoid = ?";
        try {
            // 注册MySQL驱动
            dbc = new DBConnect();
            stmt = dbc.getConnection().prepareStatement(sql);



            // 查询用户历史记录

            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            while (rs.next()) {

                HistoryItem item = new HistoryItem();
                item.setRobotName(rs.getString("robotname"));
                item.setDate(rs.getString("date"));
                item.setTime(rs.getString("time"));
                item.setTreasureNumber(rs.getString("treasurenumber"));
                item.setObj(rs.getString("object"));
                history.add(item);
            }

            System.out.println("User history retrieved");
        } catch (SQLException e) {
            // 处理数据库异常
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dbc != null) {
                dbc.close();
            }
        }
        return history;
    }

    public boolean deleteUserHistory(int userId) {  //删除比赛历史记录
        DBConnect dbc = null;
        PreparedStatement stmt = null;
        boolean succes=false;
        String sql = "delete   FROM history WHERE userinfoid = ?";
        try {
            // 注册MySQL驱动
            dbc = new DBConnect();
            stmt = dbc.getConnection().prepareStatement(sql);



            // 查询用户历史记录

            stmt.setInt(1, userId);

           stmt.execute();
            succes=true;


            System.out.println("User history deleted");
        } catch (SQLException e) {
            // 处理数据库异常
            e.printStackTrace();
        } finally {
            dbc.close();
        }
            // 关闭数据库连接
            return succes;
            }

    public boolean deleteUserInfo(int userId) {  //删除个人账号
        DBConnect dbc = null;
        PreparedStatement stmt = null;
        boolean succes=false;
        UserDAOImpl dao=new UserDAOImpl();
        String sql = "delete   FROM userinfo WHERE userinfoid = ?";
        try {
            // 注册MySQL驱动
            dao.deleteUserHistory(userId);
            dbc = new DBConnect();
            stmt = dbc.getConnection().prepareStatement(sql);



            // 查询用户历史记录

            stmt.setInt(1, userId);

            stmt.execute();
            succes=true;


            System.out.println("Userinfo deleted");
        } catch (SQLException e) {
            // 处理数据库异常
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        // 关闭数据库连接
        return succes;
    }

}