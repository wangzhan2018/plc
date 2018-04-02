package cn.lylg.dao;

import java.util.List;

import cn.lylg.model.Customer;
import cn.lylg.model.Fenye;

public interface CustomerMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int deleteByPrimaryKey(Integer cid);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int insert(Customer record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int insertSelective(Customer record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    Customer selectByPrimaryKey(Integer cid);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int updateByPrimaryKey(Customer record);
    
    
    
    
    public  List<Customer>  selectFenye(Fenye fenye);
    
    public  List<Customer>  selectFenyeByname(Fenye fenye);
    
     public int  selectCount();
    
    
}