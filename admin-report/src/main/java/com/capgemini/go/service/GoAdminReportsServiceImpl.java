package com.capgemini.go.service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.go.dao.GoAdminReportsDao;
import com.capgemini.go.dto.ViewDetailedSalesReportByProductDTO;
import com.capgemini.go.dto.ViewSalesReportByUserAndCategoryDTO;



public class GoAdminReportsServiceImpl implements GoAdminReportsService{
	
	@Autowired
	private GoAdminReportsDao goAdminReportsDao;

	public GoAdminReportsDao getGoAdminReportsDao() {
		return goAdminReportsDao;
	}

	public void setProductDao(GoAdminReportsDao goAdminReportsDao) {
		this.goAdminReportsDao = goAdminReportsDao;
	}
	
	

	public List<ViewSalesReportByUserAndCategoryDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String targetuserId,int category){
		
		List<ViewSalesReportByUserAndCategoryDTO> result = new ArrayList<ViewSalesReportByUserAndCategoryDTO>();
		
		result = goAdminReportsDao.viewSalesReportByUserAndCategory(entry, exit, targetuserId, category);
		
		return result;
		
	}
	
	public List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit, int category){

		List<ViewDetailedSalesReportByProductDTO> result = new ArrayList<ViewDetailedSalesReportByProductDTO>();
		
		result = goAdminReportsDao.viewDetailedSalesReportByProduct(entry, exit, category);
		
		return result;

	}

}
