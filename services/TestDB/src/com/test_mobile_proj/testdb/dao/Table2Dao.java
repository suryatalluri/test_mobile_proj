/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.test_mobile_proj.testdb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.test_mobile_proj.testdb.*;
/**
 * Specifies methods used to obtain and modify Table2 related information
 * which is stored in the database.
 */
@Repository("TestDB.Table2Dao")
public class Table2Dao extends WMGenericDaoImpl <Table2, Integer> {

   @Autowired
   @Qualifier("TestDBTemplate")
   private HibernateTemplate template;

   public HibernateTemplate getTemplate() {
        return this.template;
   }
}

