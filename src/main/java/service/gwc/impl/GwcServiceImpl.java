package service.gwc.impl;

import dao.gwc.GwcDao;
import dao.gwc.impl.GwcDaoImpl;
import entity.Gwc;
import service.gwc.GwcService;
import uitl.PageUtils;

import java.util.List;

public class GwcServiceImpl implements GwcService {
    private GwcDao gwcDao;

    public GwcServiceImpl() {
        gwcDao = new GwcDaoImpl();
    }

    @Override
    public PageUtils<Gwc> getGwcPage(PageUtils<Gwc> page) {
        page.setPageCount(gwcDao.getGwcCount(page));
        page.setResultList(gwcDao.getGwcPage(page));
        return page;
    }

    @Override
    public int addGwc(Gwc gwc) {
        return gwcDao.addGwc(gwc);
    }

    @Override
    public int updateGwc(Gwc gwc) {
        return 0;
    }

    @Override
    public int deleteGwc(Integer id) {
        return 0;
    }
}
