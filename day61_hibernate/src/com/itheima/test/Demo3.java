package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * Session的增删改查操作
 * @author lenovo
 *
 */
public class Demo3 {
	
	/**
	 * 增加：save(Object)
	 */
	@Test
	public void test1(){
		//创建客户对象
		Customer c = new Customer();
		c.setCustName("传智播客");
		c.setCustIndustry("IT培训");
		c.setCustSource("电话");
		c.setCustLevel("VIP");
		c.setCustAddress("津安创意园");
		c.setCustPhone("020-3366666");
		c.setCustZipCode("510000");
		
		
		//1.获取Session对象
		Session session = HibernateUtil.getSession();
		//2.打开事务
		Transaction tx = session.beginTransaction();
		//3.保存
		session.save(c);
		//4.提交事务
		tx.commit();
		//5.释放资源
		session.close();
	}
	
	/**
	 * 查询一个对象：get(Class,Object);
	 */
	@Test
	public void test2(){
		
		Session session = HibernateUtil.getSession();
		/**
		 * 参数一：目标类类型
		 * 参数二：主键值
		 */
		Customer c = session.get(Customer.class, 6L);
		System.out.println(c);
		
	}
	
	/**
	 * 更新对象：update(Object);
	 */
	@Test
	public void test3(){
		/**
		 * 第一种更新方式：
		 */
		/*
		Customer c = new Customer();
		c.setId(6L);
		c.setCustName("传智播客");
		c.setCustIndustry("IT培训");
		c.setCustSource("电话");
		//c.setCustLevel("VIP");
		c.setCustAddress("津安创意园22222");
		c.setCustPhone("020-3366666");
		c.setCustZipCode("510000");
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
		session.close();
		*/
		
		/**
		 * 第二种更新方式：
		 */
		Session session = HibernateUtil.getSession();
		Customer c = session.get(Customer.class, 6L);
		
		Transaction tx = session.beginTransaction();
		c.setCustSource("网络");
		session.update(c);
		tx.commit();
	}
	
	/**
	 * 删除一个对象：delete(Object);
	 */
	@Test
	public void test4(){
		/*
		 * 第一种方式：
		Customer c = new Customer();
		c.setId(1L);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
		*/
		
		/**
		 * 第二种方式（推荐）
		 */
		Session session = HibernateUtil.getSession();
		Customer c = session.get(Customer.class, 2L);
		if(c!=null){
			Transaction tx = session.beginTransaction();
			session.delete(c);
			tx.commit();
		}
	}
	/**
	 * 保存或更新对象：saveOrUpdate(Object);
	 */
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		
		Customer c = new Customer();
		c.setId(7L);
		c.setCustName("传智播客test2222");
		c.setCustIndustry("IT培训");
		c.setCustSource("电话");
		c.setCustLevel("VIP");
		c.setCustAddress("津安创意园");
		c.setCustPhone("020-3366666");
		c.setCustZipCode("510000");
		
		
		Transaction tx = session.beginTransaction();
		
		/**
		 * 这个方法的使用规则：
		 *   1）当前存入的对象存在id值的时候，
		 *   		则为update操作,
		 *   			1.1)  对象的id值存在于数据库中，这时会更新数据库中某条记录
		 *   			1.2 ） 对象的id值不存在于数据库中，这时不会更新数据库中某条记录
		 *   2）当前存入的对象的id，则为insert操作
		 */
		session.saveOrUpdate(c); 
		
		tx.commit();
		
		
		
	}
}
