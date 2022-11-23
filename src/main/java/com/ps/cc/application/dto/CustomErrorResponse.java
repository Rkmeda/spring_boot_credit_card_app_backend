package com.ps.cc.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomErrorResponse {

	String errorCode;
	String errorMsg;
}
