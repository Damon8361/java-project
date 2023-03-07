package com.example.web_admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
//@Data --> 补全getter setter方法
@Data
public class User {
    private String userName;
    private String passWord;
}
