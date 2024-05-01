package ru.novosoft.model.MertEquipModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wo {
	@JsonProperty("exec_div_or_org")
	private String execDivOrOrg;

	@JsonProperty("assignee_party")
	private String assigneeParty;

	@JsonProperty("origin")
	private String origin;

	@JsonProperty("asset_suitbl")
	private String assetSuitbl;

	@JsonProperty("we_status")
	private String weStatus;

	@JsonProperty("actual_finish_time")
	private String actualFinishTime;

	public Wo(String execDivOrOrg, String assigneeParty, String origin, String assetSuitbl, String weStatus, String actualFinishTime) {
		this.execDivOrOrg = execDivOrOrg;
		this.assigneeParty = assigneeParty;
		this.origin = origin;
		this.assetSuitbl = assetSuitbl;
		this.weStatus = weStatus;
		this.actualFinishTime = actualFinishTime;
	}

	public String getExecDivOrOrg() {
		return execDivOrOrg;
	}

	public void setExecDivOrOrg(String execDivOrOrg) {
		this.execDivOrOrg = execDivOrOrg;
	}

	public String getAssigneeParty() {
		return assigneeParty;
	}

	public void setAssigneeParty(String assigneeParty) {
		this.assigneeParty = assigneeParty;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getAssetSuitbl() {
		return assetSuitbl;
	}

	public void setAssetSuitbl(String assetSuitbl) {
		this.assetSuitbl = assetSuitbl;
	}

	public String getWeStatus() {
		return weStatus;
	}

	public void setWeStatus(String weStatus) {
		this.weStatus = weStatus;
	}

	public String getActualFinishTime() {
		return actualFinishTime;
	}

	public void setActualFinishTime(String actualFinishTime) {
		this.actualFinishTime = actualFinishTime;
	}

	@Override
	public String toString() {
		return "Wo{" +
				"execDivOrOrg='" + execDivOrOrg + '\'' +
				", assigneeParty='" + assigneeParty + '\'' +
				", origin='" + origin + '\'' +
				", assetSuitbl='" + assetSuitbl + '\'' +
				", weStatus='" + weStatus + '\'' +
				", actualFinishTime='" + actualFinishTime + '\'' +
				'}';
	}
}
