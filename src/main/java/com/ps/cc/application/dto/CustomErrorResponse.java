package com.ps.cc.application.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomErrorResponse {

	@ApiModelProperty(notes = "Custom status code")
	String errorCode;
	@ApiModelProperty(notes = "Custom error message")
	String errorMsg;
}
