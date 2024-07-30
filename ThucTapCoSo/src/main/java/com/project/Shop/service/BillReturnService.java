package com.project.Shop.service;


import com.project.Shop.dto.BillReturn.BillReturnCreateDto;
import com.project.Shop.dto.BillReturn.BillReturnDetailDto;
import com.project.Shop.dto.BillReturn.BillReturnDto;
import com.project.Shop.dto.BillReturn.SearchBillReturnDto;

import java.util.List;

public interface BillReturnService {
    List<BillReturnDto> getAllBillReturns(SearchBillReturnDto searchBillReturnDto);

    BillReturnDto createBillReturn(BillReturnCreateDto billReturnCreateDto);

    BillReturnDetailDto getBillReturnDetailById(Long id);
    BillReturnDetailDto getBillReturnDetailByCode(String code);

    String generateHtmlContent(Long billReturnId);

    BillReturnDto updateStatus(Long id, int returnStatus);
}
