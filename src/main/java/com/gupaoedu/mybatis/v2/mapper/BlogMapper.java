package com.gupaoedu.mybatis.v2.mapper;

import com.gupaoedu.mybatis.v2.annotation.Entity;
import com.gupaoedu.mybatis.v2.annotation.Select;
import com.gupaoedu.mybatis.v2.session.RowBounds;

import java.util.List;

@Entity(Blog.class)
public interface BlogMapper {

    /**
     * 根据文章id查询文章
     * @param bid
     * @return
     */
    @Select("select * from blog where bid = ?")
    public Blog selectBlogById(Integer bid);

    @Select("select * from blog ")
    public List<Blog> selectBlogList(RowBounds rowBounds);
}
