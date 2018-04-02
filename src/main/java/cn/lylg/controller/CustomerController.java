package cn.lylg.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.lylg.model.Customer;
import cn.lylg.model.Fenye;
import cn.lylg.service.impl.CustomerServiceImpl;
import cn.lylg.util.DateEditor;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	private  CustomerServiceImpl  customerService;


	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

   @Resource(name="customerService")
	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

	
   @InitBinder  
   protected void initBinder(HttpServletRequest request,  
                                 ServletRequestDataBinder binder) throws Exception {  
       //对于需要转换为Date类型的属性，使用DateEditor进行处理  
       binder.registerCustomEditor(Date.class, new DateEditor());  
   }  
   
	@RequestMapping(value="/getall",produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public  Map<String,Object>  getAllCustomer(HttpServletRequest request, Model model) throws Exception {
	    
		List<Customer> list=null;
		
		Fenye fenye = new Fenye();
		
		
		int  page=new java.lang.Integer(request.getParameter("page"));
	    int  rows=new java.lang.Integer(request.getParameter("rows"));
		  
	    String name= request.getParameter("username");
	 
	    fenye.setRows(rows); //rows  一页多少行
	    fenye.setPage(page);  //page 从哪一行开始
	    fenye.setName(name);
	   
	      if(fenye.getName()!=null){ //查询操作
	    	  
	    	  list=customerService.selectFenyeByname(fenye);
	      }else {
	    	  list=customerService.selectFenye(fenye);
	      }
	    	
	    int total=  customerService.selectCount();
		
		  Map<String, Object> result = new HashMap<String, Object>() ;
          result.put("total",total);
          result.put("rows", list);
          return result;
		 
}
	@RequestMapping("/process")
	public String login(HttpServletRequest request,HttpServletResponse response,Customer cu) throws Exception {
	          
		
		String method= request.getParameter("method");
		
		
		if(method==null){
			response.sendRedirect("../user/login");
			
		}else if(method.equals("update")){
			customerService.updateByPrimaryKeySelective(cu);
			response.sendRedirect("../user/loginspass");
			
			
		}else if(method.equals("add")){
			
			customerService.insertSelective(cu);
			response.sendRedirect("../user/loginspass");
			
			
		}else if(method.equals("delete")){
			Exception ee=null;
			  int i=0;
			  response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 

			  response.setHeader("Pragma","no-cache"); //HTTP 1.0 

			  response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

			response.setCharacterEncoding("UTF-8");  
		    response.setContentType("application/json; charset=utf-8");  
		     
		          try {
		        	i=  customerService.deleteByPrimaryKey(cu.getCid());
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					    	   
			        
			           if(i==1){
			        	   response.getWriter().write("{\"isok\":\"ok\"}");
			           }else{
			        	  
			        	   response.getWriter().write("{\"isok\":\"error\"}");
			           }
		
		       
		        response.getWriter().flush();
		        response.getWriter().close();
				}
	
			
			
			
		}
		 
		return "/main";	
			
		}



}