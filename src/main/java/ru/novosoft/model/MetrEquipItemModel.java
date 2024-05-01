package ru.novosoft.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.novosoft.model.MertEquipModel.Composition;
import ru.novosoft.model.MertEquipModel.GeneralInfo;
import ru.novosoft.model.MertEquipModel.MeasurementParam;
import ru.novosoft.model.MertEquipModel.OperationalInfo;
import ru.novosoft.model.MertEquipModel.Wo;
import ru.novosoft.model.MertEquipModel.WoMtlg;

public class MetrEquipItemModel {
	@JsonProperty("general_info")
	private GeneralInfo generalInfo;

	@JsonProperty("operational_info")
	private OperationalInfo operationalInfo;

	@JsonProperty("measurement_params")
	private List<MeasurementParam> measurementParams;

	@JsonProperty("compositions")
	private List<Composition> compositions;

	@JsonProperty("wo_mtlgs")
	private List<WoMtlg> woMtlgs;

	@JsonProperty("wo")
	private List<Wo> wo;

	public MetrEquipItemModel(GeneralInfo generalInfo, OperationalInfo operationalInfo, List<MeasurementParam> measurementParams, List<Composition> compositions, List<WoMtlg> woMtlgs, List<Wo> wo) {
		this.generalInfo = generalInfo;
		this.operationalInfo = operationalInfo;
		this.measurementParams = measurementParams;
		this.compositions = compositions;
		this.woMtlgs = woMtlgs;
		this.wo = wo;
	}

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	public void setGeneralInfo(GeneralInfo generalInfo) {
		this.generalInfo = generalInfo;
	}

	public OperationalInfo getOperationalInfo() {
		return operationalInfo;
	}

	public void setOperationalInfo(OperationalInfo operationalInfo) {
		this.operationalInfo = operationalInfo;
	}

	public List<MeasurementParam> getMeasurementParams() {
		return measurementParams;
	}

	public void setMeasurementParams(List<MeasurementParam> measurementParams) {
		this.measurementParams = measurementParams;
	}

	public List<Composition> getCompositions() {
		return compositions;
	}

	public void setCompositions(List<Composition> compositions) {
		this.compositions = compositions;
	}

	public List<WoMtlg> getWoMtlgs() {
		return woMtlgs;
	}

	public void setWoMtlgs(List<WoMtlg> woMtlgs) {
		this.woMtlgs = woMtlgs;
	}

	public List<Wo> getWo() {
		return wo;
	}

	public void setWo(List<Wo> wo) {
		this.wo = wo;
	}
	public String toString() {
		return "MetrEquipItemModel{" +
				"generalInfo=" + generalInfo +
				", operationalInfo=" + operationalInfo +
				", measurementParams=" + measurementParams +
				", compositions=" + compositions +
				", woMtlgs=" + woMtlgs +
				", wo=" + wo +
				'}';
	}

}
