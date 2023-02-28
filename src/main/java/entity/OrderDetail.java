package entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (EgouOrderDetail)实体类
 *
 * @author makejava
 * @since 2023-02-17 14:38:18
 */
@Data
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 369309548144271192L;
    
    private Integer eodId;
    
    private Integer eoId;
    
    private Integer epId;
    
    private Integer eodQuantity;
    
    private Date eodCost;

    

}

