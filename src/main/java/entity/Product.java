package entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (EgouProduct)实体类
 *
 * @author makejava
 * @since 2023-02-17 14:38:22
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = -88642728573249088L;
    
    private Integer epId;
    
    private String epName;
    
    private String epDescription;
    
    private Double epPrice;
    
    private Integer epStock;
    
    private Integer epcId;
    
    private String epFileName;
    /**
     * 0-删除，1-正常
     */
    private Integer epStatus;

    
}

