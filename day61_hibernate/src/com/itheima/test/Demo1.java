package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itheima.domain.Customer;

/**
 * hibernate入门开发
 * @author lenovo
 *
 */
public class Demo1 {
	
	@Test
	public void test1(){
		//创建客户对象
		Customer c = new Customer();
		c.setCustName("狗娃科技公司444");
		c.setCustIndustry("IT培训");
		c.setCustSource("电话");
		c.setCustLevel("VIP");
		c.setCustAddress("津安创意园");
		c.setCustPhone("020-3333444");
		c.setCustZipCode("510000");
		
		//保存客户
		/***
		 * 思路：
		 *  1）加载hibernate.cfg.xml文件
		 *  2）创建Session工厂
		 *  3）获取Session（类似于Connection，进行增删改查操作）
		 *  4）打开事务（注意：hibernate框架在执行更新类操作的时候，必须手动控制事务）
		 *  5）保存客户
		 *  6) 提交事务
		 *  7）关闭资源
		 */
		//1）加载hibernate.cfg.xml文件
		Configuration cfg = new Configuration();//创建对象（并不是加载配置）
		cfg.configure();//加载文件
		
		//2) 创建Session工厂(ctrl+2 l)
		SessionFactory factory = cfg.buildSessionFactory();
		
		//3)获取Session
		Session session = factory.openSession();
		
		//4)打开事务，返回事务对象
		Transaction tx = session.beginTransaction();
		
		//5)保存客户
		session.save(c);
		
		//6)提交事务
		tx.commit();
		
		//7）关闭资源
		session.close();
		//factory.close();
	}
}
