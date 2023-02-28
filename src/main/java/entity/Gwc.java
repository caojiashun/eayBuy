package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (EgouGwc)实体类
 *
 * @author makejava
 * @since 2023-02-27 14:41:27
 */
@Data
public class Gwc implements Serializable {
    private static final long serialVersionUID = 930792865051522155L;
    
    private Integer id;
    
    private Integer epId;
    
    private Integer quantity;
    
    private String userId;
    
    private Integer status;
    private Product product;
}

