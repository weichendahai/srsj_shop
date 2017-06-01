package com.srsj.common.service;

import com.srsj.common.bo.PageRequest;
import com.srsj.common.bo.PageResponse;

import java.util.List;

/**
 * Created by weichen on 2017/6/1.
 */
public interface IBaseService<T> {

//    //按列表获取对象信息
//    PageResponse<T> queryForPage(PageRequest page);
//
//    //新增或者更新对象
//    int save(T t);
//
    int add(T t);
//
//    int batchAdd(List<T> tList);
//
    int update(T t);

    int delete(Object id);
//
//    int batchDelete(List<Object> idList);
//
//    int queryByCount(PageRequest page);
//
//    T queryOne(PageRequest page);
//
//    List<T> queryByList(PageRequest page);
//
//    T queryById(Object id);
//
//    T queryByIdForUpdate(Object id);
//
//    List<T> queryAll(Object object);

    List<T> queryAll();
}
