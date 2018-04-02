package cn.lylg.dao;

import cn.lylg.model.Company;

public interface CompanyMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int insert(Company record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int insertSelective(Company record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    Company selectByPrimaryKey(Integer uid);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int updateByPrimaryKeySelective(Company record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    int updateByPrimaryKey(Company record);
    
    
    int getByNamePass(Company record);
}