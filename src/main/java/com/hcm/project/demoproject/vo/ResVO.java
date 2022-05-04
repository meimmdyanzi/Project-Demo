package com.hcm.project.demoproject.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @description:
 * @author: josnhuang
 * @CodeReviewer: josnhuang
 * @CreateTime 2022/5/1 22:30
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResVO {
    String resCode;
    String resMsg;
}
