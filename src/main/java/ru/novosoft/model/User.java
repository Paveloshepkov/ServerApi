package ru.novosoft.model;


import java.util.List;

public class User {
	private String username;
	private String password;

	private List<Tasks> tasksList;
	private List<MetrEquipItemModel> equipmentList;

	public User(String username, String password, List<Tasks> tasksList,
			List<MetrEquipItemModel> equipmentList) {
		this.username = username;
		this.password = password;
		this.tasksList = tasksList;
		this.equipmentList = equipmentList;
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