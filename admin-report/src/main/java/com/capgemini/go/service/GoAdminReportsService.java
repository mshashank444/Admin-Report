package com.capgemini.go.service;

import java.util.Date;
import java.util.List;

import com.capgemini.go.dto.ViewDetailedSalesReportByProductDTO;
import com.capgemini.go.dto.ViewSalesReportByUserAndCategoryDTO;


public interface GoAdminReportsService {
	
	
	List<ViewSalesReportByUserAndCategoryDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String targetuserId,int category);



	List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit, int category);

}
