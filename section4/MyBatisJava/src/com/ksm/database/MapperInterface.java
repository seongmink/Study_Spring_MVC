package com.ksm.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ksm.beans.DataBean;

public interface MapperInterface {
	@Insert("insert into spring(data1, data2, data3) values (#{data1}, #{data2}, #{data3})")
    void insert_data(DataBean dataBean);
    
    @Select("select data1, data2, data3 from spring")
    List<DataBean> select_data();
}