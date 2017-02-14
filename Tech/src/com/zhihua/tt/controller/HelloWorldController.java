package com.zhihua.tt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhihua.tt.service.user.UserService;

@Controller  
@RequestMapping("/zhihua")  
public class HelloWorldController { 
	
	
	@Autowired
	private UserService userService;
	
	
    @RequestMapping(value="/test.do",method = RequestMethod.GET)  
    public String printWelcome(ModelMap model) {  
    	
    	/*User user = new User();
    	user.setUsername("’‘ÀÆ≤®");
    	user.setPassword("123456");*/
    	
    	
    	//Serializable id = userService.saveEntity(user);
    	List<Map<String,Object>> list = userService.sqlQuery("select * from user where id=?", 3);
    	
    	
    	
    	//System.out.println("id====="+id);
    	
    	
        model.addAttribute("message", "ok");  
        return "hello.jsp";  
    }
    
    
    @RequestMapping(value="/list.do",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> returnJson(ModelMap model){
		
    	
    	List<Map<String,Object>> list = userService.sqlQuery("select * from user where id=?", 3);
    	
    	
    	return list;
    	
    	
    	
    	
    }
} 