package com.yuanch.common.config;


import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 本地数据库配置
 */
@Configuration//注册到springboot容器
@MapperScan(basePackages= {"com.yuanch.project.mapper.komo"},sqlSessionFactoryRef="komoSqlSessionFactory")
public class DataSource1Config {

	static final String MAPPER_LOCATION = "classpath:mybatis/komo/*.xml";

	@Bean(name="komoDataSource")//注入到这个容器
	@ConfigurationProperties(prefix="komo.datasource")//表示取application.properties配置文件中的前缀
	@Primary
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name="komoSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("komoDataSource") DataSource dataSource) throws Exception {
		MybatisSqlSessionFactoryBean bean=new MybatisSqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSource1Config.MAPPER_LOCATION));
//		Interceptor interceptor = new PageInterceptor();
//		Properties properties = new Properties();
//		properties.setProperty("auto-dialect", "true");
//		properties.setProperty("reasonable", "false");
//		properties.setProperty("supportMethodsArguments","true");
//		properties.setProperty("auto-runtime-dialect","true");
//		interceptor.setProperties(properties);
//		bean.setPlugins(new Interceptor[] {interceptor});

		return bean.getObject();
	}
	@Bean(name="komoTransactionManager")//配置事务
	@Primary
	public DataSourceTransactionManager testTransactionManager(@Qualifier("komoDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	@Bean(name="komoSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("komoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
