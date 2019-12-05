package com.company.project.model;

import javax.persistence.*;

public class Alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别(0-女，1-男，2-未填写
     */
    private String sex;

    /**
     * 部门/职务
     */
    @Column(name = "department_postion")
    private String departmentPostion;

    /**
     * 毕业专业
     */
    @Column(name = "graduate_major")
    private String graduateMajor;

    /**
     * 毕业年份
     */
    @Column(name = "graduate_year")
    private String graduateYear;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 联系邮箱
     */
    @Column(name = "contact_email")
    private String contactEmail;

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
     * 获取企业id
     *
     * @return enterprise_id - 企业id
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业id
     *
     * @param enterpriseId 企业id
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别(0-女，1-男，2-未填写
     *
     * @return sex - 性别(0-女，1-男，2-未填写
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别(0-女，1-男，2-未填写
     *
     * @param sex 性别(0-女，1-男，2-未填写
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取部门/职务
     *
     * @return department_postion - 部门/职务
     */
    public String getDepartmentPostion() {
        return departmentPostion;
    }

    /**
     * 设置部门/职务
     *
     * @param departmentPostion 部门/职务
     */
    public void setDepartmentPostion(String departmentPostion) {
        this.departmentPostion = departmentPostion;
    }

    /**
     * 获取毕业专业
     *
     * @return graduate_major - 毕业专业
     */
    public String getGraduateMajor() {
        return graduateMajor;
    }

    /**
     * 设置毕业专业
     *
     * @param graduateMajor 毕业专业
     */
    public void setGraduateMajor(String graduateMajor) {
        this.graduateMajor = graduateMajor;
    }

    /**
     * 获取毕业年份
     *
     * @return graduate_year - 毕业年份
     */
    public String getGraduateYear() {
        return graduateYear;
    }

    /**
     * 设置毕业年份
     *
     * @param graduateYear 毕业年份
     */
    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
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
     * 获取联系邮箱
     *
     * @return contact_email - 联系邮箱
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 设置联系邮箱
     *
     * @param contactEmail 联系邮箱
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}