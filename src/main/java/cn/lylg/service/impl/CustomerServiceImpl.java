package cn.lylg.service.impl;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lylg.dao.CompanyMapper;
import cn.lylg.dao.CustomerMapper;
import cn.lylg.model.Company;
import cn.lylg.model.Customer;
import cn.lylg.model.Fenye;
import cn.lylg.service.ServiceI;




@Service("customerService")
public class CustomerServiceImpl implements ServiceI {
   
	
	private  CustomerMapper  customerMapper;
  
	

	
	
	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}
    @Autowired
	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	public <T> T getById(T id) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 
	 */
	public <T> List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public <T> List<T> selectFenye(Fenye fenye) {
		
		return (List<T>) customerMapper.selectFenye(fenye);
	}
	
public <T> List<T> selectFenyeByname(Fenye fenye) {
		
		return (List<T>) customerMapper.selectFenyeByname(fenye);
	}
	
  
public  int updateByPrimaryKeySelective(Customer record) {
	
	
	return  customerMapper.updateByPrimaryKeySelective(record);
}
//根据主键删除
public  int deleteByPrimaryKey(Integer cid){
	
	return customerMapper.deleteByPrimaryKey(cid);
	
	 
	
}
public int insertSelective(Customer record){
	
	return customerMapper.insertSelective(record);
	
}

public int selectCount(){
	
	return customerMapper.selectCount();
	
}

	

}
