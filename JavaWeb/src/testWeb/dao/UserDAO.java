package testWeb.dao;
import testWeb.vo.*;
public interface UserDAO {
    public int queryByUserInfo(UserInfo userinfo ) throws Exception;
}
