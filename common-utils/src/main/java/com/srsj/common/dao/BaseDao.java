package com.srsj.common.dao;

import com.srsj.common.bo.PageRequest;

import java.util.List;

/**
 *
 * 数据库基础接口类
 *
 * Created by weichen on 2017/6/1.
 */
public interface BaseDao<T> {

    int insert(T t);

    int batchInsert(List<T> tList);

    int update(T t);

    int delete(Object id);

    int batchDelete(List<Object> idList);

    int queryByCount(PageRequest page);

    T queryOne(PageRequest page);

    List<T> queryByList(PageRequest page);

    T queryById(Object id);

    T queryByIdForUpdate(Object id);

    List<T> queryAll(Object object);

//    List<T> queryAll();
}