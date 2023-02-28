package entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (EgouNews)实体类
 *
 * @author makejava
 * @since 2023-02-17 14:38:03
 */
@Data
public class News implements Serializable {
    private static final long serialVersionUID = -86479615232953896L;
    
    private Integer allNews;
    
    private String enTitle;
    
    private String enContent;
    
    private Date enCreateTime;
    
}

