package com.company.project.model;

import javax.persistence.*;

@Table(name = "enterprise_certificate")
public class EnterpriseCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位id
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    /**
     * 单位证件扫描件url
     */
    @Column(name = "enterprise_certificate_scan_url")
    private String enterpriseCertificateScanUrl;

    /**
     * 是否审核（0-未审核，1-审核通过，2-审核不通过
     */
    @Column(name = "is_review")
    private String isReview;

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
     * 获取单位证件扫描件url
     *
     * @return enterprise_certificate_scan_url - 单位证件扫描件url
     */
    public String getEnterpriseCertificateScanUrl() {
        return enterpriseCertificateScanUrl;
    }

    /**
     * 设置单位证件扫描件url
     *
     * @param enterpriseCertificateScanUrl 单位证件扫描件url
     */
    public void setEnterpriseCertificateScanUrl(String enterpriseCertificateScanUrl) {
        this.enterpriseCertificateScanUrl = enterpriseCertificateScanUrl;
    }

    /**
     * 获取是否审核（0-未审核，1-审核通过，2-审核不通过
     *
     * @return is_review - 是否审核（0-未审核，1-审核通过，2-审核不通过
     */
    public String getIsReview() {
        return isReview;
    }

    /**
     * 设置是否审核（0-未审核，1-审核通过，2-审核不通过
     *
     * @param isReview 是否审核（0-未审核，1-审核通过，2-审核不通过
     */
    public void setIsReview(String isReview) {
        this.isReview = isReview;
    }
}