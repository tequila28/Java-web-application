package testWeb.vo;

public class HistoryItem {
    private String robotName;
    private String date;
    private String time;
    private String treasureNumber;
    private String obj;
    private int userinfoid;

    public  HistoryItem(){

    }
    public HistoryItem(String robotName, String date, String time, String treasureNumber,String obj) {
        this.robotName = robotName;
        this.date = date;
        this.time = time;
        this.treasureNumber = treasureNumber;
        this.obj=obj;
    }

    public String getDate() {
        return date;
    }

    public String getRobotName() {
        return robotName;
    }

    public String getTime() {
        return time;
    }

    public String getTreasureNumber() {
        return treasureNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTreasureNumber(String treasureNumber) {
        this.treasureNumber = treasureNumber;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public void setUserinfoid(int userinfoid) {
        this.userinfoid = userinfoid;
    }

    public int getUserinfoid() {
        return userinfoid;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getObj() {
        return obj;
    }
    // 添加getter和setter方法
}