package service.user.impl;

import dao.news.NewsDao;
import dao.news.impl.NewsDaoImpl;
import entity.News;
import service.user.NewsService;

import java.sql.SQLException;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao;

    public NewsServiceImpl() {
        newsDao = new NewsDaoImpl();
    }

    @Override
    public List<News> queryNews() throws SQLException {
        return newsDao.queryNews();
    }
}
