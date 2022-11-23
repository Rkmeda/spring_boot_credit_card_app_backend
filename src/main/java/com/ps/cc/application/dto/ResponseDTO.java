package com.ps.cc.application.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseDTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Status Message SUCCESS/FAIL")
	private String statusMsg;
	@ApiModelProperty(notes = "Status Code 412")
	private String statusCode;
	@ApiModelProperty(notes = "Return generic data response")
	private T data;

	public ResponseDTO(T data, StatusEnum status, String statusCode) {
		this(data, status.getStatus(), statusCode);
	}

	public ResponseDTO(T data, String status, String statusCode) {
		this.data = data;
		this.statusMsg = status;
		this.statusCode = statusCode;
	}

}
