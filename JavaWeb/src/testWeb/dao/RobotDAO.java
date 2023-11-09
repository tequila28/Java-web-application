package testWeb.dao;

import testWeb.vo.HistoryItem;

public interface RobotDAO {
    public int queryByRobotInfo(HistoryItem robotInfo) throws Exception;
}
