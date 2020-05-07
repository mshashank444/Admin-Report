package com.capgemini.go.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.go.dto.ViewDetailedSalesReportByProductDTO;
import com.capgemini.go.dto.ViewSalesReportByUserDTO;



public class GoAdminReportsDaoImpl implements GoAdminReportsDao{
	
	public List<ViewSalesReportByUserDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String TargetuserId,int category){

		List<ViewSalesReportByUserDTO> viewSales = new ArrayList<ViewSalesReportByUserDTO>();
		
		return viewSales;
		
	}
	
	
	public List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit,int category){

		List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct = new ArrayList<ViewDetailedSalesReportByProductDTO>();
		
		return viewDetailedSalesReportByProduct;
		
	}
	
}
