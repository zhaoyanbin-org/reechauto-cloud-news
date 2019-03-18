package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.NewsNotice;
import com.reechauto.cloud.news.entity.NewsNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: news_notice
* @author zhaoyb
*/
@Repository
public interface NewsNoticeMapper {
    long countByExample(NewsNoticeExample example);

    int deleteByExample(NewsNoticeExample example);

    int deleteByPrimaryKey(String id);

    int insert(NewsNotice record);

    int insertSelective(NewsNotice record);

    List<NewsNotice> selectByExample(NewsNoticeExample example);

    NewsNotice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NewsNotice record, @Param("example") NewsNoticeExample example);

    int updateByExample(@Param("record") NewsNotice record, @Param("example") NewsNoticeExample example);

    int updateByPrimaryKeySelective(NewsNotice record);

    int updateByPrimaryKey(NewsNotice record);
}