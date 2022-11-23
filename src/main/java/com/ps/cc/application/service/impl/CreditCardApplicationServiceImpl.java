package com.ps.cc.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.cc.application.dto.ApplicationConstants;
import com.ps.cc.application.dto.CreditCardAppDTO;
import com.ps.cc.application.dto.ResponseDTO;
import com.ps.cc.application.dto.StatusEnum;
import com.ps.cc.application.entity.CreditCardApp;
import com.ps.cc.application.exceptions.InvalidCardException;
import com.ps.cc.application.exceptions.NotFoundException;
import com.ps.cc.application.mapper.CreditCardDataMapper;
import com.ps.cc.application.repository.CreditCardApplicationRepository;
import com.ps.cc.application.service.CreditCardApplicationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreditCardApplicationServiceImpl implements CreditCardApplicationService {

	private final CreditCardDataMapper creditCardDataMapper;

	@Autowired
	CreditCardApplicationRepository creditCardAppRepository;

	@Override
	public ResponseDTO<List<CreditCardAppDTO>> addNewCreditCard(CreditCardAppDTO creditCardAppDTO)
			throws InvalidCardException {

		if (creditCardAppDTO.getCardNumber() != null && validateCreditCard(creditCardAppDTO.getCardNumber())) {
			CreditCardApp creditCardApp = creditCardDataMapper.creditCardAppDTOToCreditCardApp(creditCardAppDTO);
			creditCardAppRepository.save(creditCardApp);
			List<CreditCardApp> ccList = creditCardAppRepository.findAll();
			List<CreditCardAppDTO> newCCList = creditCardDataMapper.creditCardAppToCreditCardAppDTOs(ccList);
			return new ResponseDTO<List<CreditCardAppDTO>>(newCCList, StatusEnum.SUCCESS,
					ApplicationConstants.SUCCESS_CODE);
		} else {
			throw new InvalidCardException();
		}
	}

	private boolean validateCreditCard(String cardNumber) {
		if (cardNumber.length() > 19) {
			return false;
		}
		int nDigits = cardNumber.length();
		int nSum = 0;
		boolean isSecond = false;
		for (int i = nDigits - 1; i >= 0; i--) {
			int d = cardNumber.charAt(i) - '0';
			if (isSecond == true)
				d = d * 2;
			nSum += d / 10;
			nSum += d % 10;
			isSecond = !isSecond;
		}
		return (nSum % 10 == 0);
	}
	
	@Override
	public ResponseDTO<List<CreditCardAppDTO>> getAllCreditCards() throws NotFoundException {
		List<CreditCardAppDTO> newCCList = null;
		List<CreditCardApp> ccList = creditCardAppRepository.findAll();
		newCCList = creditCardDataMapper.creditCardAppToCreditCardAppDTOs(ccList);
		if (newCCList != null && newCCList.size() > 0) {
			return new ResponseDTO<List<CreditCardAppDTO>>(newCCList, StatusEnum.SUCCESS,
					ApplicationConstants.SUCCESS_CODE);
		} else {
			throw new NotFoundException();
		}
	}

}
