package com.kh.jdbc.vo;

import java.util.Date;

public class MemberGrade {
	private int gradeCode;
	
	private String gradeName;
	
	private Date createDate;
	
	public MemberGrade() {
	}

	public int getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "MemberGrade [gradeCode=" + gradeCode + ", gradeName=" + gradeName + ", createDate=" + createDate + "]";
	}
}
