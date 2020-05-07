package com.capgemini.go.controller;

import com.capgemini.go.service.GoAdminReportsService;

@RestController
public class GoAdminReportsController {
	
	@Autowired
	private GoAdminReportsService goAdminReportsService;

	// Getters and Setters of GoAdminReportsService

	public GoAdminReportsService getGoAdminReportsService() {
		return goAdminReportsService;
	}

	public void setGoAdminReportsService(GoAdminReportsService goAdminReportsService) {
		this.goAdminReportsService = goAdminReportsService;
	}

}
