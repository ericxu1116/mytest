package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * 使用HibernateUtil工具类
 * @author lenovo
 *
 */
public class Demo2 {
	
	@Test
	public void test1(){
		//创建客户对象
		Customer c = new Customer();
		c.setCustName("狗娃科技公司5555");
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
		//3.保存
		session.save(c);
		//4.提交事务
		tx.commit();
		//5.释放资源
		session.close();
	}
}
