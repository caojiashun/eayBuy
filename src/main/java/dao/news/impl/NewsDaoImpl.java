package dao.news.impl;

import dao.news.NewsDao;
import entity.News;
import uitl.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {


    @Override
    public List<News> queryNews() throws SQLException {
        List<News> newsList = new ArrayList<>();
        News news = null;
        ResultSet rs = null;
        String sql = "select * from egou_news";
        rs = BaseDao.executeQuery(sql);
        while(rs.next()){
            news = new News();
            news.setAllNews(rs.getInt("EN_ID"));
            news.setEnTitle(rs.getString("EN_TITLE"));
            news.setEnContent(rs.getString("EN_CONTENT"));
            news.setEnCreateTime(rs.getTime("EN_CREATE_TIME"));
            newsList.add(news);
        }
        return newsList;
    }
}
