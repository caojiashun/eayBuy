package dao.gwc;

import entity.Gwc;
import uitl.PageUtils;

import java.util.List;

public interface GwcDao {
    //分页
    List<Gwc> getGwcPage(PageUtils<Gwc> pages);
    int getGwcCount(PageUtils<Gwc> pages);
    int addGwc(Gwc gwc);
    int updateGwc(Gwc gwc);
    int deleteGwc(Integer id);
}
