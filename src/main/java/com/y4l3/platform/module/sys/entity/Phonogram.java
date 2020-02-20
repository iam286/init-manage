package com.y4l3.platform.module.sys.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实体类
 *
 * @author Kay
 * @since 2020-02-20 10:54:09
 */
@Data
@Table(name = "app_phonetics")
public class Phonogram implements Serializable {
    private static final long serialVersionUID = -25375613770844076L;

    @Id
    private Object id;

    private String kk;
    
    private String ipa;
    
    private String dj;
    /**
    * 1:单元音monophthong,2:双元音diphthong,3:清辅音voiceless,4:浊辅音voiced
    */
    private Integer type;
    
    private String kkMp3Path;
    
    private String kkWavPath;
    
    private String ipaMp3Path;
    
    private String ipaWavPath;
    
    private String djMp3Path;
    
    private String djWavPath;
    
    private String desContent;
    
    private String imageUrl;
}