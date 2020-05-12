package com.capgemini.go.growthreport.dao;

import com.capgemini.go.growthreport.entities.GrowthReportItem;
import com.capgemini.go.revenuereport.entities.RevenueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface IGrowthReportDao extends JpaRepository<GrowthReportItem,Integer> {

    @Query("from RevenueItem where productCategory=:category and date > :entry and date < :exit   order by date")
    List<RevenueItem> viewDetailedSalesReportByCategory(@Param("entry") Date entry, @Param("exit") Date exit, @Param("category") int category);

}
