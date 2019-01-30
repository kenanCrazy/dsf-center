package com.invech.platform.dsfcenterdao.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.Properties;

/**
 * mybatis 全局sql过滤
 * mybatis 的insert 和 delete 也是调用了 update方法
 * Created by Ryan on 2019/01/20.
 */
@Slf4j
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class MybatisInterceptor implements Interceptor {

    private final String preSchema ="dsf_center";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获取statementHandler包装类
        MetaObject MetaObjectHandler = SystemMetaObject.forObject(statementHandler);
        //获取查询接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) MetaObjectHandler.getValue("delegate.mappedStatement");
        //获取进行数据库操作时管理参数的handler
        //ParameterHandler parameterHandler = (ParameterHandler) MetaObjectHandler.getValue("delegate.parameterHandler");
        //Mapper 对应的id ,暂时用不到
        String mapId = mappedStatement.getId();
        //获取sql
        String sql = (String) MetaObjectHandler.getValue("delegate.boundSql.sql");
        String schema = "manage";
        if(!mapId.equals("com.eveb.saasops.api.modules.apisys.mapper.ApiSysMapper.findCpSiteOne") ){
            HttpServletRequest request =getSchemaName();
            if(request != null){
                schema =request.getAttribute("schemaName").toString();
            }/*else if(ThreadLocalCache.SiteCodeThreadLocal.get() !=null && ThreadLocalCache.SiteCodeThreadLocal.get().getSiteCode() != null){
                schema = ThreadLocalCache.SiteCodeThreadLocal.get().getSiteCode();
            }*/
        }



        /*if(RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            if (request != null && request.getAttribute("schemaName") == null ) {
                String siteCode = AESUtil.decrypt(request.getHeader("SToken"));
                if(TCpSiteService.schemaName.get(siteCode) != 1 ){
                    log.error("SToken wrong，Stoken =" +request.getHeader("SToken")+"schemaName = "+siteCode);
                    throw new RRException("SToken wrong");
                }
                if(siteCode == null && !mapId.equals("com.eveb.saasops.api.modules.apisys.mapper.ApiSysMapper.findCpSiteOne")){
                    log.info("请求路径==================================="+request.getRequestURL().toString());
                    log.info("域名=================================="+CommonUtil.getDomainForUrl(request.getRequestURL().toString()));
                    log.info("无法获取siteCode");
                    siteCode ="test";
                    if(siteCode == null) {
                        throw new RRException("invalid siteCode");
                    }
                }
                schema = siteCode != null && !siteCode.equals("null") ? siteCode : schema;
            }else if(request.getAttribute("schemaName") != null){
                schema =request.getAttribute("schemaName").toString();
            }
        }else if(ThreadLocalCache.SiteCodeThreadLocal.get() !=null && ThreadLocalCache.SiteCodeThreadLocal.get().getSiteCode() != null){
            schema = ThreadLocalCache.SiteCodeThreadLocal.get().getSiteCode();
        }*/
        //获取站点前缀
        MetaObjectHandler.setValue("delegate.boundSql.sql", "/*!mycat:schema = "+preSchema+schema.toLowerCase()+" */"+sql);
        return invocation.proceed();
    }

    private HttpServletRequest getSchemaName(){
        RequestAttributes requestAttributes =RequestContextHolder.getRequestAttributes();

        if( requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            //注释语句从这里开始
            /*String ip = request.getRemoteAddr();
            String schemaName1=(String) request.getAttribute("schemaName");
            if (schemaName1==null&&(ip.equals("127.0.0.1") || ip.equals("192.168.5.30") || ip.equals("202.61.86.189"))) {
                String stoken = request.getHeader("SToken");
                if (StringUtils.isEmpty(stoken)) {
                    request.setAttribute("schemaName", "test");
                    return request;
                }
            }*/
            //*********线上注释以上语句
          /*  if (request.getAttribute("schemaName") == null || request.getAttribute("schemaName").equals("")) {
                String schemaName = AESUtil.decrypt(request.getHeader("SToken"));
                if (TCpSiteService.schemaName.get(schemaName) == null) {
                    log.error("SToken wrong，Stoken =" + request.getHeader("SToken") + "schemaName = " + schemaName);
                    throw new RRException("SToken wrong");
                }
                request.setAttribute("schemaName", schemaName);
                return request;
            }else {
                return request;
            }*/
        }
        return null;
    }



    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info(properties.toString());
    }

}
