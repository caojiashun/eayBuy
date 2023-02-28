package dao.gwc.impl;

import dao.gwc.GwcDao;
import entity.Gwc;
import entity.Product;
import entity.User;
import uitl.BaseDao;
import uitl.PageUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GwcDaoImpl extends BaseDao implements GwcDao {
    ResultSet rs = null;
    @Override
    public List<Gwc> getGwcPage(PageUtils<Gwc> pages) {
        String sql = "select sc.id,sc.ep_id,sc.quantity,sc.user_id,sc.status,ep.* from egou_gwc sc join egou_product ep on sc.ep_id = ep.EP_ID where sc.status = 1 and sc.user_id = ? order by sc.id desc limit ?,?";
        ResultSet rs = null;
        List<Gwc> gwcs = new ArrayList<>();
        try {
            rs = executeQuery(sql, pages.getParam().get("userId"),(pages.getPageNo() - 1) * pages.getPageSize(), pages.getPageSize());
            while (rs.next()) {

                Gwc gwc = new Gwc();
                gwc.setId(rs.getInt("id"));
                gwc.setEpId(rs.getInt("ep_id"));
                gwc.setQuantity(rs.getInt("quantity"));
                gwc.setUserId(rs.getString("user_id"));
                gwc.setStatus(rs.getInt("status"));

                Product product = new Product();
                product.setEpId(rs.getInt("EP_ID"));
                product.setEpName(rs.getString("EP_NAME"));
                product.setEpDescription(rs.getString("EP_DESCRIPTION"));
                product.setEpPrice(rs.getDouble("EP_PRICE"));
                product.setEpStock(rs.getInt("EP_STOCK"));
                product.setEpcId(rs.getInt("EPC_ID"));
                product.setEpFileName(rs.getString("EP_FILE_NAME"));
                product.setEpStatus(rs.getInt("ep_status"));

                gwc.setProduct(product);
                gwcs.add(gwc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gwcs;
    }

    @Override
    public int getGwcCount(PageUtils<Gwc> pages) {
        int count = 0;
        ResultSet rs = null;
        String sql = "select count(1) from egou_gwc;";
        try {
            rs = BaseDao.executeQuery(sql);
            if (rs.next()) {
                count =  rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int addGwc(Gwc gwc) {
        String sql = "INSERT INTO `jsp_egou`.`egou_gwc`(`ep_id`, `quantity`, `user_id`, `status`, `sessionId`) VALUES (?,?,?,?,?);";
        Object[] param = {gwc.getEpId(),gwc.getQuantity(),gwc.getUserId(),gwc.getStatus()};
        return executeUpdate(sql,param);
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
