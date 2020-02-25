package org.chat.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zzp
 * @date 2020/2/25
 */
@Data
public class Question {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String question;

    @Getter @Setter
    private String split;

    @Getter @Setter
    private String answer;

    @Getter @Setter
    private Date createTime;

    @Getter @Setter
    private Date updateTime;

}
