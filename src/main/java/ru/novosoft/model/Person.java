package ru.novosoft.model;


import java.util.List;

public class Person {
	private String username;
	private String password;
	private String role;

	private List<MetrEquipItemModel> equipmentList;
	private List<Tasks> tasksList;

	public Person(String username, String password, String role,List<MetrEquipItemModel> equipmentList, List<Tasks> tasksList) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.equipmentList = equipmentList;
		this.tasksList = tasksList;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Tasks> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<Tasks> tasksList) {
		this.tasksList = tasksList;
	}

	public List<MetrEquipItemModel> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<MetrEquipItemModel> equipmentList) {
		this.equipmentList = equipmentList;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}

}