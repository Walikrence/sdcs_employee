package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "apply_place")
public class ApplyPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 申请hr的id
     */
    @Column(name = "hr_id")
    private Integer hrId;

    /**
     * 宣讲会主题
     */
    private String theme;

    /**
     * 宣讲会时间
     */
    @Column(name = "meeting_time")
    private Date meetingTime;

    /**
     * 宣讲持续时间（例如：两小时
     */
    @Column(name = "meeting_duration")
    private String meetingDuration;

    /**
     * 场地名称
     */
    @Column(name = "place_name")
    private String placeName;

    /**
     * 主要议程
     */
    @Column(name = "main_agenda")
    private String mainAgenda;

    /**
     * 招聘岗位及人数
     */
    @Column(name = "job_and_number")
    private String jobAndNumber;

    /**
     * 申请入校的汽车车牌号
     */
    @Column(name = "car_license_number_enter_school")
    private String carLicenseNumberEnterSchool;

    /**
     * 单位联系人
     */
    @Column(name = "enterprise_contact")
    private String enterpriseContact;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 审核状态：0-未审核，1-审核通过，2-审核不通过
     */
    @Column(name = "is_review")
    private String isReview;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

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
     * 获取申请hr的id
     *
     * @return hr_id - 申请hr的id
     */
    public Integer getHrId() {
        return hrId;
    }

    /**
     * 设置申请hr的id
     *
     * @param hrId 申请hr的id
     */
    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    /**
     * 获取宣讲会主题
     *
     * @return theme - 宣讲会主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 设置宣讲会主题
     *
     * @param theme 宣讲会主题
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 获取宣讲会时间
     *
     * @return meeting_time - 宣讲会时间
     */
    public Date getMeetingTime() {
        return meetingTime;
    }

    /**
     * 设置宣讲会时间
     *
     * @param meetingTime 宣讲会时间
     */
    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

    /**
     * 获取宣讲持续时间（例如：两小时
     *
     * @return meeting_duration - 宣讲持续时间（例如：两小时
     */
    public String getMeetingDuration() {
        return meetingDuration;
    }

    /**
     * 设置宣讲持续时间（例如：两小时
     *
     * @param meetingDuration 宣讲持续时间（例如：两小时
     */
    public void setMeetingDuration(String meetingDuration) {
        this.meetingDuration = meetingDuration;
    }

    /**
     * 获取场地名称
     *
     * @return place_name - 场地名称
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * 设置场地名称
     *
     * @param placeName 场地名称
     */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    /**
     * 获取主要议程
     *
     * @return main_agenda - 主要议程
     */
    public String getMainAgenda() {
        return mainAgenda;
    }

    /**
     * 设置主要议程
     *
     * @param mainAgenda 主要议程
     */
    public void setMainAgenda(String mainAgenda) {
        this.mainAgenda = mainAgenda;
    }

    /**
     * 获取招聘岗位及人数
     *
     * @return job_and_number - 招聘岗位及人数
     */
    public String getJobAndNumber() {
        return jobAndNumber;
    }

    /**
     * 设置招聘岗位及人数
     *
     * @param jobAndNumber 招聘岗位及人数
     */
    public void setJobAndNumber(String jobAndNumber) {
        this.jobAndNumber = jobAndNumber;
    }

    /**
     * 获取申请入校的汽车车牌号
     *
     * @return car_license_number_enter_school - 申请入校的汽车车牌号
     */
    public String getCarLicenseNumberEnterSchool() {
        return carLicenseNumberEnterSchool;
    }

    /**
     * 设置申请入校的汽车车牌号
     *
     * @param carLicenseNumberEnterSchool 申请入校的汽车车牌号
     */
    public void setCarLicenseNumberEnterSchool(String carLicenseNumberEnterSchool) {
        this.carLicenseNumberEnterSchool = carLicenseNumberEnterSchool;
    }

    /**
     * 获取单位联系人
     *
     * @return enterprise_contact - 单位联系人
     */
    public String getEnterpriseContact() {
        return enterpriseContact;
    }

    /**
     * 设置单位联系人
     *
     * @param enterpriseContact 单位联系人
     */
    public void setEnterpriseContact(String enterpriseContact) {
        this.enterpriseContact = enterpriseContact;
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
     * 获取审核状态：0-未审核，1-审核通过，2-审核不通过
     *
     * @return is_review - 审核状态：0-未审核，1-审核通过，2-审核不通过
     */
    public String getIsReview() {
        return isReview;
    }

    /**
     * 设置审核状态：0-未审核，1-审核通过，2-审核不通过
     *
     * @param isReview 审核状态：0-未审核，1-审核通过，2-审核不通过
     */
    public void setIsReview(String isReview) {
        this.isReview = isReview;
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