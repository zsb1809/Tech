package com.zhihua.tt.entity.expert;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhihua.tt.entity.BaseEntity;

@Entity
@Table(name="t_expert_inf")
public class Expert extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6284195552916541995L;
	
	
	@Column(name="expert_name",nullable=true)
	private String expertName ;
	
	@Column(name="expert_type",nullable=true)
	private int expertType;
	
	@Column(name="category_id",nullable=true)
	private long categoryId;
	
	@Column(name="company")
	private String company;
	
	@Column(name="sex")
	private int sex;
	
	@Column(name="age")
	private int age;
	
	@Column(name="education")
	private String education;
	
	@Column(name="work_year")
	private int workYear;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="post")  //职务
	private String post;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="area")
	private String area;
	
	@Column(name="work_field")
	private String workField;
	
	@Column(name="good_project")
	private String goodProject;
	
	@Column(name="achievement")
	private String achievement;
	
	@Column(name="synopsis")  //专家简介
	private String synopsis;
	
	@Column(name="column_id")  
	private String columnId;
	
	@Column(name="appoint_time")  
	private String appointTime;
	
	@Column(name="team_leader")  
	private String teamLeader;
	
	@Column(name="team_member")  
	private String teamMember;
	
	@Column(name="expert_id")  
	private long expertId;
	
	@Column(name="is_display")  
	private int is_display;
	
	@Column(name="browse_count")  
	private int browseCount;
	
	@Column(name="publisher" ,updatable=false)  
	private String publisher;
	
	@Column(name="pub_time" , updatable=false)  
	private Date pubTime;
	
	@Column(name="updater")  
	private String updater;
	
	@Column(name="update_time")  
	private Date updateTime;
	
	@Column(name="reviewer")  
	private String reviewer;
	
	@Column(name="review_time")  
	private Date reviewTime;
	
	@Column(name="result")   //审核结果
	private int result;
	
	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public int getExpertType() {
		return expertType;
	}

	public void setExpertType(int expertType) {
		this.expertType = expertType;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getWorkYear() {
		return workYear;
	}

	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getWorkField() {
		return workField;
	}

	public void setWorkField(String workField) {
		this.workField = workField;
	}

	public String getGoodProject() {
		return goodProject;
	}

	public void setGoodProject(String goodProject) {
		this.goodProject = goodProject;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(String teamMember) {
		this.teamMember = teamMember;
	}


	public long getExpertId() {
		return expertId;
	}

	public void setExpertId(long expertId) {
		this.expertId = expertId;
	}

	public int getIs_display() {
		return is_display;
	}

	public void setIs_display(int is_display) {
		this.is_display = is_display;
	}

	public int getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(int browseCount) {
		this.browseCount = browseCount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getPubTime() {
		return pubTime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getUpdateTime() {
		return updateTime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getReviewTime() {
		return reviewTime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="remark")  
	private String remark;
	
	
}
