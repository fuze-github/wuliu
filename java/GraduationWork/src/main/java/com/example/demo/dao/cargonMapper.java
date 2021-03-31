package com.example.demo.dao;

import com.example.demo.entity.Cargon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface cargonMapper {
    //客户添加货物信息
    @Insert("insert into `cargon_iformation`(`goodsname`,`weight`,`address`,`range`,`name`,`uesrstate`,`time`) values (#{goodsname},#{weight},#{address},#{range},#{name},#{uesrstate},#{time})")
    public int addcargon(Cargon cargon);

    //查看客户的货物信息
    @Select("select * from cargon_iformation")
    List<Cargon> cargonAll();

    //用户查看自己的货物信息
    @Select("select * from cargon_iformation where name=#{name}")
    List<Cargon> usercargonAll(String name);

    //管理远审核货物进行确认
    @Update("update cargon_iformation set adminstate=#{adminstate},vehicle=#{vehicle},driver=#{driver},goodsstate=#{goodsstate},uesrstate=#{uesrstate} where goodsname=#{goodsname} and name=#{name}")
    public int usercargon(Cargon cargon);

    //管理员审核货物拒绝
    @Update("update cargon_iformation set uesrstate=#{uesrstate},adminstate=#{adminstate} where goodsname=#{goodsname} and name=#{name}")
    public int usercargonn(Cargon cargon);

    //管理员确定货物送达
    @Update("update cargon_iformation set adminstate=#{adminstate}where goodsname=#{goodsname} and name=#{name}")
    public int adminservi(Cargon cargon);

    //用户确定货物送达
    @Update("update cargon_iformation set uesrstate=#{uesrstate}where goodsname=#{goodsname} and name=#{name}")
    public int userservi(Cargon cargon);

    //货物状态到达
    @Update("update cargon_iformation set goodsstate=#{goodsstate}where goodsname=#{goodsname} and name=#{name}")
    public int goodsservi(Cargon cargon);

    //管理员同意的货物
    @Select("select * from cargon_iformation where adminstate=#{adminstate}")
    List<Cargon> adminagree(String adminstate);

    //用户查看货物运输过程中
    @Select("select * from cargon_iformation where adminstate=#{adminstate} and name=#{name}")
    List<Cargon> usertransport(Cargon cargon);

    //双方确定的货物
    @Select("select * from cargon_iformation where adminstate=#{adminstate} and uesrstate=#{uesrstate}")
    List<Cargon> bothagree(@Param("adminstate")String adminstate,@Param("uesrstate")String uesrstate);

    //用户查看双方确定的货物
    @Select("select * from cargon_iformation where adminstate=#{adminstate} and uesrstate=#{uesrstate} and name=#{name}")
    List<Cargon> userarrive(Cargon cargon);
}
