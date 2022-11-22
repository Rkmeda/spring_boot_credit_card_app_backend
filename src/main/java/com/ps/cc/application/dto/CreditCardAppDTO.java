package com.ps.cc.application.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardAppDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String name;
	private String cardNumber;
	private String balance = "0";
	private String limit;

}
