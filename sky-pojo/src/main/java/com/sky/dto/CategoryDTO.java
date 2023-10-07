package com.sky.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private Integer type;
    private String name;
    private Integer sort;
}
