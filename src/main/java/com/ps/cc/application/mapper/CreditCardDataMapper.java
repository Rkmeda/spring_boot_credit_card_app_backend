package com.ps.cc.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ps.cc.application.dto.CreditCardAppDTO;
import com.ps.cc.application.entity.CreditCardApp;

@Mapper(componentModel = "spring", uses = {})
public interface CreditCardDataMapper {

    CreditCardApp creditCardAppDTOToCreditCardApp(CreditCardAppDTO creditCardAppDTO);
	
	CreditCardAppDTO creditCardAppToCreditCardDTO(CreditCardApp creditCardApp);
	
	List<CreditCardAppDTO> creditCardAppToCreditCardAppDTOs(List<CreditCardApp> creditCardApp);
}
