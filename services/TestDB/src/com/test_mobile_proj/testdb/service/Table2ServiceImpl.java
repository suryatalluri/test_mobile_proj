/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.test_mobile_proj.testdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_mobile_proj.testdb.*;


/**
 * ServiceImpl object for domain model class Table2.
 * @see com.test_mobile_proj.testdb.Table2
 */
@Service("TestDB.Table2Service")
public class Table2ServiceImpl implements Table2Service {


    private static final Logger LOGGER = LoggerFactory.getLogger(Table2ServiceImpl.class);

    @Autowired
    @Qualifier("TestDB.Table2Dao")
    private WMGenericDao<Table2, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Table2, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "TestDBTransactionManager")
     public Page<Table2> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "TestDBTransactionManager")
    @Override
    public Table2 create(Table2 table2) {
        LOGGER.debug("Creating a new table2 with information: {}" , table2);
        return this.wmGenericDao.create(table2);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDBTransactionManager")
    @Override
    public Table2 delete(Integer table2Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting table2 with id: {}" , table2Id);
        Table2 deleted = this.wmGenericDao.findById(table2Id);
        if (deleted == null) {
            LOGGER.debug("No table2 found with id: {}" , table2Id);
            throw new EntityNotFoundException(String.valueOf(table2Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "TestDBTransactionManager")
    @Override
    public Page<Table2> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all table2s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "TestDBTransactionManager")
    @Override
    public Page<Table2> findAll(Pageable pageable) {
        LOGGER.debug("Finding all table2s");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "TestDBTransactionManager")
    @Override
    public Table2 findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding table2 by id: {}" , id);
        Table2 table2=this.wmGenericDao.findById(id);
        if(table2==null){
            LOGGER.debug("No table2 found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return table2;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDBTransactionManager")
    @Override
    public Table2 update(Table2 updated) throws EntityNotFoundException {
        LOGGER.debug("Updating table2 with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "TestDBTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


