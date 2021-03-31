package com.example.demo.dao;

import com.example.demo.entity.Distribution;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface distributionMapper {
    //查询全部
    @Select("select * from distribution_scope")
    List<Distribution> distribuntionAll();

    //添加配送范围
    @Insert("insert into `distribution_scope`(`name`,`describe`) values (#{name},#{describe})")
    public int adddistribuntion(Distribution distribution);

    //修改配送范围
    @Update("update `distribution_scope` set `name`=#{name},`describe`=#{describe} where id=#{id} ")
    public int updatedistribuntion(Distribution distribution);

    //删除配送范围
    @Delete(" delete from distribution_scope where id= #{id} ")
    public int deletedistribuntion(int id);
}
