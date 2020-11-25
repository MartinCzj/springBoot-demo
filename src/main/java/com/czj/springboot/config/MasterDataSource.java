package com.czj.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author ziyao.Fang
 * @date 2020/8/25 15:56
 **/
@Configuration//注解到spring容器中
@MapperScan(basePackages = "com.czj.springboot.dao",sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSource {

    @Value("${spring.datasource.master.url}")
    private String url;

    @Value("${spring.datasource.master.username}")
    private String user;

    @Value("${spring.datasource.master.password}")
    private String password;

    @Value("${spring.datasource.master.driverClassName}")
    private String driverClass;

    /**
     * 返回mes数据库的数据源
     * @return
     */
    @Bean(name="masterSource")
    @Primary//主数据源
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://192.168.2.85/mes?characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("Pwd@1234");
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效
        dataSource.setTestOnBorrow(true);//申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        dataSource.setTestOnReturn(true);//归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        //申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
        dataSource.setTestWhileIdle(true);//如果检测失败，则连接将被从池中去除
        dataSource.setTimeBetweenEvictionRunsMillis(600000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setMaxActive(20);
        dataSource.setInitialSize(10);
        return dataSource;
//        return DataSourceBuilder.create().build();
    }

    /**
     * 返回mes数据库的会话工厂
     * @param ds
     * @return
     * @throws Exception
     */
    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterSource") DataSource ds) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * 返回mes数据库的会话模板
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sessionFactory) throws  Exception{
        return  new SqlSessionTemplate(sessionFactory);
    }

    /**
     * 返回mes数据库的事务
     * @param ds
     * @return
     */
    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("masterSource") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
