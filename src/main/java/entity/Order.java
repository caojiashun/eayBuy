package entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (EgouOrder)实体类
 *
 * @author makejava
 * @since 2023-02-17 14:38:14
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 471264583855232651L;
    
    private Integer eoId;
    
    private String eoUserId;
    
    private String eoUserName;
    
    private String eoUserAddress;
    
    private Date eoCreateTime;
    
    private Date eoCost;
    
    private Integer eoStatus;
    
    private Integer eoType;
    
}

