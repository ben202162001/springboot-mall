package com.test.springbootmall.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account_user")
public class UserForHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private int userId;
    @Column(name = "User_Name")
    private String userName;
    @Column(name = "Password")
    private String password;
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "Create_time")
    private Date createTime;
    @Column(name = "Edit_time")
    private Date editTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}
