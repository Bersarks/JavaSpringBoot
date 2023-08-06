package com.allianz.erpproject.database.enums;

public enum StatusEnum {
	PENDING(1), APPROVED(2), REJECTED(3);
	public final int value;

	private StatusEnum(int value) {
		this.value = value;
	}
}
