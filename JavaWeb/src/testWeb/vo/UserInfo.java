package testWeb.vo;

import com.mysql.cj.jdbc.Blob;

import java.io.InputStream;

public class UserInfo {

    private int userinfoid;
    private  String username;
    private  String password;
    private  String robotname;
    private  String robotmodel;
    private Blob image;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getUserinfoid() {
        return userinfoid;
    }

    public String getRobotname() {
        return robotname;
    }

    public void setRobotname(String robotname) {
        this.robotname = robotname;
    }

    public void setUserinfoid(int userinfoid) {
        this.userinfoid = userinfoid;
    }

    public String getRobotmodel() {
        return robotmodel;
    }

    public void setRobotmodel(String robotmodel) {
        this.robotmodel = robotmodel;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Blob getImage() {
        return image;
    }
}
