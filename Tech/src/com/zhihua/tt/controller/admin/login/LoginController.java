package com.zhihua.tt.controller.admin.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhihua.tt.entity.user.User;
import com.zhihua.tt.service.user.UserService;

@Controller  
@RequestMapping("/zhadmin/login")   
public class LoginController {  
    @Autowired  
    private UserService userService;  
  
@RequestMapping("/dologin.do") //url  
public String dologin(User user, Model model){  
    String info = loginUser(user);  
    if (!"SUCC".equals(info)) {  
        model.addAttribute("failMsg", "�û������ڻ��������");  
        return "/jsp/fail";  
    }else{  
        model.addAttribute("successMsg", "��½�ɹ���");//���ص�ҳ��˵�д��Ĳ���  
        model.addAttribute("name", user.getUsername());  
        return "/jsp/success";//���ص�ҳ��  
    }  
  }  
  
@RequestMapping("/logout.do")  
public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{  
    Subject subject = SecurityUtils.getSubject();  
    if (subject != null) {  
        try{  
            subject.logout();  
        }catch(Exception ex){  
        }  
    }  
    response.sendRedirect("/index.jsp");  
}  
  
private String loginUser(User user) {  
        if (isRelogin(user)) return "SUCC"; // ����Ѿ���½���������µ�¼  
          
        return shiroLogin(user); // ����shiro�ĵ�½��֤  
}  
private String shiroLogin(User user) {  
        // ��װtoken�������ͻ���˾���ơ���ơ��ͻ���š��û����ƣ�����  
    UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword().toCharArray(), null);   
    token.setRememberMe(true);  
      
    // shiro��½��֤  
    try {  
        SecurityUtils.getSubject().login(token);  
    } catch (UnknownAccountException ex) {  
        return "�û������ڻ����������";  
    } catch (IncorrectCredentialsException ex) {  
        return "�û������ڻ����������";  
    } catch (AuthenticationException ex) {  
        return ex.getMessage(); // �Զ��屨����Ϣ  
    } catch (Exception ex) {  
        ex.printStackTrace();  
        return "�ڲ����������ԣ�";  
    }  
    return "SUCC";  
}  
  
private boolean isRelogin(User user) {  
    Subject us = SecurityUtils.getSubject();  
        if (us.isAuthenticated()) {  
           return true; // ����δ�ı䣬�������µ�¼��Ĭ��Ϊ�Ѿ���¼�ɹ�  
        }  
        return false; // ��Ҫ���µ�½  
}  
} 