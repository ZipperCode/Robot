package org.chat.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.chat.bean.vo.Face;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FaceMapper {


    @Insert("INSERT INTO face (stu_number,stu_name) values(#{stu_number},#{stu_name})")
    int insert(Face model);

    List<Face> selectByStuNumber(String stuNumber);

}
