package cn.lylg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.lylg.model.Fenye;
import cn.lylg.model.Password;
import cn.lylg.service.impl.PasswordServiceImpl;
import cn.lylg.util.DateEditor;

@Controller
@RequestMapping("/password")
public class PasswordController {

	 
	private  PasswordServiceImpl  passwordService;

	




   public PasswordServiceImpl getPasswordService() {
		return passwordService;
	}
    @Resource(name="passwordService")
	public void setPasswordService(PasswordServiceImpl passwordService) {
		this.passwordService = passwordService;
	}

@InitBinder  
   protected void initBinder(HttpServletRequest request,  
                                 ServletRequestDataBinder binder) throws Exception {  
       //对于需要转换为Date类型的属性，使用DateEditor进行处理  
       binder.registerCustomEditor(Date.class, new DateEditor());  
   }  
   
	@RequestMapping(value="/getall",produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public  Map<String,Object>  getAllCustomer(HttpServletRequest request,HttpServletResponse response) throws Exception {
	    
		List<Password> list=null;
		
		Fenye fenye = new Fenye();
		
		
		int  page=new java.lang.Integer(request.getParameter("page"));
	    int  rows=new java.lang.Integer(request.getParameter("rows"));
		  
	    String name= request.getParameter("username");
	 
	    fenye.setRows(rows); //rows  一页多少行
	    fenye.setPage(page);  //page 从哪一行开始
	    fenye.setName(name);
	   
	      if(fenye.getName()!=null){ //查询操作
	    	  list=passwordService.selectFenyeByname(fenye);
	      }else {
	    	  list=passwordService.selectFenye(fenye);
	      }
	    	
	    int total=  passwordService.selectCount();
		
		  Map<String, Object> result = new HashMap<String, Object>() ;
          result.put("total",total);
          result.put("rows", list);
          return result;
		 
}
	@RequestMapping("/process")
	public String login(HttpServletRequest request,HttpServletResponse response,Password pa) throws Exception {
	          
		
		String method= request.getParameter("method");
		Integer pid=Integer.parseInt(request.getParameter("pid"));
		
		if(method==null){
			response.sendRedirect("../user/login");
			
		}else if(method.equals("delete")){
			
			response.setCharacterEncoding("UTF-8");  
		    response.setContentType("application/json; charset=utf-8");
		  //  System.out.println("=============================>"+pa.getPid());
		    passwordService.deleteByPrimaryKey(pa.getPid());
	        response.getWriter().write("{\"isok\":\"ok\"}");
	        response.getWriter().flush();
	        response.getWriter().close();
			
			
			
		}
		else if(method.equals("shiyong"))
		{
			response.setCharacterEncoding("UTF-8");  
		    response.setContentType("application/json; charset=utf-8");
		  //  System.out.println("=============================>"+pa.getPid());
		    passwordService.updateByPrimaryKeya(pid);
	        response.getWriter().write("{\"isok\":\"ok\"}");
	        response.getWriter().flush();
	        response.getWriter().close();	
		}
		return "/main";	
			
		}
	@RequestMapping("/doPass")
	@ResponseBody
	public String doPass(HttpServletRequest request,HttpServletResponse response,Password pa) throws Exception {
	          
		
		String psdate= request.getParameter("psdate");
		String ptype= request.getParameter("ptype");
	System.out.println("ptype:"+ptype);	
			String code=pass(psdate, ptype);
			HttpSession session=request.getSession();
			session.setAttribute("date",psdate); 
		
		
		return code;
			
		}
	 public String pass(String date,String ptype){
		 

	   //  String date="2015-08-01" ;
	   /*  String newdate=     date.replaceAll("-", ""); //20150801
	     StringBuffer sb= new StringBuffer(newdate);
	     
         String gd="HtpYS" ;
         if(ptype.equals("超级密码")||ptype=="超级密码"){
        	 
             for(int i=0;i<gd.length()*2;i=i+2){        	  
          		   sb.insert(i, gd.charAt(i/2));       		   
             }
           String  a1=sb.substring(0, 1);
           String  a2=sb.substring(1,2);
           String  a8=sb.substring(7, 8);
           String  a10=sb.substring(9,10);
             sb.replace(0, 1, a8).replace(7, 8, a1)
                .replace(1, 2, a10).replace(9, 10, a2);
            // 50t0p1YHS2723    super
             String sup="SUPER";
             for(int i=0;i<sup.length()*2;i=i+2){        	  
        		   sb.insert(i, sup.charAt(i/2));       		   
           }
             
        	 
         }else{
        	 
           for(int i=0;i<gd.length()*2;i=i+2){        	  
        		   sb.insert(i, gd.charAt(i/2));       		   
           }
         String  a1=sb.substring(0, 1);
         String  a2=sb.substring(1,2);
         String  a8=sb.substring(7, 8);
         String  a10=sb.substring(9,10);
           sb.replace(0, 1, a8).replace(7, 8, a1)
              .replace(1, 2, a10).replace(9, 10, a2);
         }
         
		return sb.toString();
		*/
		 
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Date date1=new Date();
		try {
			date1 = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String newdate=     date.replaceAll("-", ""); //20150801
		  
			String math;
			String day;
			String year=newdate.substring(0,4);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			String result;
			int weekDay = cal.get(Calendar.DAY_OF_WEEK);
			if(newdate.substring(4,5).equals("0"))
			{
				math=newdate.substring(5,6);
			}
			else
			{
				math=newdate.substring(4,6);
			}
			if(newdate.substring(6, 7).equals("0"))
			{
				day=newdate.substring(7, 8);
			}
			else
			{
				day=newdate.substring(6, 8);
			}
			if(weekDay==1)
			{
				weekDay=8;
			}
			int base=(Integer.parseInt(math)*100+Integer.parseInt(day)+Integer.parseInt(year))*(weekDay-1);
			String two=Integer.toBinaryString(base) ;
			if(ptype.equals("超级密码")||ptype=="超级密码"){
			result=Integer.valueOf(two.substring(0, two.length()-2), 2).toString();
			}
			else if(ptype.equals("普通密码")||ptype=="普通密码")
			{
				result=Integer.valueOf(two.substring(0, two.length()-1), 2).toString();
			}
			else
			{
				result=Integer.valueOf(two.substring(0, two.length()-3), 2).toString();
			}
			
			 
			return result;
	 }
	
	 	@RequestMapping("/doAddPass")
		@ResponseBody
		public String doAddPass(HttpServletRequest request,HttpServletResponse response,Password pa) throws Exception {		
	 		/*
	 		 * 查询最大次数累计
	 		 */
	 		try {
	 			Integer max=	 passwordService.selectMax(pa);
	 			
	 			Integer i;
	 			
	 			List<Password> paList=null;
	 			
	 			paList=passwordService.selectall(pa.getCid());
	 			int count=paList.size();
	 			for(i=0;i<count;i=i+1)
	 			{
	 				
	 				//System.out.println(paList.get(i).getPsdate()+pa.getPsdate().toString());
	 				if(paList.get(i).getPsdate().equals(pa.getPsdate())&&paList.get(i).getPtype().equals(pa.getPtype()))
	 				{
	 					break;
	 				}
	 				
	 			}
	 			if(i==count)
	 			{
	 				if(max==null){
 		 				pa.setPtimes(1);
 		 			}else{
 		 				pa.setPtimes(max+1);
 		 			} 	
	 				pa.setState("未使用");
 		 			passwordService.insertSelective(pa);
 		 			System.out.println(pa.getState());
 		 			return "ok";
	 			}
	 			else
	 			{
	 				return "repeat";
	 			}
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
	
			}
}