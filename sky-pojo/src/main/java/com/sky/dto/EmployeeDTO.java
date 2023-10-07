package com.sky.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "添加员工的数据模型")
public class EmployeeDTO implements Serializable {
    @Schema(description = "主键Id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "电话号码")
    private String phone;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "身份证")
    private String idNumber;
}
