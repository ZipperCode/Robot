package org.chat.bean.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zzp
 * @date 2020/2/26
 */
@Data
public class Common {
    /**
     * id
     */
    @Getter @Setter
    private Integer id;
    /**
     * 问题
     */
    @Getter @Setter
    private String question;
    /**
     * 回答
     */
    @Getter @Setter
    private String answer;
    /**
     * 创建时间
     */
    @Getter @Setter
    private Date createTime;
    /**
     * 修改时间
     */
    @Getter @Setter
    private Date updateTime;
}
