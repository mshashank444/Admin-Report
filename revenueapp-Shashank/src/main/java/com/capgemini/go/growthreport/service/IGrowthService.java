package com.capgemini.go.growthreport.service;

import com.capgemini.go.growthreport.entities.GrowthReportItem;

import java.util.Date;
import java.util.List;

public interface IGrowthService {

    List<GrowthReportItem> viewDetailedReportByProduct(Date entry, Date exit, int category);

}
