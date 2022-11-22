package com.ps.cc.application.service;

import java.util.List;

import com.ps.cc.application.dto.CreditCardAppDTO;
import com.ps.cc.application.dto.ResponseDTO;

public interface CreditCardApplicationService {

	ResponseDTO<List<CreditCardAppDTO>> addNewCreditCard(CreditCardAppDTO creditCardAppDTO);
}
