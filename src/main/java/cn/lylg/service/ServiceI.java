package cn.lylg.service;

import java.util.List;





public interface ServiceI {

	public <T> T getById(T id);

	public <T> List<T> getAll();
    
	

}
