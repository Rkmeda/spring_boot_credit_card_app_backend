package com.ps.cc.application.service;

import java.util.List;

import com.ps.cc.application.dto.CreditCardAppDTO;
import com.ps.cc.application.dto.ResponseDTO;
import com.ps.cc.application.exceptions.InvalidCardException;
import com.ps.cc.application.exceptions.NotFoundException;

public interface CreditCardApplicationService {

	ResponseDTO<List<CreditCardAppDTO>> addNewCreditCard(CreditCardAppDTO creditCardAppDTO) throws InvalidCardException;
	ResponseDTO<List<CreditCardAppDTO>> getAllCreditCards() throws NotFoundException;
}
