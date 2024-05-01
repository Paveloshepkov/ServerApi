package ru.novosoft.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel {

	@JsonProperty("tasks")
	private List<Tasks> tasks;

	public ResponseModel(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}
}
