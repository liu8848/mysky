package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryPageQueryDTO implements Serializable {
    private int page;

    private int size;

    private String name;

    private Integer type;
}
