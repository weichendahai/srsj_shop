# srsj_shop

## 分页调用
```
int count = sysUserService.queryByCount(userRequest);
List<SysUser> r = sysUserService.queryByList(userRequest);
PageResponse<SysUser> res = new PageResponse<SysUser>(count,r,userRequest);
String userStr = callbackSuccess (res);
```

或是直接调用
```
PageResponse<SysUser> res = sysUserService.queryForPage(userRequest);
String userStr = callbackSuccess (res);
```