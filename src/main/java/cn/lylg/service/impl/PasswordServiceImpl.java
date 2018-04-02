package cn.lylg.service.impl;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lylg.dao.CompanyMapper;
import cn.lylg.dao.CustomerMapper;
import cn.lylg.dao.PasswordMapper;
import cn.lylg.model.Company;
import cn.lylg.model.Customer;
import cn.lylg.model.Fenye;
import cn.lylg.model.Password;
import cn.lylg.service.ServiceI;




@Service("passwordService")
public class PasswordServiceImpl implements ServiceI {
   
	
	private  PasswordMapper  passwordMapper;
  
	

	public PasswordMapper getPasswordMapper() {
		return passwordMapper;
	}
	@Autowired
	public void setPasswordMapper(PasswordMapper passwordMapper) {
		this.passwordMapper = passwordMapper;
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
	
	public <T> List<T> selectall(Integer cid)
	{
		return (List<T>) passwordMapper.selectByCid(cid);
	}
	
	public <T> List<T> selectFenye(Fenye fenye) {
		
		return (List<T>) passwordMapper.selectFenye(fenye);
	}
	
	
public <T> List<T> selectFenyeByname(Fenye fenye) {
		
		return (List<T>) passwordMapper.selectFenyeByname(fenye);
	}
	

//根据主键删除
public  int deleteByPrimaryKey(Integer pid){
	
	return passwordMapper.deleteByPrimaryKey(pid);
	
	 
	
}
public int updateByPrimaryKeya(Integer pid)
{
	return passwordMapper.updateByPrimaryKeya(pid);
	}
public int insertSelective(Password record){
	
	return passwordMapper.insertSelective(record);
	
}

public int selectCount(){
	
	return passwordMapper.selectCount();
	
}
public Integer  selectMax(Password record){
	
	return passwordMapper.selectMax(record);
}
	public Password selectById(Integer Id)
	{
		return passwordMapper.selectByPrimaryKey(Id);
	}

}
