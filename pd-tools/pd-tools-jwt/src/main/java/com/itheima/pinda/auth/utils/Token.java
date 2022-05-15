package com.itheima.pinda.auth.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  Token生成
 *
 */
@Data
@NoArgsConstructor  // 创建无参构造
@AllArgsConstructor
public class Token implements Serializable {
    private static final long serialVersionUID = -8482946147572784305L;
    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private String token;
    /**
     * 有效时间：单位：秒
     */
    @ApiModelProperty(value = "有效期")
    private Integer expire;

}
