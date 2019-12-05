package com.company.project.model;

import javax.persistence.*;

public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位名称
     */
    @Column(name = "enterprise_name")
    private String enterpriseName;

    /**
     * 有效证件号
     */
    @Column(name = "valid_certificate_number")
    private String validCertificateNumber;

    /**
     * 注册资金
     */
    @Column(name = "register_fundation")
    private String registerFundation;

    /**
     * 行业分类（0-互联网，1-金融，2-教育，3-其他
     */
    @Column(name = "business_type")
    private String businessType;

    /**
     * 公司规模（0-50人以下，1-50～200人，2- 200～500人，3-500人以上
     */
    @Column(name = "enterprise_size")
    private String enterpriseSize;

    /**
     * 单位性质大类（0-国家机关及政府机构，1-事业单位，2-高等院校，3-国有企业，4-民营企业，5-外商投资企业，6-其他
     */
    @Column(name = "enterprise_property")
    private String enterpriseProperty;

    /**
     * 人事主管部门
     */
    @Column(name = "personnel_authority")
    private String personnelAuthority;

    /**
     * 单位所在地-省
     */
    @Column(name = "enterprise_location_province")
    private String enterpriseLocationProvince;

    /**
     * 单位所在地-市
     */
    @Column(name = "enterprise_location_city")
    private String enterpriseLocationCity;

    /**
     * 单位所在地-区
     */
    @Column(name = "enterprise_location_district")
    private String enterpriseLocationDistrict;

    /**
     * 所在地邮编
     */
    private String postcode;

    /**
     * 单位传真
     */
    @Column(name = "enterprise_fax")
    private String enterpriseFax;

    /**
     * 单位邮箱
     */
    @Column(name = "enterprise_email")
    private String enterpriseEmail;

    /**
     * 单位所属上级集团公司\n
     */
    @Column(name = "superior_enterprise")
    private String superiorEnterprise;

    /**
     * 单位详细地址
     */
    @Column(name = "enterprise_detail_address")
    private String enterpriseDetailAddress;

    /**
     * 联系电话
     */
    @Column(name = "enterprise_phone")
    private String enterprisePhone;

    /**
     * 公司主页
     */
    @Column(name = "enterprise_web_page")
    private String enterpriseWebPage;

    /**
     * 联系人姓名
     */
    @Column(name = "contact_person_name")
    private String contactPersonName;

    /**
     * 联系人手机
     */
    @Column(name = "contact_person_teltphone")
    private String contactPersonTeltphone;

    /**
     * 联系人电话
     */
    @Column(name = "contact_person_phone")
    private String contactPersonPhone;

    /**
     * 联系人邮箱
     */
    @Column(name = "contact_peron_email")
    private String contactPeronEmail;

    /**
     * 是否审核（0-未审核，1-审核通过，2-审核失败
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
     * 获取单位名称
     *
     * @return enterprise_name - 单位名称
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置单位名称
     *
     * @param enterpriseName 单位名称
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * 获取有效证件号
     *
     * @return valid_certificate_number - 有效证件号
     */
    public String getValidCertificateNumber() {
        return validCertificateNumber;
    }

    /**
     * 设置有效证件号
     *
     * @param validCertificateNumber 有效证件号
     */
    public void setValidCertificateNumber(String validCertificateNumber) {
        this.validCertificateNumber = validCertificateNumber;
    }

    /**
     * 获取注册资金
     *
     * @return register_fundation - 注册资金
     */
    public String getRegisterFundation() {
        return registerFundation;
    }

    /**
     * 设置注册资金
     *
     * @param registerFundation 注册资金
     */
    public void setRegisterFundation(String registerFundation) {
        this.registerFundation = registerFundation;
    }

    /**
     * 获取行业分类（0-互联网，1-金融，2-教育，3-其他
     *
     * @return business_type - 行业分类（0-互联网，1-金融，2-教育，3-其他
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置行业分类（0-互联网，1-金融，2-教育，3-其他
     *
     * @param businessType 行业分类（0-互联网，1-金融，2-教育，3-其他
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取公司规模（0-50人以下，1-50～200人，2- 200～500人，3-500人以上
     *
     * @return enterprise_size - 公司规模（0-50人以下，1-50～200人，2- 200～500人，3-500人以上
     */
    public String getEnterpriseSize() {
        return enterpriseSize;
    }

    /**
     * 设置公司规模（0-50人以下，1-50～200人，2- 200～500人，3-500人以上
     *
     * @param enterpriseSize 公司规模（0-50人以下，1-50～200人，2- 200～500人，3-500人以上
     */
    public void setEnterpriseSize(String enterpriseSize) {
        this.enterpriseSize = enterpriseSize;
    }

    /**
     * 获取单位性质大类（0-国家机关及政府机构，1-事业单位，2-高等院校，3-国有企业，4-民营企业，5-外商投资企业，6-其他
     *
     * @return enterprise_property - 单位性质大类（0-国家机关及政府机构，1-事业单位，2-高等院校，3-国有企业，4-民营企业，5-外商投资企业，6-其他
     */
    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    /**
     * 设置单位性质大类（0-国家机关及政府机构，1-事业单位，2-高等院校，3-国有企业，4-民营企业，5-外商投资企业，6-其他
     *
     * @param enterpriseProperty 单位性质大类（0-国家机关及政府机构，1-事业单位，2-高等院校，3-国有企业，4-民营企业，5-外商投资企业，6-其他
     */
    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty;
    }

    /**
     * 获取人事主管部门
     *
     * @return personnel_authority - 人事主管部门
     */
    public String getPersonnelAuthority() {
        return personnelAuthority;
    }

    /**
     * 设置人事主管部门
     *
     * @param personnelAuthority 人事主管部门
     */
    public void setPersonnelAuthority(String personnelAuthority) {
        this.personnelAuthority = personnelAuthority;
    }

    /**
     * 获取单位所在地-省
     *
     * @return enterprise_location_province - 单位所在地-省
     */
    public String getEnterpriseLocationProvince() {
        return enterpriseLocationProvince;
    }

    /**
     * 设置单位所在地-省
     *
     * @param enterpriseLocationProvince 单位所在地-省
     */
    public void setEnterpriseLocationProvince(String enterpriseLocationProvince) {
        this.enterpriseLocationProvince = enterpriseLocationProvince;
    }

    /**
     * 获取单位所在地-市
     *
     * @return enterprise_location_city - 单位所在地-市
     */
    public String getEnterpriseLocationCity() {
        return enterpriseLocationCity;
    }

    /**
     * 设置单位所在地-市
     *
     * @param enterpriseLocationCity 单位所在地-市
     */
    public void setEnterpriseLocationCity(String enterpriseLocationCity) {
        this.enterpriseLocationCity = enterpriseLocationCity;
    }

    /**
     * 获取单位所在地-区
     *
     * @return enterprise_location_district - 单位所在地-区
     */
    public String getEnterpriseLocationDistrict() {
        return enterpriseLocationDistrict;
    }

    /**
     * 设置单位所在地-区
     *
     * @param enterpriseLocationDistrict 单位所在地-区
     */
    public void setEnterpriseLocationDistrict(String enterpriseLocationDistrict) {
        this.enterpriseLocationDistrict = enterpriseLocationDistrict;
    }

    /**
     * 获取所在地邮编
     *
     * @return postcode - 所在地邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置所在地邮编
     *
     * @param postcode 所在地邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 获取单位传真
     *
     * @return enterprise_fax - 单位传真
     */
    public String getEnterpriseFax() {
        return enterpriseFax;
    }

    /**
     * 设置单位传真
     *
     * @param enterpriseFax 单位传真
     */
    public void setEnterpriseFax(String enterpriseFax) {
        this.enterpriseFax = enterpriseFax;
    }

    /**
     * 获取单位邮箱
     *
     * @return enterprise_email - 单位邮箱
     */
    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    /**
     * 设置单位邮箱
     *
     * @param enterpriseEmail 单位邮箱
     */
    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    /**
     * 获取单位所属上级集团公司\n
     *
     * @return superior_enterprise - 单位所属上级集团公司\n
     */
    public String getSuperiorEnterprise() {
        return superiorEnterprise;
    }

    /**
     * 设置单位所属上级集团公司\n
     *
     * @param superiorEnterprise 单位所属上级集团公司\n
     */
    public void setSuperiorEnterprise(String superiorEnterprise) {
        this.superiorEnterprise = superiorEnterprise;
    }

    /**
     * 获取单位详细地址
     *
     * @return enterprise_detail_address - 单位详细地址
     */
    public String getEnterpriseDetailAddress() {
        return enterpriseDetailAddress;
    }

    /**
     * 设置单位详细地址
     *
     * @param enterpriseDetailAddress 单位详细地址
     */
    public void setEnterpriseDetailAddress(String enterpriseDetailAddress) {
        this.enterpriseDetailAddress = enterpriseDetailAddress;
    }

    /**
     * 获取联系电话
     *
     * @return enterprise_phone - 联系电话
     */
    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    /**
     * 设置联系电话
     *
     * @param enterprisePhone 联系电话
     */
    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    /**
     * 获取公司主页
     *
     * @return enterprise_web_page - 公司主页
     */
    public String getEnterpriseWebPage() {
        return enterpriseWebPage;
    }

    /**
     * 设置公司主页
     *
     * @param enterpriseWebPage 公司主页
     */
    public void setEnterpriseWebPage(String enterpriseWebPage) {
        this.enterpriseWebPage = enterpriseWebPage;
    }

    /**
     * 获取联系人姓名
     *
     * @return contact_person_name - 联系人姓名
     */
    public String getContactPersonName() {
        return contactPersonName;
    }

    /**
     * 设置联系人姓名
     *
     * @param contactPersonName 联系人姓名
     */
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    /**
     * 获取联系人手机
     *
     * @return contact_person_teltphone - 联系人手机
     */
    public String getContactPersonTeltphone() {
        return contactPersonTeltphone;
    }

    /**
     * 设置联系人手机
     *
     * @param contactPersonTeltphone 联系人手机
     */
    public void setContactPersonTeltphone(String contactPersonTeltphone) {
        this.contactPersonTeltphone = contactPersonTeltphone;
    }

    /**
     * 获取联系人电话
     *
     * @return contact_person_phone - 联系人电话
     */
    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    /**
     * 设置联系人电话
     *
     * @param contactPersonPhone 联系人电话
     */
    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    /**
     * 获取联系人邮箱
     *
     * @return contact_peron_email - 联系人邮箱
     */
    public String getContactPeronEmail() {
        return contactPeronEmail;
    }

    /**
     * 设置联系人邮箱
     *
     * @param contactPeronEmail 联系人邮箱
     */
    public void setContactPeronEmail(String contactPeronEmail) {
        this.contactPeronEmail = contactPeronEmail;
    }

    /**
     * 获取是否审核（0-未审核，1-审核通过，2-审核失败
     *
     * @return is_review - 是否审核（0-未审核，1-审核通过，2-审核失败
     */
    public String getIsReview() {
        return isReview;
    }

    /**
     * 设置是否审核（0-未审核，1-审核通过，2-审核失败
     *
     * @param isReview 是否审核（0-未审核，1-审核通过，2-审核失败
     */
    public void setIsReview(String isReview) {
        this.isReview = isReview;
    }
}