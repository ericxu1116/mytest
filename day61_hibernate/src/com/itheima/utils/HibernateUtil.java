package com.itheima.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate开发工具类
 * @author lenovo
 *
 */
public class HibernateUtil {
	
	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	
	//读取hibernate.cfg.xml，创建SessionFactory（执行1次）
	static{
		//hibernate的核心api抛出都是运行时异常
		try {
			cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("hibernate环境的初始化错误...");
		}
	}
	
	/**
	 * 获取Session对象
	 */
	public static Session getSession(){
		return factory.openSession();
	}

}
