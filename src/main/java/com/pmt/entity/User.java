package com.pmt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String company;

    @Column
    private String department;

    @Column
    private String phone;

    @Column
    private  String wechat;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Integer status; // 1在职， 0 离职

    @Column
    private Date createTime;

}
