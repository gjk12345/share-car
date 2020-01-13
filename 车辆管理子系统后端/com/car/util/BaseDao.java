package com.car.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T> {

	@Resource
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    public List<T> findbyName(String name)
    {
    	Query<T> query = sessionFactory.getCurrentSession().createQuery("from Publish where title like ?0");
		query.setParameter(0, "%"+name+"%");
		List<T> list = query.list();
		
		return list;
    }

    /**
     * 执行实体对象的保存
     * @param obj
     */
    public void save(Object obj){
        Session s=getSession();
        s.save(obj);
    }
    /**
     * 修改某对象
     * @param obj
     */
    public void update(Object obj){
        Session s=getSession();
        s.update(obj);
    }

    /**
     * 根据hql返回列表
     * @param hql
     * @param params 参数列表
     * @return
     */
    public List<T> list(String hql,Object...params){
        Session s=getSession();
        Query<T> q = s.createQuery(hql);
        if(params!=null&&params.length>0){
            for(int i=0;i<params.length;i++){
                q.setParameter(i, params[i]);
  
            }
        }
        return q.list();
    }
    /**
     * 根据Id主键获得对象
     * @param clz
     * @param id
     * @return
     */
    public Object getById(Class clz,Serializable id){
        Session s=getSession();
        return s.get(clz, id);
    }
    /**
     * 返回整型结果，可以用于查询记录数，例如 select count(noid) from article
     * @param hql
     * @param params
     * @return
     */
    public Integer getInt(String hql,Object...params){
        Object obj=getObject(hql,params);
        if(obj==null){
            return null;
        }

        if(Integer.class.isAssignableFrom(obj.getClass())){
            return (Integer)obj;
        }else if(Long.class.isAssignableFrom(obj.getClass())){
            return ((Long)obj).intValue();
        }else{
            return null;
        }

    }

    /**
     * 根据hql执行，返回一条对象
     * @param hql
     * @param params
     * @return
     */
    public Object getObject(String hql,Object...params){
        List<T> lst=page(hql,1,1,params);
        if(lst!=null&&lst.size()>0){
            return lst.get(0);
        }
        return null;
    }

    /**
     * 分页查询
     * @param hql 
     * @param page 第几页，第一页的值为1
     * @param rows 每页几条,默认为10条
     * @param params 
     * @return
     */
    public List<T> page(String hql,Integer page,Integer rows,Object...params){
        if(page==null||page<1){
            page=1;
        }
        if(rows==null||rows<1){
            rows=10;
        }

        Session s=getSession();
        Query<T> q = s.createQuery(hql);
        if(params!=null&&params.length>0){
            for(int i=0;i<params.length;i++){
                q.setParameter(i, params[i]);
            }
        }
        q.setFirstResult((page-1)*rows);
        q.setMaxResults(rows);
        return q.list();

    }

    /**
     * 执行hql，主要是update和delete语句,hql不支持insert语句
     * @param hql
     * @param params
     */
    public void execHql(String hql,Object...params){
        Session s=getSession();
        Query<T> q = s.createQuery(hql);
        if(params!=null&&params.length>0){
            for(int i=0;i<params.length;i++){
                q.setParameter(i, params[i]);
            }
        }
        q.executeUpdate();
    }
    /**
     * 根据原生sql查询list
     * @param sql
     * @param params
     * @return
     */
    public List<Map<String,Object>> lstBySQL(String sql,Object ...params){
        Session s=getSession();
        Query<T> q = s.createSQLQuery(sql);
        if(params!=null&&params.length>0){
            for(int i=0;i<params.length;i++){
                q.setParameter(i, params[i]);
            }
        }
//        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        return (List<Map<String, Object>>) q.list();
        return (List<Map<String, Object>>) q.getResultList();
    }
    /**
     * 原生SQL分页查询
     * @param sql
     * @param page
     * @param rows
     * @param params
     * @return
     */
    public List<Map<String,Object>> pageBySQL(String sql,Integer page,Integer rows,Object...params){
        Session s=getSession();
        Query<T> q = s.createSQLQuery(sql);
        if(params!=null&&params.length>0){
            for(int i=0;i<params.length;i++){
                q.setParameter(i, params[i]);
            }
        }
        q.setFirstResult((page-1)*rows);
        q.setMaxResults(rows);
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return (List<Map<String, Object>>) q.list();
    }
    /**
     * 根据原生SQL获得一个map
     * @param sql
     * @param params
     * @return
     */
    public Map<String,Object> getMapBySQL(String sql,Object...params){
        List<Map<String,Object>> lst=(List<Map<String, Object>>) page(sql,1,1,params);
        if(lst!=null&&lst.size()>0){
            return lst.get(0);
        }
        return null;
    }

    public Integer getIntBySQL(String sql,Object...params){
        Session s=getSession();
        Query q = s.createSQLQuery(sql);
        if(params!=null&&params.length>0){
            for(int i=0;i<params.length;i++){
                q.setParameter(i, params[i]);
            }
        }
        q.setFirstResult(0);
        q.setMaxResults(1);
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        Object obj= q.uniqueResult();
        if(obj==null){
            return null;
        }

        if(Integer.class.isAssignableFrom(obj.getClass())){
            return (Integer)obj;
        }else if(Long.class.isAssignableFrom(obj.getClass())){
            return ((Long)obj).intValue();
        }else{
            return null;
        }

    }

    /**
     * 执行原生的SQL
     * @param sql
     * @param params
     */
    public void execSQL(String sql,Object...params){
        Session s=getSession();
        Query q = s.createSQLQuery(sql);
        if(params!=null&&params.length>0){
            for(int i=0;i<params.length;i++){
                q.setParameter(i, params[i]);
            }
        }
        q.executeUpdate();
    }

}
