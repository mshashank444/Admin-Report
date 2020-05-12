package com.capgemini.go.revenuereport.service;

import com.capgemini.go.revenuereport.entities.RevenueItem;

import java.util.Date;
import java.util.List;

public interface IRevenueReportService {
    List<RevenueItem> viewDetailedSalesReportByUserAndCategory(Date entry, Date exit, String userId, int category);

    RevenueItem save(RevenueItem revenueItem);
}
