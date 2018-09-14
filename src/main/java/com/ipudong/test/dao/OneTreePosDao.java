package com.ipudong.test.dao;


import com.ipudong.test.entity.OneTreePosDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OneTreePosDao {

    Boolean insertBatch(List<OneTreePosDO> list);

    String getPos(@Param("id") Long id);

}
