package com.yuanch.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/*
 * @Primary:意思是在众多相同的bean中，优先使用用@Primary注解的bean
 * @Qualifire:让Spring可以按照Bean名称进入注入@Autowired
 */

/**
 * 外部数据库配置
 */
@Configuration//注册到springboot容器
@MapperScan(basePackages= {"com.yuanch.project.mapper.mfw"},sqlSessionFactoryRef="mfwSqlSessionFactory")
public class DataSource2Config {

	static final String MAPPER_LOCATION = "classpath:mybatis/mfw/*.xml";

	@Bean(name="mfwDataSource")//注入到这个容器
	@ConfigurationProperties(prefix="mfw.datasource")//表示取application.properties配置文件中的前缀
	
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name="mfwSqlSessionFactory")

	public SqlSessionFactory testSqlSessionFactory(@Qualifier("mfwDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSource2Config.MAPPER_LOCATION));
		return bean.getObject();
	}
	@Bean(name="mfwTransactionManager")//配置事务
	
	public DataSourceTransactionManager testTransactionManager(@Qualifier("mfwDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	@Bean(name="mfwSqlSessionTemplate")
	
	public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("mfwSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
