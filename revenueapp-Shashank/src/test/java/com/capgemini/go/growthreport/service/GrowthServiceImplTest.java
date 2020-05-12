package com.capgemini.go.growthreport.service;


import com.capgemini.go.growthreport.entities.GrowthReportItem;
import com.capgemini.go.revenuereport.service.RevenueReportServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(GrowthServiceImpl.class)
public class GrowthServiceImplTest {

    @Autowired
    private IGrowthService service;

    @Autowired
    private EntityManager entityManager;

    /**
     * verifying products with desired category and with in entry and exit are only fetched
     */

    @Test
    public void testGrowth_1(){
        GrowthReportItem item1 = new GrowthReportItem();
        item1.setId(1);
        item1.setPeriod("january");
        item1.setRevenue(12500);
        item1.setAmountChange(12500);
        item1.setPercentageGrowth(100);
        item1.setColor("GREEN");
        item1.setCategory(1);
        item1=entityManager.merge(item1);

        GrowthReportItem item2 = new GrowthReportItem();
        item2.setId(1);
        item2.setPeriod("february");
        item2.setRevenue(1250);
        item2.setAmountChange(120);
        item2.setPercentageGrowth(10);
        item2.setColor("BLUE");
        item2.setCategory(1);
        item2=entityManager.merge(item2);


        Date entry=new Date(20,1,1);
        Date exit=new Date(20,1,31);

        List<GrowthReportItem> result = service.viewDetailedReportByProduct(entry,exit,1);
        System.out.println("************ result size="+result.size()+" *****************");
        Assertions.assertEquals(0,result.size());
        Assertions.assertFalse(result.contains(item1));

    }

}
