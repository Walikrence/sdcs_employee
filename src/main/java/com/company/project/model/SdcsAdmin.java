package com.company.project.model;

import javax.persistence.*;

@Table(name = "sdcs_admin")
public class SdcsAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 管理员用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取管理员用户名
     *
     * @return username - 管理员用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置管理员用户名
     *
     * @param username 管理员用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}