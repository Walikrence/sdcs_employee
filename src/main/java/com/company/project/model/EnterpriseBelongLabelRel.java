package com.company.project.model;

import javax.persistence.*;

@Table(name = "enterprise_belong_label_rel")
public class EnterpriseBelongLabelRel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位id
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    /**
     * 单位属于标签id
     */
    @Column(name = "enterprise_belong_label_id")
    private Integer enterpriseBelongLabelId;

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
     * 获取单位id
     *
     * @return enterprise_id - 单位id
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置单位id
     *
     * @param enterpriseId 单位id
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * 获取单位属于标签id
     *
     * @return enterprise_belong_label_id - 单位属于标签id
     */
    public Integer getEnterpriseBelongLabelId() {
        return enterpriseBelongLabelId;
    }

    /**
     * 设置单位属于标签id
     *
     * @param enterpriseBelongLabelId 单位属于标签id
     */
    public void setEnterpriseBelongLabelId(Integer enterpriseBelongLabelId) {
        this.enterpriseBelongLabelId = enterpriseBelongLabelId;
    }
}