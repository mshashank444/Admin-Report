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



}
