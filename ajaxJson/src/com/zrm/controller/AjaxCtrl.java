package com.zrm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrm.pojo.User;

@Controller
public class AjaxCtrl {
	@RequestMapping("/toAjax.do")
	public String toAjax() {
		return "ajax";
	}
	@RequestMapping("/ajax.do")
	@ResponseBody
	public void ajaxJson(@RequestParam("name")String name,HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if(name.equals("hm"))
			out.print("该用户已注册");
		else 
			out.print("该用户可使用");
	}
	@RequestMapping("/toAjaxJson.do")
	public String toAjaxJson() {
		return "ajaxJson";
	}
	
	@RequestMapping("/ajaxJson.do")
	@ResponseBody
	public List<User> ajaxJson() {
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "xb", "123"));
		list.add(new User(2, "xc", "234"));
		list.add(new User(3, "xd", "345"));
		list.add(new User(4, "xa", "456"));
		return list;
	}
}
