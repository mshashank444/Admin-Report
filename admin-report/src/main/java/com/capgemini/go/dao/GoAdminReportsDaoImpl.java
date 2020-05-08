package com.capgemini.go.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.go.dto.ViewDetailedSalesReportByProductDTO;
import com.capgemini.go.dto.ViewSalesReportByUserAndCategoryDTO;



public class GoAdminReportsDaoImpl implements GoAdminReportsDao{
	
	public List<ViewSalesReportByUserAndCategoryDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String TargetuserId,int category){

		List<ViewSalesReportByUserAndCategoryDTO> viewSalesReportByUserAndCategory = new ArrayList<ViewSalesReportByUserAndCategoryDTO>();
		
		return viewSalesReportByUserAndCategory;
		
	}
	
	
	public List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit,int category){

		List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct = new ArrayList<ViewDetailedSalesReportByProductDTO>();
		
		return viewDetailedSalesReportByProduct;
		
	}
	
}
