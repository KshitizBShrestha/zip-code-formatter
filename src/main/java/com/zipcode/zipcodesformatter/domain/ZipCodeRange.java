package com.zipcode.zipcodesformatter.domain;

import java.io.Serializable;

public class ZipCodeRange implements Serializable {

	private static final long serialVersionUID = -3770600229668404537L;

	private Integer minZipCodeRange;
	private Integer maxZipCodeRange;

	public ZipCodeRange(Integer minZipCodeRange, Integer maxZipCodeRange) {
		this.minZipCodeRange = minZipCodeRange;
		this.maxZipCodeRange = maxZipCodeRange;
	}

	public Integer getMinZipCodeRange() {
		return minZipCodeRange;
	}

	public void setMinZipCodeRange(Integer minZipCodeRange) {
		this.minZipCodeRange = minZipCodeRange;
	}

	public Integer getMaxZipCodeRange() {
		return maxZipCodeRange;
	}

	public void setMaxZipCodeRange(Integer maxZipCodeRange) {
		this.maxZipCodeRange = maxZipCodeRange;
	}

	@Override
	public String toString() {
		return "[" + minZipCodeRange + ", " + maxZipCodeRange + "]";
	}

}
