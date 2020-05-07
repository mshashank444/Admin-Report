package com.capgemini.go.service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.go.dao.GoAdminReportsDao;
import com.capgemini.go.dto.ViewDetailedSalesReportByProductDTO;
import com.capgemini.go.dto.ViewSalesReportByUserDTO;



public class GoAdminReportsServiceImpl implements GoAdminReportsService{
	
	@Autowired
	private GoAdminReportsDao goAdminReportsDao;

	public GoAdminReportsDao getGoAdminReportsDao() {
		return goAdminReportsDao;
	}

	public void setProductDao(GoAdminReportsDao goAdminReportsDao) {
		this.goAdminReportsDao = goAdminReportsDao;
	}
	
	

	public List<ViewSalesReportByUserDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String TargetuserId,int category){
		
		List<ViewSalesReportByUserDTO> result = new ArrayList<ViewSalesReportByUserDTO>();
		
	}
	
	public List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit, int category){

		List<ViewDetailedSalesReportByProductDTO> result = new ArrayList<ViewDetailedSalesReportByProductDTO>();

	}

}
