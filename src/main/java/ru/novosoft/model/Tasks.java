package ru.novosoft.model;


public class Tasks {

	private Integer id;
	private String type;
	private String time;

	public Tasks(Integer id, String type, String time) {
		this.id = id;
		this.type = type;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Tasks{" +
				"id=" + id +
				", type='" + type + '\'' +
				", time='" + time + '\'' +
				'}';
	}
}