package com.capgemini.go.revenuereport.controller;


import com.capgemini.go.revenuereport.entities.RevenueItem;
import com.capgemini.go.revenuereport.service.IRevenueReportService;
import com.capgemini.go.revenuereport.util.RevenueReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class RevenueReportController {

    @Autowired
    private IRevenueReportService revenueService;

    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody Map<String,Object> requestData){
        RevenueItem revenueItem = RevenueReportUtil.convertToRevenueItem(requestData);
        revenueService.save(revenueItem);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
