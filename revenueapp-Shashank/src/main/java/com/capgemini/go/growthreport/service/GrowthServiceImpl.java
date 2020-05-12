package com.capgemini.go.growthreport.service;

import com.capgemini.go.growthreport.dao.IGrowthReportDao;
import com.capgemini.go.growthreport.entities.GrowthReportItem;
import com.capgemini.go.revenuereport.dao.IRevenueReportDao;
import com.capgemini.go.revenuereport.entities.RevenueItem;
import com.capgemini.go.revenuereport.util.MonthRevenues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

@Service
@Transactional
public class GrowthServiceImpl implements IGrowthService {

    @Autowired
    private IGrowthReportDao growthReportDao;

    @Autowired
    private IRevenueReportDao revenueReportDao;

    @Override
    public List<GrowthReportItem> viewDetailedReportByProduct(Date entry, Date exit, int category) {
        List<RevenueItem> revenues = revenueReportDao.viewDetailedSalesReportByCategory(entry, exit, category);
        List<GrowthReportItem>growths=growths(revenues);
        save(growths);
        return growths;
    }

    /**
     *
     *  converting to growth reports from revenues
     */
    public List<GrowthReportItem> growths(List<RevenueItem>revenues){
        //
        // period wise
        //
        Map<Integer,MonthRevenues>revenuesMap=monthRevenues(revenues);

        GrowthReportItem lastGrowth=null;
        List<GrowthReportItem>growths=new ArrayList<>();
        for (Integer month:revenuesMap.keySet()){
            MonthRevenues monthRevenues=revenuesMap.get(month);
            GrowthReportItem growthReportItem=growthReportItem(month,monthRevenues);
            double lastRevenue=0;
            double percentGrowth;
            if(lastGrowth!=null){
                lastRevenue= lastGrowth.getRevenue();
                double thisRevenue=growthReportItem.getRevenue();
                double change=thisRevenue-lastRevenue;
                growthReportItem.setAmountChange(change);
                percentGrowth=(change/thisRevenue)*100;
                growthReportItem.setPercentageGrowth(percentGrowth);
                growthReportItem.setColor(colorCode());

            }else {
                growthReportItem.setAmountChange(growthReportItem.getRevenue());
                double thisRevenue=growthReportItem.getRevenue();
                percentGrowth=100;
                growthReportItem.setColor(colorCode());

            }

            growths.add(growthReportItem);
        }

        return growths;

    }

    public String colorCode(){
        GrowthReportItem growthReportItem= new GrowthReportItem();
        double percentGrowth = growthReportItem.getPercentageGrowth();
        if(percentGrowth>10){
            return "GREEN";
        }
        if(percentGrowth>=2 && percentGrowth<=10){
            return "BLUE";
        }
        return "RED";

    }

    public void save(Collection<GrowthReportItem>reportItems){
        for (GrowthReportItem reportItem:reportItems){
            reportItem=growthReportDao.save(reportItem);
        }

    }

    /**
     *
     * converting to growth report item from month revenues
     */
    public GrowthReportItem growthReportItem(int month,MonthRevenues revenues){
        GrowthReportItem growthReportItem=new GrowthReportItem();
        String monthName=monthName(month);
        growthReportItem.setPeriod(monthName);
        Set<RevenueItem>monthReveneus= revenues.getRevenueItems();
        double revenueAmount=0;
        for (RevenueItem revenueItem:monthReveneus){
            revenueAmount=revenueAmount+revenueItem.getPrice();
        }
        growthReportItem.setRevenue(revenueAmount);
        return growthReportItem;
    }

    /**
     * converting to month name from month value
     */
    public String monthName(int month){
      String monthName=  Month.of(month).toString();
      return monthName;
    }

    /**
     * converting to map of month-revenues from all revenues
     */
    Map<Integer,MonthRevenues>monthRevenues(List<RevenueItem>revenueItems){
        Map<Integer,MonthRevenues>revenuesMap=new HashMap<>();
        for (RevenueItem revenueItem:revenueItems) {
            Date date=revenueItem.getDate();
            int month=date.getMonth();
            if(!revenuesMap.containsKey(month)){
                MonthRevenues monthRevenues=new MonthRevenues(month);
                revenuesMap.put(month,monthRevenues);
            }
            MonthRevenues monthRevenues=revenuesMap.get(month);
            monthRevenues.add(revenueItem);
        }
        return revenuesMap;
    }

}
