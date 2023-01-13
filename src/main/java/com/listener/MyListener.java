package com.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



import com.entity.Todo;

public class MyListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Context Created...");
		List<Todo> list=new ArrayList<Todo>();
		ServletContext context=sce.getServletContext();
		context.setAttribute("list", list);
		
	}
	

}
