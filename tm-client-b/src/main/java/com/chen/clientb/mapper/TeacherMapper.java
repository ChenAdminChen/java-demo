package com.chen.clientb.mapper;


import com.chen.clientb.module.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface TeacherMapper {
    @Insert("insert into teacher(name) values(#{name})")
    @Options(useGeneratedKeys = true,  keyProperty = "id")
    int add(Teacher teacher);
}
