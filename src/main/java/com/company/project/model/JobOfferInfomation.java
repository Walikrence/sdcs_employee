package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "job_offer_infomation")
public class JobOfferInfomation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 招聘信息发布hr_id
     */
    @Column(name = "hr_id")
    private Integer hrId;

    /**
     * 招聘主题
     */
    private String theme;

    /**
     * 岗位类型(0-实习，1-正式，2-实习和正式
     */
    @Column(name = "job_type")
    private String jobType;

    /**
     * 申请开始时间
     */
    @Column(name = "apply_start_time")
    private Date applyStartTime;

    /**
     * 简历投递截止时间
     */
    @Column(name = "apply_end_time")
    private Date applyEndTime;

    /**
     * 招聘简章（富文本
     */
    @Column(name = "job_post")
    private String jobPost;

    /**
     * 是否审核（0-未审核，1-审核通过，2-审核不通过
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
     * 获取招聘信息发布hr_id
     *
     * @return hr_id - 招聘信息发布hr_id
     */
    public Integer getHrId() {
        return hrId;
    }

    /**
     * 设置招聘信息发布hr_id
     *
     * @param hrId 招聘信息发布hr_id
     */
    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    /**
     * 获取招聘主题
     *
     * @return theme - 招聘主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 设置招聘主题
     *
     * @param theme 招聘主题
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 获取岗位类型(0-实习，1-正式，2-实习和正式
     *
     * @return job_type - 岗位类型(0-实习，1-正式，2-实习和正式
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * 设置岗位类型(0-实习，1-正式，2-实习和正式
     *
     * @param jobType 岗位类型(0-实习，1-正式，2-实习和正式
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * 获取申请开始时间
     *
     * @return apply_start_time - 申请开始时间
     */
    public Date getApplyStartTime() {
        return applyStartTime;
    }

    /**
     * 设置申请开始时间
     *
     * @param applyStartTime 申请开始时间
     */
    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    /**
     * 获取简历投递截止时间
     *
     * @return apply_end_time - 简历投递截止时间
     */
    public Date getApplyEndTime() {
        return applyEndTime;
    }

    /**
     * 设置简历投递截止时间
     *
     * @param applyEndTime 简历投递截止时间
     */
    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    /**
     * 获取招聘简章（富文本
     *
     * @return job_post - 招聘简章（富文本
     */
    public String getJobPost() {
        return jobPost;
    }

    /**
     * 设置招聘简章（富文本
     *
     * @param jobPost 招聘简章（富文本
     */
    public void setJobPost(String jobPost) {
        this.jobPost = jobPost;
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