package com.zhihua.tt.controller.admin.expert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhihua.tt.entity.expert.Expert;
import com.zhihua.tt.service.expert.ExpertService;
import com.zhihua.tt.util.ParameterUtils;
import com.zhihua.tt.util.ResultMessage;
import com.zhihua.tt.util.StringUtils;

@Controller  
@RequestMapping("/zhadmin/expert")   
public class ExpertController {  
    
	@Autowired  
    private ExpertService expertService;  
	
	/*private Expert expert ;
  

	public Expert getExpert() {
		return expert;
	}




	public void setExpert(Expert expert) {
		this.expert = expert;
	}*/




	@RequestMapping("/index.do")//url
	public String index(Model model,HttpServletRequest request,HttpServletResponse response){  
		
		
		String type = request.getParameter("type");
		if(type.equals("person")){
			model.addAttribute("type","person");
		}else if(type.equals("team")){
			model.addAttribute("type","team");
		}

	    return "expert/index.jsp" ;
	 }
	
	
	
	
	@RequestMapping("/experts.do" )
	@ResponseBody
	public List<Expert>  getExperts(Model model,HttpServletRequest request,HttpServletResponse response){
		
		String type = request.getParameter("type");
		int expertType = 0 ;
		if(type.equals("team")){
			expertType = 1 ;
		}else if(type.equals("member")){
			expertType = 2;
		}else if(type.equals("person")){
			expertType = 0 ;
		}

		List<Expert> expertList = expertService.list(" from Expert  where expertType=?", expertType);
		return expertList;
		
	}
	
	
	@RequestMapping(value="/save.do",produces = "application/json; charset=utf-8" ,method=RequestMethod.POST)
	@ResponseBody
	public ResultMessage saveExpert(Model model,HttpServletRequest request,HttpServletResponse response,Expert expert){

		try {
			String optType = request.getParameter("optType");
			//新建专家
			if(!StringUtils.isNullOrEmpty(optType) && optType.equals("new") ){
				expert.setId(0L);
				expert.setPubTime(new Date());
				expert.setPublisher("publish");
				expert.setUpdateTime(new Date());
				expert.setUpdater("publish");
				expert.setExpertType(0);
				expertService.save(expert);
			//编辑专家
			}else if(!StringUtils.isNullOrEmpty(optType) && optType.equals("edit")){
				expert.setUpdateTime(new Date());
				expert.setUpdater("edit");
				expert.setExpertType(0);
				expertService.saveOrUpdate(expert);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StringUtils.failJsonObj(e.getMessage());
			
		}
		return StringUtils.succJsonObj("操作成功！");
	}



	@RequestMapping("/get.do" )
	@ResponseBody
	public Expert getExpert(Model model,HttpServletRequest request,HttpServletResponse response) {
		long id = ParameterUtils.getLongParameter(request, "id");
		return expertService.get(id);
	}

	@RequestMapping("/remove.do" )
	@ResponseBody
	public String removeExpert(Model model,HttpServletRequest request,HttpServletResponse response){
		
		long id = ParameterUtils.getLongParameter(request, "id");
		try {
			expertService.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}
	
	
  
} 