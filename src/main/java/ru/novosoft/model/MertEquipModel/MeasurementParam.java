package ru.novosoft.model.MertEquipModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeasurementParam {
	@JsonProperty("measurement_kind_code")
	private String measurementKindCode;

	@JsonProperty("measurement_param_name")
	private String measurementParamName;

	@JsonProperty("lower_limit")
	private double lowerLimit;

	@JsonProperty("lower_limit_uom")
	private String lowerLimitUom;

	@JsonProperty("upper_limit")
	private double upperLimit;

	@JsonProperty("upper_limit_uom")
	private String upperLimitUom;

	@JsonProperty("absolute_error")
	private Double absoluteError;

	@JsonProperty("absolute_error_uom")
	private String absoluteErrorUom;

	@JsonProperty("relative_error")
	private Double relativeError;

	@JsonProperty("accuracy_class")
	private String accuracyClass;

	public MeasurementParam(String measurementKindCode, String measurementParamName,
			double lowerLimit, String lowerLimitUom, double upperLimit, String upperLimitUom,
			Double absoluteError, String absoluteErrorUom, Double relativeError,
			String accuracyClass) {
		this.measurementKindCode = measurementKindCode;
		this.measurementParamName = measurementParamName;
		this.lowerLimit = lowerLimit;
		this.lowerLimitUom = lowerLimitUom;
		this.upperLimit = upperLimit;
		this.upperLimitUom = upperLimitUom;
		this.absoluteError = absoluteError;
		this.absoluteErrorUom = absoluteErrorUom;
		this.relativeError = relativeError;
		this.accuracyClass = accuracyClass;
	}

	public void setMeasurementKindCode(String measurementKindCode) {
		this.measurementKindCode = measurementKindCode;
	}

	public void setMeasurementParamName(String measurementParamName) {
		this.measurementParamName = measurementParamName;
	}

	public void setLowerLimit(double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public void setLowerLimitUom(String lowerLimitUom) {
		this.lowerLimitUom = lowerLimitUom;
	}

	public void setUpperLimit(double upperLimit) {
		this.upperLimit = upperLimit;
	}

	public void setUpperLimitUom(String upperLimitUom) {
		this.upperLimitUom = upperLimitUom;
	}

	public void setAbsoluteError(Double absoluteError) {
		this.absoluteError = absoluteError;
	}

	public void setAbsoluteErrorUom(String absoluteErrorUom) {
		this.absoluteErrorUom = absoluteErrorUom;
	}

	public void setRelativeError(Double relativeError) {
		this.relativeError = relativeError;
	}

	public void setAccuracyClass(String accuracyClass) {
		this.accuracyClass = accuracyClass;
	}

	public String getMeasurementKindCode() {
		return measurementKindCode;
	}

	public String getMeasurementParamName() {
		return measurementParamName;
	}

	public double getLowerLimit() {
		return lowerLimit;
	}

	public String getLowerLimitUom() {
		return lowerLimitUom;
	}

	public double getUpperLimit() {
		return upperLimit;
	}

	public String getUpperLimitUom() {
		return upperLimitUom;
	}

	public Double getAbsoluteError() {
		return absoluteError;
	}

	public String getAbsoluteErrorUom() {
		return absoluteErrorUom;
	}

	public Double getRelativeError() {
		return relativeError;
	}

	public String getAccuracyClass() {
		return accuracyClass;
	}
}
