package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * 使用Trsnaction的标准的hibernate写法
 * @author lenovo
 *
 */
public class Demo4 {
	
	@Test
	public void test1(){
		//创建客户对象
		Customer c = new Customer();
		c.setCustName("狗娃科技公司7777");
		c.setCustIndustry("IT培训");
		c.setCustSource("电话");
		c.setCustLevel("VIP");
		c.setCustAddress("津安创意园");
		c.setCustPhone("020-3333444");
		c.setCustZipCode("510000");
		
		
		//1.获取Session对象
		Session session = HibernateUtil.getSession();
		//2.打开事务
		Transaction tx = session.beginTransaction();
		try {
			//3.保存
			session.save(c);
			//int i=100/0;
			//4.提交事务
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.回滚事务
			tx.rollback();
		}finally{
			//6.释放资源
			session.close();
		}
	}
	
	@Test
	public void test2(){
		Session s1 = HibernateUtil.getSession();
		Session s2 = HibernateUtil.getSession();
		System.out.println(s1==s2);
	}
}
