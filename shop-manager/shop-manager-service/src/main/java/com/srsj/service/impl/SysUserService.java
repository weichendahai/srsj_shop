package com.srsj.service.impl;

import com.srsj.common.bo.PageRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.impl.BaseServiceImpl;
import com.srsj.dao.SysUserDao;

import com.srsj.pojo.SysUser;
import com.srsj.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weichen on 2017/5/25.
 */

//@Service
//public class SysUserService implements ISysUserService {
//    @Autowired
//    public   SysUserDao sysUserDao;
//
//    public List<SysUser> queryAll () {
//        return sysUserDao.queryAll();
//    }
//}

@Service
public class SysUserService extends BaseServiceImpl<SysUserDao,SysUser> implements ISysUserService {

}


//===================

////@Service
////public class SysUserService extends BaseServiceImpl<SysUserDao,SysUser> implements ISysUserService {
////
////}
////@Service
////public class SysUserService extends BaseServiceImpl<SysUser> implements ISysUserService {
////
////    @Autowired
////    private SysUserDao sysUserDao;
////
////    @Override
////    public BaseDao<SysUser> getDao() {
////        return sysUserDao;
////    }
////}
//
//@Service
//public class SysUserService implements ISysUserService {
//
//    private static final String ID = "id";
//
//    @Autowired
//    protected SysUserDao sysUserDao;
////    public abstract BaseDao<T> getDao();
//
//    public int save(SysUser obj) {
//        return sysUserDao.add(obj);
//    }
//
//    public int add(SysUser obj) {
//        return sysUserDao.add(obj);
//    }
//
//    public int batchAdd(List<SysUser> tList) {
//        return sysUserDao.batchAdd(tList);
//    }
//
//    public int update(SysUser obj) {
//        return sysUserDao.update(obj);
//    }
//
//
//    public int delete(Object id) {
//        return sysUserDao.delete(id);
//    }
//
//    public int batchDelete(List<Object> idList) {
//        return sysUserDao.batchDelete(idList);
//    }
//
//    public int queryByCount(PageRequest page) {
//        return sysUserDao.queryByCount(page);
//    }
//
//    public SysUser queryOne(PageRequest page) {
//        return (SysUser)sysUserDao.queryOne(page);
//    }
//
//    public List<SysUser> queryByList(PageRequest page) {
//        return sysUserDao.queryByList(page);
//    }
//
//    public SysUser queryById(Object id) {
//        return (SysUser)sysUserDao.queryById(id);
//    }
//
//    public SysUser queryByIdForUpdate(Object id) {
//        return (SysUser)sysUserDao.queryByIdForUpdate(id);
//    }
//
//    public List<SysUser> queryAll(Object object) {
//        return sysUserDao.queryAll(object);
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
//    public PageResponse<SysUser> queryForPage(PageRequest page) {
//        return queryForPage(page, sysUserDao.queryByCount(page), new GetItemList< SysUser>() {
//
//            //            @Override
//            public List<SysUser> getItemList(PageRequest page) {
//                return sysUserDao.queryByList(page);
//            }
//        });
//    }
//}