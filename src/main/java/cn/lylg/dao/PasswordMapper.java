package cn.lylg.dao;

import java.util.List;


import cn.lylg.model.Fenye;
import cn.lylg.model.Password;

public interface PasswordMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int deleteByPrimaryKey(Integer pid);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int insert(Password record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int insertSelective(Password record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    Password selectByPrimaryKey(Integer pid);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int updateByPrimaryKeySelective(Password record);
 
    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int updateByPrimaryKey(Password record);
    int updateByPrimaryKeya(Integer pid);
    
    
    public  List<Password>  selectFenye(Fenye fenye);
    
    public  List<Password>  selectFenyeByname(Fenye fenye);
    public  List<Password>  selectByCid(Integer cid);
     public int  selectCount();
     
     public Integer  selectMax(Password record );
}