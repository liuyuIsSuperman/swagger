package com.auto.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yusheng
 * @date 2019/10/30 11:43
 */
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户名")
    public String userName;
    @ApiModelProperty("性别")
    public String sex;
}
