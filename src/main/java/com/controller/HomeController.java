package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Todo;

@Controller
public class HomeController {
	
	@Autowired
	ServletContext context;

	@RequestMapping("/home")
	public String Home(Model m)
	{
		String str="home";
		m.addAttribute("page",str);
		List<Todo> list=(List<Todo>)context.getAttribute("list");
		m.addAttribute("todos",list);
		return "Home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m)
	{
		
		Todo t=new Todo();
		m.addAttribute("page","add");
		m.addAttribute("todo",t);
		return "Home";
	}
	
	@RequestMapping(value="/saveTodo",method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m)
	{
		t.setTodoDate(new Date());
		System.out.println(t);
		List<Todo> list=(List<Todo>)context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg", "successfully added....");
		return "Home";
	}
}
