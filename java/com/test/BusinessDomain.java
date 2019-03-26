package com.test;

import java.io.Serializable;

/**
 * Description:
 * Filename   :   BusinessDomain.java
 * Copyright  :   Copyright (c) 2012-2013 All Rights Reserved.
 * Company    :   golden-soft.com Inc.
 *
 * @author :   wxx
 * @version :   1.0
 * Create at  :   2018/12/22 14:55
 * <p>
 * Modification History:
 * Date				Author       Version      Description
 * ------------------------------------------------------------------
 * 2018/12/22			wxx			 1.0         1.0 Version
 */
public class BusinessDomain implements Serializable {
    private boolean businessFlag;//true:有待处理 false:无待处理 default:false
    private Integer weight;
    private String businessName;

    BusinessDomain(boolean businessFlag, Integer weight, String businessName){
        this.businessFlag = businessFlag;
        this.weight = weight;
        this.businessName = businessName;
    }

    public boolean getBusinessFlag() {
        return businessFlag;
    }

    public void setBusinessFlag(boolean businessFlag) {
        this.businessFlag = businessFlag;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "BusinessDomain{" +
                "businessFlag=" + businessFlag +
                ", weight=" + weight +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
