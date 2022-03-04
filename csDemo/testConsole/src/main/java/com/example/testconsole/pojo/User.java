package com.example.testconsole.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/2-15:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String account;
    private String password;
}
