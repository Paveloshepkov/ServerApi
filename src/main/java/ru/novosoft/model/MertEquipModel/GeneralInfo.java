package ru.novosoft.model.MertEquipModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneralInfo {
	@JsonProperty("id")
	private int id;

	@JsonProperty("serial_no")
	private String serialNo;

	@JsonProperty("inventory_no")
	private String inventoryNo;

	@JsonProperty("mt_kind")
	private String mtKind;

	@JsonProperty("mt_name")
	private String mtName;

	@JsonProperty("mt_type_designation")
	private String mtTypeDesignation;

	@JsonProperty("equip_model_name")
	private String equipModelName;

	@JsonProperty("mt_modification_name")
	private String mtModificationName;

	@JsonProperty("reg_no")
	private String regNo;

	@JsonProperty("manufacturer")
	private String manufacturer;

	@JsonProperty("manufacture_date")
	private String manufactureDate;

	public GeneralInfo(int id, String serialNo, String inventoryNo, String mtKind, String mtName, String mtTypeDesignation, String equipModelName, String mtModificationName, String regNo, String manufacturer, String manufactureDate) {
		this.id = id;
		this.serialNo = serialNo;
		this.inventoryNo = inventoryNo;
		this.mtKind = mtKind;
		this.mtName = mtName;
		this.mtTypeDesignation = mtTypeDesignation;
		this.equipModelName = equipModelName;
		this.mtModificationName = mtModificationName;
		this.regNo = regNo;
		this.manufacturer = manufacturer;
		this.manufactureDate = manufactureDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getInventoryNo() {
		return inventoryNo;
	}

	public void setInventoryNo(String inventoryNo) {
		this.inventoryNo = inventoryNo;
	}

	public String getMtKind() {
		return mtKind;
	}

	public void setMtKind(String mtKind) {
		this.mtKind = mtKind;
	}

	public String getMtName() {
		return mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	public String getMtTypeDesignation() {
		return mtTypeDesignation;
	}

	public void setMtTypeDesignation(String mtTypeDesignation) {
		this.mtTypeDesignation = mtTypeDesignation;
	}

	public String getEquipModelName() {
		return equipModelName;
	}

	public void setEquipModelName(String equipModelName) {
		this.equipModelName = equipModelName;
	}

	public String getMtModificationName() {
		return mtModificationName;
	}

	public void setMtModificationName(String mtModificationName) {
		this.mtModificationName = mtModificationName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return "GeneralInfo{" +
				"id=" + id +
				", serialNo='" + serialNo + '\'' +
				", inventoryNo='" + inventoryNo + '\'' +
				", mtKind='" + mtKind + '\'' +
				", mtName='" + mtName + '\'' +
				", mtTypeDesignation='" + mtTypeDesignation + '\'' +
				", equipModelName='" + equipModelName + '\'' +
				", mtModificationName='" + mtModificationName + '\'' +
				", regNo='" + regNo + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				", manufactureDate='" + manufactureDate + '\'' +
				'}';
	}
}

