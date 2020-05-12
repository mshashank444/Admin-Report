package com.capgemini.go.revenuereport.util;

import com.capgemini.go.revenuereport.entities.RevenueItem;

import java.util.*;

/**
 * Hols reveneue of one month
 */
public class MonthRevenues {

    public MonthRevenues(int month){
        this.month=month;
    }

    private int month;


    private Set<RevenueItem>revenueItems=new HashSet<>();


    public  void add(RevenueItem revenueItem){
        revenueItems.add(revenueItem);
    }


    public int getPeriod() {
        return month;
    }

    public void setPeriod(int month) {
        this.month = month;
    }

    public Set<RevenueItem> getRevenueItems() {
        return revenueItems;
    }

    public void setRevenueItems(Set<RevenueItem> revenueItems) {
        this.revenueItems = revenueItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthRevenues that = (MonthRevenues) o;
        return this.month==that.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month);
    }
}
