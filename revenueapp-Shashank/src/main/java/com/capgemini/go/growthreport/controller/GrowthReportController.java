package com.capgemini.go.growthreport.controller;


import com.capgemini.go.growthreport.entities.GrowthReportItem;
import com.capgemini.go.growthreport.service.IGrowthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/growthreports")
public class GrowthReportController {

    @Autowired
    private IGrowthService growthService;

    @GetMapping("/{start}/{end}/{category}")
    public ResponseEntity getReport(@PathVariable("start") String startDate,@PathVariable("end") String endDate,
                                    @PathVariable("category") int category){

        Date start = convert(startDate);
        Date end = convert(endDate);
        List<GrowthReportItem> list = growthService.viewDetailedReportByProduct(start,end,category);

        return null;
    }

    public Date convert(String text){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yy");//20-06-20
        LocalDate localDate = LocalDate.parse(text,formatter);
        Date date = new Date(localDate.getYear(),localDate.getMonthValue(),localDate.getDayOfMonth());
        return date;
    }

}
