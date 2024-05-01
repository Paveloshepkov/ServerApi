package ru.novosoft.model.MertEquipModel;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Composition {
	@JsonProperty("mt_type")
	private String mtType;

	@JsonProperty("id")
	private String id;

	@JsonProperty("serial_no")
	private String serialNo;

	@JsonProperty("inventory_no")
	private String inventoryNo;

	@JsonProperty("mt_acct_resp")
	private String mtAcctResp;

	@JsonProperty("manufacture_date")
	private String manufactureDate;

	@JsonProperty("last_closed_we")
	private String lastClosedWe;

	public Composition(String mtType, String id, String serialNo, String inventoryNo, String mtAcctResp, String manufactureDate, String lastClosedWe) {
		this.mtType = mtType;
		this.id = id;
		this.serialNo = serialNo;
		this.inventoryNo = inventoryNo;
		this.mtAcctResp = mtAcctResp;
		this.manufactureDate = manufactureDate;
		this.lastClosedWe = lastClosedWe;
	}

	public String getMtType() {
		return mtType;
	}

	public void setMtType(String mtType) {
		this.mtType = mtType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getMtAcctResp() {
		return mtAcctResp;
	}

	public void setMtAcctResp(String mtAcctResp) {
		this.mtAcctResp = mtAcctResp;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getLastClosedWe() {
		return lastClosedWe;
	}

	public void setLastClosedWe(String lastClosedWe) {
		this.lastClosedWe = lastClosedWe;
	}

	@Override
	public String toString() {
		return "Composition{" +
				"mtType='" + mtType + '\'' +
				", id='" + id + '\'' +
				", serialNo='" + serialNo + '\'' +
				", inventoryNo='" + inventoryNo + '\'' +
				", mtAcctResp='" + mtAcctResp + '\'' +
				", manufactureDate='" + manufactureDate + '\'' +
				", lastClosedWe='" + lastClosedWe + '\'' +
				'}';
	}
}

