package service.gwc;

import entity.Gwc;
import uitl.PageUtils;

import java.util.List;

public interface GwcService {
    PageUtils<Gwc> getGwcPage(PageUtils<Gwc> page);
    int addGwc(Gwc gwc);
    int updateGwc(Gwc gwc);
    int deleteGwc(Integer id);
}
