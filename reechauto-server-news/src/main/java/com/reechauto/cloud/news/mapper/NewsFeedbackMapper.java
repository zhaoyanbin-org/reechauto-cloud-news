package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.NewsFeedback;
import com.reechauto.cloud.news.entity.NewsFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: news_feedback
* @author zhaoyb
*/
@Repository
public interface NewsFeedbackMapper {
    long countByExample(NewsFeedbackExample example);

    int deleteByExample(NewsFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsFeedback record);

    int insertSelective(NewsFeedback record);

    List<NewsFeedback> selectByExample(NewsFeedbackExample example);

    NewsFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsFeedback record, @Param("example") NewsFeedbackExample example);

    int updateByExample(@Param("record") NewsFeedback record, @Param("example") NewsFeedbackExample example);

    int updateByPrimaryKeySelective(NewsFeedback record);

    int updateByPrimaryKey(NewsFeedback record);
}