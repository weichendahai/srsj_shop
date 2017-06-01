package com.srsj.common.service.impl;

import com.srsj.common.bo.PageRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.dao.BaseDao;
import com.srsj.common.service.IBaseService;
import com.srsj.common.utils.ClassReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.srsj.common.service.IBaseService;

import java.util.List;


/**
 * Created by weichen on 2017/6/1.
 */

public abstract class BaseServiceImpl<M extends BaseDao<T>, T> implements IBaseService<T> {
    ////public abstract class BaseServiceImpl<T> implements IBaseService<T> {
//    private static final String ID = "id";
//
    @Autowired
    protected M baseDao;

    public List<T> queryAll() {
        return baseDao.queryAll();
    }

    public int add(T t) {
        return  baseDao.add(t);
    }

    public int update(T t) {
        return  baseDao.update(t);
    }

    public int delete(Object id) {
        return  baseDao.delete(id);
    }

}

//public abstract class BaseServiceImpl<T> implements IBaseService<T> {
//    private static final String ID = "id";
//
//    //    @Autowired
//    //protected M baseDao;
//    public abstract BaseDao<T> getDao();
//
//    public int save(T t) {
//        if (ClassReflectUtil.getFieldValue(t, ID) != null) {
//            return update(t);
//        } else {
//            return add(t);
//        }
//    }
//
//    public int add(T t) {
//        return  baseDao.add(t);
//    }
//
//    public int batchAdd(List<T> tList) {
//        return  getDao().batchAdd(tList);
//    }
//
//    public int update(T t) {
//        return  getDao().update(t);
//    }
//
//
//    public int delete(Object id) {
//        return  getDao().delete(id);
//    }
//
//    public int batchDelete(List<Object> idList) {
//        return  getDao().batchDelete(idList);
//    }
//
//    public int queryByCount(PageRequest page) {
//        return  getDao().queryByCount(page);
//    }
//
//    public T queryOne(PageRequest page) {
//        return (T) getDao().queryOne(page);
//    }
//
//    public List<T> queryByList(PageRequest page) {
//        return  getDao().queryByList(page);
//    }
//
//    public T queryById(Object id) {
//        return (T) getDao().queryById(id);
//    }
//
//    public T queryByIdForUpdate(Object id) {
//        return (T) getDao().queryByIdForUpdate(id);
//    }
//
//    public List<T> queryAll(Object object) {
//        return  getDao().queryAll(object);
//    }
//
//    /*
//    *
//    * 分页相关处理方案
//    *
//    * */
//    public interface GetItemList<E>{
//        public List<E> getItemList(PageRequest page);
//    }
//
//    public <E>PageResponse<E> queryForPage(PageRequest page, int totalCount, GetItemList<E> callback){
//        PageResponse<E> pageResponse = new PageResponse<E>();
//        pageResponse.setPage(page.getPage());
//        pageResponse.setPageSize(page.getPageSize());
//        pageResponse.setTotalCount(totalCount);
//        pageResponse.setPageCount(Integer
//                .valueOf((totalCount % page.getPageSize().intValue() == 0) ? totalCount / page.getPageSize().intValue()
//                        : (page.getPageSize().intValue() <= 0) ? 0 : totalCount / page.getPageSize().intValue() + 1));
//        pageResponse.setItemList(callback.getItemList(page));
//        return pageResponse;
//    }
//
////    // 原有方法的组合
////    public PageResponse<T> queryForPage(PageRequest page) {
////        return queryForPage(page, getDao().queryByCount(page), new GetItemList<T>() {
////
////            @Override
////            public List<T> getItemList(PageRequest page) {
////                return getDao().queryByList(page);
////            }
////        });
////    }
//
//    // 原有方法的组合
//    public PageResponse<T> queryForPage(PageRequest page) {
//        return queryForPage(page,  getDao().queryByCount(page), new GetItemList<T>() {
//
//            //            @Override
//            public List<T> getItemList(PageRequest page) {
//                return  getDao().queryByList(page);
//            }
//        });
//    }
//}