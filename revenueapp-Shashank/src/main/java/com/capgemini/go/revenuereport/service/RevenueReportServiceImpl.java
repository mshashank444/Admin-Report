package com.capgemini.go.revenuereport.service;

import com.capgemini.go.revenuereport.dao.IRevenueReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.go.revenuereport.entities.*;

import java.util.*;

@Service
@Transactional
public class RevenueReportServiceImpl implements IRevenueReportService {

    @Autowired
    private IRevenueReportDao revenueReportDao;

    @Override
    public List<RevenueItem> viewDetailedSalesReportByUserAndCategory(Date entry, Date exit, String userId, int category) {
        List<RevenueItem> categoryList = revenueReportDao.viewDetailedSalesReportByUserAndCategory(entry, exit, userId, category);
        return categoryList;
    }


    @Override
    public RevenueItem save(RevenueItem revenueItem){
        revenueItem=revenueReportDao.save(revenueItem);
        return revenueItem;
    }

}
