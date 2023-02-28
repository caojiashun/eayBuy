package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (EgouProductCategory)实体类
 *
 * @author makejava
 * @since 2023-02-17 14:38:26
 */
@Data
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = -14951850398281824L;
    
    private Long  epcId;
    
    private String epcName;
    
    private Long  epcParentId;
    /**
     * 0-删除，1-正常
     */
    private Integer epcStatus;

    
}

