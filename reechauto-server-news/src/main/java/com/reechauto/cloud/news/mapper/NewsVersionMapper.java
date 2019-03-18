package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.NewsVersion;
import com.reechauto.cloud.news.entity.NewsVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: news_version
* @author zhaoyb
*/
@Repository
public interface NewsVersionMapper {
    long countByExample(NewsVersionExample example);

    int deleteByExample(NewsVersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsVersion record);

    int insertSelective(NewsVersion record);

    List<NewsVersion> selectByExample(NewsVersionExample example);

    NewsVersion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsVersion record, @Param("example") NewsVersionExample example);

    int updateByExample(@Param("record") NewsVersion record, @Param("example") NewsVersionExample example);

    int updateByPrimaryKeySelective(NewsVersion record);

    int updateByPrimaryKey(NewsVersion record);
}