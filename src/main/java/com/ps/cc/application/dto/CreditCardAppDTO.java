package com.ps.cc.application.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardAppDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "The database generated creditCard ID")
	private Integer id;
	@ApiModelProperty(notes = "Name on the credit card")
	private String name;
	@ApiModelProperty(notes = "Credit Card Number")
	private String cardNumber;
	@ApiModelProperty(notes = "Balance in the credit card, default is 0 ")
	private String balance = "0";
	@ApiModelProperty(notes = "Credit Card limit")
	private String limit;

}
