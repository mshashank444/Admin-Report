package com.capgemini.go.revenuereport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.capgemini.go.revenuereport.entities.*;
import java.util.Date;
import java.util.List;

public interface IRevenueReportDao extends JpaRepository<RevenueItem,Integer> {

    @Query("from RevenueItem where productCategory=:category and userId=:userId and date > :entry and date < :exit   order by date")
    List<RevenueItem>viewDetailedSalesReportByUserAndCategory( @Param("entry") Date entry, @Param("exit") Date exit,@Param("userId") String userId, @Param("category") int category);

    @Query("from RevenueItem where productCategory=:category and date > :entry and date < :exit   order by date")
    List<RevenueItem>viewDetailedSalesReportByCategory( @Param("entry") Date entry, @Param("exit") Date exit, @Param("category") int category);

}
