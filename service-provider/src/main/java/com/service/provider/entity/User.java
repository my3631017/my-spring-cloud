package com.service.provider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-10-30 10:59
 * @version: 1.0
 */
@Data
public class User implements Serializable {
    private String username;
    private Integer age;
    private String birth;
}
