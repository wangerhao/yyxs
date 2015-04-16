package com.yyxs.order;


import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.ioc.provider.AnnotationIocProvider;


/**
 * 主模块
 * @author wangxin
 *
 */
@Modules(scanPackage=true)
@IocBy(type=AnnotationIocProvider.class, args={"com.yyxs.order"})
public class MainModule {}
