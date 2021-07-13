package com.ohshiro.portfolio.form;

import java.util.Date;
import java.util.List;

import com.ohshiro.portfolio.model.Department;
import com.ohshiro.portfolio.model.Salary;

import lombok.Data;

@Data
public class UserDetailForm {
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private Integer age;
	private Integer gender;
	private Department department;
	private List<Salary> salaryList;
}
