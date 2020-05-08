package com.capgemini.go.dao;


import java.util.Date;
import java.util.List;

import com.capgemini.go.dto.ViewDetailedSalesReportByProductDTO;
import com.capgemini.go.dto.ViewSalesReportByUserAndCategoryDTO;

public interface GoAdminReportsDao {
	
	List<ViewSalesReportByUserAndCategoryDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String TargetuserId,int category);


	List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit, int category);

}
