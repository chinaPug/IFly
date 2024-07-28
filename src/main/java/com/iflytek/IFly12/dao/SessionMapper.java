package com.iflytek.IFly12.dao;

import com.iflytek.IFly12.entity.Session;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SessionMapper {


    /**
     * 根据用户查出所有会话Id
     * @return
     */
    @Select("select id from session where user_id = #{userId}")
    @Results({
            @Result(id = true,property = "sessionId",column = "id"),
            @Result(property = "userId" , column = "user_id"),
            @Result(property = "dialoguesJson" , column = "content")
    })
    public List<Integer> getSessionIdByUserId(Integer userId);

    /**
     * 根据会话Id查找会话内容
     */
    @Select("select content from session where id = #{sessionId}")
    public String getContentBySessionId(Integer sessionId);

    /**
     * 插入会话
     */
    @Options(useGeneratedKeys = true, keyProperty = "userId") //回写自增的主键ID
    @Insert("insert into session (user_id,content)values(#{userId},#{dialoguesJson})")
    public Boolean insertSession(Session session);

}
