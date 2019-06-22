package com.cheer.dao;

import com.cheer.model.Examinee;
import org.apache.ibatis.annotations.Param;

public interface ExamineeMapper {
    Examinee find(@Param("num") String num);

    int update(Examinee examinee);


}
