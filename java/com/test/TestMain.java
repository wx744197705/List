package com.test;

import java.util.*;

/**
 * Description:
 * Filename   :   TestMain.java
 * Copyright  :   Copyright (c) 2012-2013 All Rights Reserved.
 * Company    :   golden-soft.com Inc.
 *
 * @author :   wxx
 * @version :   1.0
 * Create at  :   2018/12/22 15:02
 * <p>
 * Modification History:
 * Date				Author       Version      Description
 * ------------------------------------------------------------------
 * 2018/12/22			wxx			 1.0         1.0 Version
 */
public class TestMain {
    public static void main(String[] args){
        TestMain test = new TestMain();
        List<BusinessDomain> list = test.getList();

        list.sort((o1, o2) -> {
            if (o1 == null || o2 == null){
                return -1;
            }
            if (o1.getWeight() == null || o2.getWeight() == null){
                return 1;
            }
            return o2.getWeight() - o1.getWeight();
        });
        list = test.reJoint(list);
        list.forEach(System.out::println);
    }
    private List<BusinessDomain> reJoint(List<BusinessDomain> list){
        List<BusinessDomain> res = new ArrayList<>(list.size());
        List<BusinessDomain> joinList = new ArrayList<>(list.size());
        for (BusinessDomain bean : list){
            if (bean.getBusinessFlag()){
                res.add(bean);
            } else {
                joinList.add(bean);
            }
        }
        res.addAll(joinList);
        return res;
    }

    private List<BusinessDomain> getList(){
        Random random = new Random();
        BusinessDomain b1 = new BusinessDomain(true,random.nextInt(100),"A");
        BusinessDomain b2 = new BusinessDomain(true,random.nextInt(100),"C");
        BusinessDomain b3 = new BusinessDomain(false,random.nextInt(100),"B");
        BusinessDomain b4 = new BusinessDomain(true,random.nextInt(100),"V");
        BusinessDomain b5 = new BusinessDomain(false,random.nextInt(100),"H");
        BusinessDomain b6 = new BusinessDomain(true,null,"E");
        BusinessDomain b7 = new BusinessDomain(false,random.nextInt(100),"Q");
        BusinessDomain b8 = new BusinessDomain(false,random.nextInt(100),"L");
        List<BusinessDomain> list = new ArrayList<>(8);
        list.add(b1);
        list.add(b4);
        list.add(b3);
        list.add(b2);
        list.add(b6);
        list.add(b5);
        list.add(b8);
        list.add(b7);
        return list;
    }
}
