package com.example.configuration;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * @Description:com.example.configuration
 * @Date:2023/9/17
 * @Author:谢锦创
 */
@Configuration
@MapperScan("com.example.mapper")
public class MyBatisConfig {

    @Autowired
    private DataSource dataSource;

//    @Bean
//    public SqlSessionFactoryBean getSqlSessionBean(DataSource dataSource) {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        return sqlSessionFactoryBean;
//    }

//    @Bean
//    public SqlSessionTemplate getSqlSession(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
