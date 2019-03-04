package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.NewsShare;
import com.reechauto.cloud.news.entity.NewsShareExample;
import com.reechauto.cloud.news.entity.NewsShareWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: news_share
* @author zhaoyb
*/
@Repository
public interface NewsShareMapper {
    long countByExample(NewsShareExample example);

    int deleteByExample(NewsShareExample example);

    int deleteByPrimaryKey(String id);

    int insert(NewsShareWithBLOBs record);

    int insertSelective(NewsShareWithBLOBs record);

    List<NewsShareWithBLOBs> selectByExampleWithBLOBs(NewsShareExample example);

    List<NewsShare> selectByExample(NewsShareExample example);

    NewsShareWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NewsShareWithBLOBs record, @Param("example") NewsShareExample example);

    int updateByExampleWithBLOBs(@Param("record") NewsShareWithBLOBs record, @Param("example") NewsShareExample example);

    int updateByExample(@Param("record") NewsShare record, @Param("example") NewsShareExample example);

    int updateByPrimaryKeySelective(NewsShareWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NewsShareWithBLOBs record);

    int updateByPrimaryKey(NewsShare record);
}