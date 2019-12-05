package com.company.project.model;

import javax.persistence.*;

@Table(name = "enterprise_hr")
public class EnterpriseHr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位名称（用户名
     */
    @Column(name = "enterprise_name")
    private String enterpriseName;

    /**
     * 单位联系人
     */
    @Column(name = "enterprise_contact_person")
    private String enterpriseContactPerson;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 登录密码（加密后
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
     * 获取单位名称（用户名
     *
     * @return enterprise_name - 单位名称（用户名
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置单位名称（用户名
     *
     * @param enterpriseName 单位名称（用户名
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * 获取单位联系人
     *
     * @return enterprise_contact_person - 单位联系人
     */
    public String getEnterpriseContactPerson() {
        return enterpriseContactPerson;
    }

    /**
     * 设置单位联系人
     *
     * @param enterpriseContactPerson 单位联系人
     */
    public void setEnterpriseContactPerson(String enterpriseContactPerson) {
        this.enterpriseContactPerson = enterpriseContactPerson;
    }

    /**
     * 获取联系电话
     *
     * @return contact_phone - 联系电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系电话
     *
     * @param contactPhone 联系电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 获取登录密码（加密后
     *
     * @return password - 登录密码（加密后
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码（加密后
     *
     * @param password 登录密码（加密后
     */
    public void setPassword(String password) {
        this.password = password;
    }
}