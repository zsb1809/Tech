package com.zhihua.tt.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
@RequestMapping("/zhadmin")  
public class ZhAdminController { 
	
	
    @RequestMapping(value="/index.do",method = RequestMethod.GET)  
    public String dispacher(ModelMap model) {  

        //model.addAttribute("message", "ok");  
        return "layout.jsp";  
    }  
    
    
    
    
    
    
    
    
    
} 