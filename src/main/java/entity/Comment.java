package entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (EgouComment)实体类
 *
 * @author makejava
 * @since 2023-02-17 14:35:59
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 128497209727718799L;
    
    private Integer ecId;
    
    private String ecContent;
    
    private Date ecCreateTime;
    
    private String ecReply;
    
    private Date ecReplyTime;
    
    private String ecNickName;
}

