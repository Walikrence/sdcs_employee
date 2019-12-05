package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "enterprise_belong_label")
public class EnterpriseBelongLabel {
    /**
     * 单位属于标签id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位属于标签名称
     */
    @Column(name = "label_name")
    private String labelName;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 获取单位属于标签id
     *
     * @return id - 单位属于标签id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置单位属于标签id
     *
     * @param id 单位属于标签id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取单位属于标签名称
     *
     * @return label_name - 单位属于标签名称
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * 设置单位属于标签名称
     *
     * @param labelName 单位属于标签名称
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}