package com.ps.cc.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ps.cc.application.dto.CreditCardAppDTO;
import com.ps.cc.application.dto.ResponseDTO;
import com.ps.cc.application.dto.StatusEnum;
import com.ps.cc.application.service.CreditCardApplicationService;

import lombok.RequiredArgsConstructor;
@RestController	
@RequestMapping("/creditCard")
@RequiredArgsConstructor
public class CreditCardApplicationController {
	
	private final CreditCardApplicationService creditCardAppService;

	@RequestMapping(value = "/v1/addNewCard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<CreditCardAppDTO>>> addNewCreditCard(@RequestBody CreditCardAppDTO creditCardAppDTO){
		ResponseDTO<List<CreditCardAppDTO>> creditCardList = creditCardAppService.addNewCreditCard(creditCardAppDTO);
		if (creditCardList.getStatusMsg().equals(StatusEnum.SUCCESS.getStatus())) {
			return ResponseEntity.ok(creditCardList);
		}
		return null;
	}

}
