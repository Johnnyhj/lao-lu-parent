package com.ai.ge.platform.page;

import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


/**
 * 只拦截queryAll*的规则方法进行分页，其他的不进行分页
 * @author renfengfan,sunyue
 *
 */
@Intercepts({@Signature(type=Executor.class,method="query",args={ MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })})
public class PaginationInterceptor implements Interceptor{     
	
	private final static Log log = LogFactory.getLog(PaginationInterceptor.class);     
	 
	//方言
	Dialect dialect = new MysqlDialect();	
	
	public Object intercept(Invocation invocation) throws Throwable {      
		MappedStatement mappedStatement=(MappedStatement)invocation.getArgs()[0];	
		
//		if(null != mappedStatement){
//			String queryMethod = mappedStatement.getId();
//			if(!Pattern.compile("queryAll").matcher(queryMethod).find()){
//				return invocation.proceed();
//			}
//		}
		
		PageContext page = PageContext.getContext();
		
		if(null == page){
			return invocation.proceed();
		}
		
		Object parameter = invocation.getArgs()[1]; 
		BoundSql boundSql = mappedStatement.getBoundSql(parameter); 
		String originalSql = boundSql.getSql().trim();   
		RowBounds rowBounds = (RowBounds)invocation.getArgs()[2];
		Object parameterObject = boundSql.getParameterObject();
		
		if(boundSql==null || boundSql.getSql()==null || "".equals(boundSql.getSql()))
			return null;
		
		//分页参数--上下文传参
	
		
		//分页参数--map参数里的Page传参
//		if(null==page)
//		{
//			if(parameterObject!=null)
//			   page = (Page)ReflectHelper.isPage(parameterObject,"page");
//		}
		
		//分页查询	
		//if(page!=null && page.isPagination()==true) 		
		if(page!=null) 	
		{
		  //int totpage=page.getTotalRows();
			//-所查询出来的结果的总条数, 也是带查询条件的总条数 ,必须每次统计总页数
			int totpage = 0;
		  //得到总记录数
		  if (totpage==0)
			{
				try {
					StringBuffer countSql  = new StringBuffer(originalSql.length()+100 );
					countSql.append("select count(1) from (").append(originalSql).append(") as t_count");
					//System.out.println(countSql.toString());
					Connection connection=mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection()  ;          
					PreparedStatement countStmt = connection.prepareStatement(countSql.toString());  
//					BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),countSql.toString(),boundSql.getParameterMappings(),parameterObject);  
					setParameters(countStmt,mappedStatement,boundSql,parameterObject);  
					ResultSet rs = countStmt.executeQuery();  
					if (rs.next()) {  
					     //context.setTotalRows(rs.getInt(1)); 
					     page.setTotalRows(rs.getInt(1));
					}  
					rs.close();  
					countStmt.close();  
					connection.close();
				} catch (Exception e) {
					log.error("获取总数出错!",e);
				}
                
			}
		  
			if(rowBounds == null || rowBounds == RowBounds.DEFAULT){
				rowBounds= new RowBounds(page.getPageSize()*(page.getCurrentPage()-1),page.getPageSize());
			}
			//初始化
			page.init(page.getTotalRows(),page.getPageSize(),page.getCurrentPage());          
			//分页查询
		    Dialect dialect = new MysqlDialect();	
		    String pagesql=dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit());
		    invocation.getArgs()[2] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);   
		    BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), pagesql,boundSql.getParameterMappings(),boundSql.getParameterObject());   
		    for (ParameterMapping mapping : boundSql.getParameterMappings()) 
		    {
	            String prop = mapping.getProperty();
	            if (boundSql.hasAdditionalParameter(prop)) 
	            {
	            	newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
	            }
	        }
		    MappedStatement newMs = copyFromMappedStatement(mappedStatement,new BoundSqlSqlSource(newBoundSql));  
		   
		    invocation.getArgs()[0]= newMs;  
		}
			
		   return invocation.proceed();
	}
	public static class BoundSqlSqlSource implements SqlSource {  
        BoundSql boundSql;  
  
        public BoundSqlSqlSource(BoundSql boundSql) {  
            this.boundSql = boundSql;  
        }  
  
        public BoundSql getBoundSql(Object parameterObject) {  
            return boundSql;  
        }  
    }  
	public Object plugin(Object arg0) {
		// TODO Auto-generated method stub
		 return Plugin.wrap(arg0, this);
	}
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	        
	}
    
    /** 
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler 
     * @param ps 
     * @param mappedStatement 
     * @param boundSql 
     * @param parameterObject 
     * @throws SQLException 
     */  
    private void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException {  
        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());  
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
        if (parameterMappings != null) {  
            Configuration configuration = mappedStatement.getConfiguration();  
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();  
            MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject);  
            for (int i = 0; i < parameterMappings.size(); i++) {  
                ParameterMapping parameterMapping = parameterMappings.get(i);  
                if (parameterMapping.getMode() != ParameterMode.OUT) {  
                    Object value;  
                    String propertyName = parameterMapping.getProperty();  
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);  
                    if (parameterObject == null) {  
                        value = null;  
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {  
                        value = parameterObject;  
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {  
                        value = boundSql.getAdditionalParameter(propertyName);  
                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)&& boundSql.hasAdditionalParameter(prop.getName())) {  
                        value = boundSql.getAdditionalParameter(prop.getName());  
                        if (value != null) {  
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));  
                        }  
                    } else {  
                        value = metaObject == null ? null : metaObject.getValue(propertyName);  
                    }  
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();  
                    if (typeHandler == null) {  
                        throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement "+ mappedStatement.getId());  
                    }  
                    typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());  
                }  
            }  
        }  
    }  
    
    private MappedStatement copyFromMappedStatement(MappedStatement ms,   
    		 SqlSource newSqlSource) {   
    		Builder builder = new Builder(ms.getConfiguration(),
    		ms.getId(), newSqlSource, ms.getSqlCommandType());   
    		builder.resource(ms.getResource());   
    		builder.fetchSize(ms.getFetchSize());   
    		builder.statementType(ms.getStatementType());   
    		builder.keyGenerator(ms.getKeyGenerator());   
    		builder.keyProperty(ms.getKeyProperty());   
    		builder.timeout(ms.getTimeout());   
    		 builder.parameterMap(ms.getParameterMap());   
    		builder.resultMaps(ms.getResultMaps());   
    		builder.cache(ms.getCache());   
    		MappedStatement newMs = builder.build();   
    		return newMs;   
    		}   
    	 

}