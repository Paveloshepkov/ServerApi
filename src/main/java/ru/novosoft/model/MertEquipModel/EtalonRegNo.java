package ru.novosoft.model.MertEquipModel;

public class EtalonRegNo {
	private String regNo;
	private boolean notValidFlag;

	public EtalonRegNo(String regNo, boolean notValidFlag) {
		this.regNo = regNo;
		this.notValidFlag = notValidFlag;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public boolean isNotValidFlag() {
		return notValidFlag;
	}

	public void setNotValidFlag(boolean notValidFlag) {
		this.notValidFlag = notValidFlag;
	}

	@Override
	public String toString() {
		return "EtalonRegNo{" +
				"regNo='" + regNo + '\'' +
				", notValidFlag=" + notValidFlag +
				'}';
	}
}

