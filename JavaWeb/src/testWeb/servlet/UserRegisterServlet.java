package testWeb.servlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.mysql.cj.jdbc.Blob;
import testWeb.dao.impl.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;

import testWeb.db.DBConnect;
import testWeb.vo.UserInfo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;



public class UserRegisterServlet extends HttpServlet {


        private static final long serialVersionUID = 1L;

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            boolean success = false;

            UserInfo userinfo = new UserInfo();
            UserDAOImpl dao = new UserDAOImpl();
            userinfo.setUsername(request.getParameter("username"));
            userinfo.setPassword(request.getParameter("password"));
            userinfo.setRobotname(request.getParameter("robotname"));
            userinfo.setRobotmodel(request.getParameter("robotmodel"));





            File file = new File("C:\\Users\\86159\\Desktop\\g.png");
            FileInputStream fis = new FileInputStream(file);
            DBConnect dbc=new DBConnect();
            Connection conn=dbc.getConnection();
            Blob blob= null;
            try {
                blob = (Blob) conn.createBlob();
                blob.setBytes(1,fis.readAllBytes());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println((blob));
            userinfo.setImage(blob);





            try {
                success = dao.registerUserInfo(userinfo);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if ((success == true)) {
                response.sendRedirect("./registration-success.jsp");

            } else {
                response.sendRedirect("./error.jsp");

            }


        }
}
