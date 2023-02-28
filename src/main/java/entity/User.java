package entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (EgouUser)实体类
 *
 * @author makejava
 * @since 2023-02-20 14:06:13
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -41665742495056251L;
    
    private String euUserId;
    
    private String euUserName;
    
    private String euPassword;
    
    private Integer euSex;
    
    private Date euBirthday;
    
    private String euIdentityCode;
    
    private String euEmail;
    
    private String euMobile;
    
    private String euAddress;
    
    private Integer euStatus = 1;
    
    private Integer euLogin;



}

