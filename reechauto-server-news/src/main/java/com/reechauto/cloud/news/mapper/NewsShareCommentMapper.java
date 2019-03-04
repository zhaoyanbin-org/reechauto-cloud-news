package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.NewsShareComment;
import com.reechauto.cloud.news.entity.NewsShareCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: news_share_comment
* @author zhaoyb
*/
@Repository
public interface NewsShareCommentMapper {
    long countByExample(NewsShareCommentExample example);

    int deleteByExample(NewsShareCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(NewsShareComment record);

    int insertSelective(NewsShareComment record);

    List<NewsShareComment> selectByExample(NewsShareCommentExample example);

    NewsShareComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NewsShareComment record, @Param("example") NewsShareCommentExample example);

    int updateByExample(@Param("record") NewsShareComment record, @Param("example") NewsShareCommentExample example);

    int updateByPrimaryKeySelective(NewsShareComment record);

    int updateByPrimaryKey(NewsShareComment record);
}