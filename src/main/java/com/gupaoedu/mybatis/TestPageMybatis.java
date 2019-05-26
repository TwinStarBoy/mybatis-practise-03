package com.gupaoedu.mybatis;

import com.gupaoedu.mybatis.v2.mapper.Blog;
import com.gupaoedu.mybatis.v2.mapper.BlogMapper;
import com.gupaoedu.mybatis.v2.session.DefaultSqlSession;
import com.gupaoedu.mybatis.v2.session.RowBounds;
import com.gupaoedu.mybatis.v2.session.SqlSessionFactory;

import java.util.List;

public class TestPageMybatis {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();

        DefaultSqlSession sqlSession = sqlSessionFactory.build().openSqlSession();

        RowBounds rowBounds = new RowBounds(0,5);

        //获取代理类
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogs = blogMapper.selectBlogList(rowBounds);

        System.out.println("第一次查询:" );
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        blogs = blogMapper.selectBlogList(rowBounds);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }


    }
}
