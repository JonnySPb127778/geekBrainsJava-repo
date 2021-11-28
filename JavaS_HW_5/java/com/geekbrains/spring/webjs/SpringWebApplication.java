package com.geekbrains.spring.webjs;

import com.geekbrains.spring.webjs.repositories.ProductDao;
import com.geekbrains.spring.webjs.repositories.ProductDaoImpl;
import com.geekbrains.spring.webjs.repositories.SessionFactoryUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {
	// Домашнее задание:
	// 1. Возьмите фронт из этого проекта
	// 2. Backend сделайте сами, стендтов заменяем на продукты

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);

		/* SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
		sessionFactoryUtils.init();
		try {
			ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
			productDao.testCaching();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactoryUtils.shutdown();
		}

*/
	}
}
