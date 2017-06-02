package com.srsj.common.service.impl;

import com.srsj.common.bo.PageRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.dao.BaseDao;
import com.srsj.common.service.IBaseService;
import com.srsj.common.utils.ClassReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by weichen on 2017/6/1.
 */

public abstract class BaseServiceImpl<M extends BaseDao<T>, T> implements IBaseService<T> {
    ////public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    private static final String ID = "id";

    @Autowired
    protected M baseDao;

    public int save(T t) {
        if (ClassReflectUtil.getFieldValue(t, ID) != null) {
            return update(t);
        } else {
            return baseDao.insert(t);
        }
    }

    public List<T> queryAll() {
        return baseDao.queryAll(null);
    }

    public int insert(T t) {
        return  baseDao.insert(t);
    }

    public int batchInsert(List<T> tList) {
        return  baseDao.batchInsert(tList);
    }

    public int update(T t) {
        return  baseDao.update(t);
    }

    public int delete(Object id) {
        return  baseDao.delete(id);
    }

    public int batchDelete(List<Object> idList) {
        return  baseDao.batchDelete(idList);
    }

    public int queryByCount(PageRequest page) {
        return  baseDao.queryByCount(page);
    }

    public T queryOne(PageRequest page) {
        return (T) baseDao.queryOne(page);
    }

    public List<T> queryByList(PageRequest page) {
        return  baseDao.queryByList(page);
    }

    public T queryById(Object id) {
        return (T) baseDao.queryById(id);
    }

    public T queryByIdForUpdate(Object id) {
        return (T) baseDao.queryByIdForUpdate(id);
    }

    public List<T> queryAll(Object object) {
        return  baseDao.queryAll(object);
    }


    // ==== 分页相关 ===
    public interface GetItemList<E>{
        public List<E> getItemList(PageRequest page);
    }

    public <E>PageResponse<E> queryForPage(PageRequest page, int totalCount, GetItemList<E> callback){
        PageResponse<E> pageResponse = new PageResponse<E>();
        pageResponse.setPage(page.getPage());
        pageResponse.setPageSize(page.getPageSize());
        pageResponse.setTotalCount(totalCount);
        pageResponse.setPageCount(Integer
                .valueOf((totalCount % page.getPageSize().intValue() == 0) ? totalCount / page.getPageSize().intValue()
                        : (page.getPageSize().intValue() <= 0) ? 0 : totalCount / page.getPageSize().intValue() + 1));
        pageResponse.setItemList(callback.getItemList(page));
        return pageResponse;
    }

    public PageResponse<T> queryForPage(PageRequest page) {
        return queryForPage(page, baseDao.queryByCount(page), new GetItemList<T>() {
//            @Override
            public List<T> getItemList(PageRequest page) {
                return baseDao.queryByList(page);
            }
        });
    }

}