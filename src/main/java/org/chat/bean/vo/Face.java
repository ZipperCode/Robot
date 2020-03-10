package org.chat.bean.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class Face {
    @Getter
    @Setter
    private String id;
    @Getter @Setter
    private String stuNumber;
    @Getter @Setter
    private String stuName;

}
