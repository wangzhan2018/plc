package cn.lylg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lylg.dao.CompanyMapper;
import cn.lylg.model.Company;
import cn.lylg.service.ServiceI;




@Service("companyService")
public class CompanyServiceImpl implements ServiceI {
   
	
	private CompanyMapper companyMapper;
  
	
	public CompanyMapper getCompanyMapper() {
		return companyMapper;
	}
	
    @Autowired
	public void setCompanyMapper(CompanyMapper companyMapper) {
		this.companyMapper = companyMapper;
	}

	
	
	public <T> T getById(T id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 
	 */
	public Integer getByNamePass(String uname,String upassword) {
		Company co= new Company();
		co.setUname(uname);
		co.setUpassword(upassword);
		
		int i=companyMapper.getByNamePass(co);

		
		
		return i;
	}
  




	

}
