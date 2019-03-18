package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.NewsShareLikes;
import com.reechauto.cloud.news.entity.NewsShareLikesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: news_share_likes
* @author zhaoyb
*/
@Repository
public interface NewsShareLikesMapper {
    long countByExample(NewsShareLikesExample example);

    int deleteByExample(NewsShareLikesExample example);

    int deleteByPrimaryKey(String id);

    int insert(NewsShareLikes record);

    int insertSelective(NewsShareLikes record);

    List<NewsShareLikes> selectByExample(NewsShareLikesExample example);

    NewsShareLikes selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NewsShareLikes record, @Param("example") NewsShareLikesExample example);

    int updateByExample(@Param("record") NewsShareLikes record, @Param("example") NewsShareLikesExample example);

    int updateByPrimaryKeySelective(NewsShareLikes record);

    int updateByPrimaryKey(NewsShareLikes record);
}