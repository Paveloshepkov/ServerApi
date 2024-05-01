package ru.novosoft.model.MertEquipModel;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationalInfo{
	@JsonProperty("asset_status")
	private String assetStatus;

	@JsonProperty("suitable")
	private boolean suitable;

	@JsonProperty("exploit_object")
	private String exploitObject;

	@JsonProperty("cost_center_id")
	private String costCenterId;

	@JsonProperty("facility_name")
	private String facilityName;

	@JsonProperty("mt_acct_resp")
	private String mtAcctResp;

	@JsonProperty("asset_user")
	private String assetUser;

	@JsonProperty("metr_operation_type")
	private String metrOperationType;

	@JsonProperty("etalon_reg_no")
	private List<EtalonRegNo> etalonRegNo;

	@JsonProperty("verif_tool_flag")
	private boolean verifToolFlag;

	@JsonProperty("indicator_flag")
	private boolean indicatorFlag;

	@JsonProperty("sgroei_code")
	private String sgroeiCode;

	@JsonProperty("last_closed_we")
	private String lastClosedWe;

	public OperationalInfo(String assetStatus, boolean suitable, String exploitObject,
			String costCenterId, String facilityName, String mtAcctResp, String assetUser,
			String metrOperationType, List<EtalonRegNo> etalonRegNo, boolean verifToolFlag,
			boolean indicatorFlag, String sgroeiCode, String lastClosedWe) {
		this.assetStatus = assetStatus;
		this.suitable = suitable;
		this.exploitObject = exploitObject;
		this.costCenterId = costCenterId;
		this.facilityName = facilityName;
		this.mtAcctResp = mtAcctResp;
		this.assetUser = assetUser;
		this.metrOperationType = metrOperationType;
		this.etalonRegNo = etalonRegNo;
		this.verifToolFlag = verifToolFlag;
		this.indicatorFlag = indicatorFlag;
		this.sgroeiCode = sgroeiCode;
		this.lastClosedWe = lastClosedWe;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public boolean isSuitable() {
		return suitable;
	}

	public void setSuitable(boolean suitable) {
		this.suitable = suitable;
	}

	public String getExploitObject() {
		return exploitObject;
	}

	public void setExploitObject(String exploitObject) {
		this.exploitObject = exploitObject;
	}

	public String getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getMtAcctResp() {
		return mtAcctResp;
	}

	public void setMtAcctResp(String mtAcctResp) {
		this.mtAcctResp = mtAcctResp;
	}

	public String getAssetUser() {
		return assetUser;
	}

	public void setAssetUser(String assetUser) {
		this.assetUser = assetUser;
	}

	public String getMetrOperationType() {
		return metrOperationType;
	}

	public void setMetrOperationType(String metrOperationType) {
		this.metrOperationType = metrOperationType;
	}

	public List<EtalonRegNo> getEtalonRegNo() {
		return etalonRegNo;
	}

	public void setEtalonRegNo(List<EtalonRegNo> etalonRegNo) {
		this.etalonRegNo = etalonRegNo;
	}

	public boolean isVerifToolFlag() {
		return verifToolFlag;
	}

	public void setVerifToolFlag(boolean verifToolFlag) {
		this.verifToolFlag = verifToolFlag;
	}

	public boolean isIndicatorFlag() {
		return indicatorFlag;
	}

	public void setIndicatorFlag(boolean indicatorFlag) {
		this.indicatorFlag = indicatorFlag;
	}

	public String getSgroeiCode() {
		return sgroeiCode;
	}

	public void setSgroeiCode(String sgroeiCode) {
		this.sgroeiCode = sgroeiCode;
	}

	public String getLastClosedWe() {
		return lastClosedWe;
	}

	public void setLastClosedWe(String lastClosedWe) {
		this.lastClosedWe = lastClosedWe;
	}
}