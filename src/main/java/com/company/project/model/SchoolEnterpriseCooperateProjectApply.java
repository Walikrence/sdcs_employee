package com.company.project.model;

import javax.persistence.*;

@Table(name = "school_enterprise_cooperate_project_apply")
public class SchoolEnterpriseCooperateProjectApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 申请的hr的id
     */
    @Column(name = "hr_id")
    private Integer hrId;

    /**
     * 校企合作项目id
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 申请原因
     */
    @Column(name = "apply_reason")
    private String applyReason;

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
     * 获取申请的hr的id
     *
     * @return hr_id - 申请的hr的id
     */
    public Integer getHrId() {
        return hrId;
    }

    /**
     * 设置申请的hr的id
     *
     * @param hrId 申请的hr的id
     */
    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    /**
     * 获取校企合作项目id
     *
     * @return project_id - 校企合作项目id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置校企合作项目id
     *
     * @param projectId 校企合作项目id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取申请原因
     *
     * @return apply_reason - 申请原因
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * 设置申请原因
     *
     * @param applyReason 申请原因
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
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
}