package com.gupaoedu.mybatis.v2.Interceptor;

import com.gupaoedu.mybatis.v2.annotation.Intercepts;
import com.gupaoedu.mybatis.v2.plugin.Interceptor;
import com.gupaoedu.mybatis.v2.plugin.Invovation;
import com.gupaoedu.mybatis.v2.plugin.Plugin;
import com.gupaoedu.mybatis.v2.session.RowBounds;

import java.util.Arrays;
import java.util.Date;

/**
 * 自定义插件
 */
@Intercepts("query")
public class MyPagePlugin implements Interceptor {
    @Override
    public Object interceptor(Invovation invovation) throws Throwable {
        System.out.println("改为物理分页");
        String statement = (String) invovation.getArgs()[0];

        Object[] parameter = (Object[]) invovation.getArgs()[1];
        RowBounds rowBounds = (RowBounds) parameter[0];

        Class pojo = (Class) invovation.getArgs()[2];
        System.out.println(rowBounds);

        if (rowBounds == RowBounds.DEFAULT){
            return invovation.proceed();
        }

//        String limit = String.format(" limit %d,%d",rowBounds.getOffset(),rowBounds.getLimit());
        String limit = " limit ?,?";
        statement = statement + limit;

        invovation.getArgs()[0] = statement;
        invovation.getArgs()[1] = new Object[]{rowBounds.getOffset(),rowBounds.getLimit()};

        System.out.println("执行的sql:" + statement);
        return invovation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }
}
