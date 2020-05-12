package com.capgemini.go.revenuereport.service;

import com.capgemini.go.revenuereport.entities.RevenueItem;
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
import java.util.Map;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(RevenueReportServiceImpl.class)
public class RevenueReportServiceImplTest {

    @Autowired
    private IRevenueReportService service;

    @Autowired
    private EntityManager entityManager;

    /**
     * verifying products with desired category and userId with in entry and exit are only fetched
     */
    @Test
    public void testRevenue_1(){
        String userId1="u1";
        String userId2="u2";
        RevenueItem item1=new RevenueItem();
        item1.setDate(new Date(20,1,12));
        item1.setOrderId("o1");
        item1.setPrice(200);
        item1.setProductId("abc1");
        item1.setProductCategory(1);
        item1.setUserId(userId1);
        item1= entityManager.merge(item1);

        RevenueItem item2=new RevenueItem();
        item2.setDate(new Date(20,1,13));
        item2.setOrderId("o2");
        item2.setPrice(200);
        item2.setProductCategory(1);
        item2.setUserId(userId1);
        item2= entityManager.merge(item2);


        // out of exit date
        RevenueItem item3=new RevenueItem();
        item3.setDate(new Date(20,1,16));
        item3.setOrderId("o3");
        item3.setPrice(200);
        item3.setProductCategory(1);
        item3.setUserId(userId1);
        item3= entityManager.merge(item3);


        // out of category
        RevenueItem item4=new RevenueItem();
        item4.setDate(new Date(20,1,12));
        item4.setOrderId("o4");
        item4.setPrice(200);
        item4.setProductCategory(2);
        item4.setUserId(userId1);
        item4= entityManager.merge(item4);

        // out of userId
        RevenueItem item5=new RevenueItem();
        item5.setDate(new Date(20,1,11));
        item5.setOrderId("o5");
        item5.setPrice(150);
        item5.setProductCategory(1);
        item5.setUserId(userId2);
        item5= entityManager.merge(item5);


        Date entry=new Date(20,1,10);
        Date exit=new Date(20,1,15);

        List<RevenueItem> result= service.viewDetailedSalesReportByUserAndCategory(entry,exit,userId1,1)  ;
        System.out.println("************ result size="+result.size()+" *****************");
        Assertions.assertEquals(2,result.size());
        Assertions.assertTrue(result.contains(item1));
        Assertions.assertTrue(result.contains(item2));
//        Assertions.assertFalse(result.contains(item3));
//        Assertions.assertFalse(result.contains(item4));
//        Assertions.assertFalse(result.contains(item5));


    }

}
