package com.ps.cc.application.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ps.cc.application.dto.CreditCardAppDTO;
import com.ps.cc.application.dto.ResponseDTO;
import com.ps.cc.application.dto.StatusEnum;
import com.ps.cc.application.exceptions.InvalidCardException;
import com.ps.cc.application.exceptions.NotFoundException;
import com.ps.cc.application.service.CreditCardApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/creditCard")
@Api(value="CreditCard", description="Credit card Processing Document")
@RequiredArgsConstructor
public class CreditCardApplicationController {

	private final CreditCardApplicationService creditCardAppService;

	@ApiOperation(value = "Adding a new card", response = Iterable.class)
	@RequestMapping(value = "/v1/addNewCard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<CreditCardAppDTO>>> addNewCreditCard(
			@RequestBody CreditCardAppDTO creditCardAppDTO) throws InvalidCardException {

		ResponseDTO<List<CreditCardAppDTO>> creditCardList = creditCardAppService.addNewCreditCard(creditCardAppDTO);
		if (creditCardList.getStatusMsg().equals(StatusEnum.SUCCESS.getStatus())) {
			return ResponseEntity.ok(creditCardList);
		} else {
			throw new InvalidCardException();
		}
	}

	@ApiOperation(value = "View a list of credit cards", response = Iterable.class)
	@RequestMapping(value = "/v1/getAllCreditCards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<CreditCardAppDTO>>> getAllCards() throws NotFoundException {
		ResponseDTO<List<CreditCardAppDTO>> creditCardRespDTO = creditCardAppService.getAllCreditCards();
		if (creditCardRespDTO.getData() != null && creditCardRespDTO.getData().size() > 0) {
			return ResponseEntity.ok(creditCardRespDTO);
		} else {
			throw new NotFoundException();
		}
	}
}
