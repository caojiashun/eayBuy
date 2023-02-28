package dao.news;

import entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao {
    List<News> queryNews() throws SQLException;
}
