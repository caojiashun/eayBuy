package service.user;

import entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsService {
    List<News> queryNews() throws SQLException;
}
