package com.lucas.springweb.entities.enums;

public enum OrderStatus {

	WATING_PAYMENT(1),
	PAID(2),
	SHIPPED3(3),
	DELIVERED(4),
	CANCELED(5);
	
	/*cod do tipo enumerado*/
	private int code;

	/*Construtor*/
	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	/*Converter um valor numerico para tipo enumerado
	 * Ele vai percorrer todos os valores possiveis
	 * Se cod for igual vai return value*/
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
	
}
