package com.pmt.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 8171702806177373142L;

    private Integer id;

    private String name;

    private String company;

    private String department;

    private String phone;

    private  String wechat;

    private String username;

    private String password;

    private Integer status;

    private Date createTime;
}
