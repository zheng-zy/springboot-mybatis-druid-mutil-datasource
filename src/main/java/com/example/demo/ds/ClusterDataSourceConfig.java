package com.example.demo.ds;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>cluster数据源</p>
 * Created by zhezhiyong@163.com on 2017/6/1.
 */
@Configuration
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
@ConfigurationProperties(prefix = "cluster.datasource")
@Data
public class ClusterDataSourceConfig {

    static final String PACKAGE = "com.example.demo.mapper.cluster";
    static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

    private String url;
    private String user;
    private String password;
    private String driverClass;

    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName("cluster");
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        // 配置初始化大小、最小、最大
        dataSource.setInitialSize(0);
        dataSource.setMinIdle(0);
        dataSource.setMaxActive(10);
        // 配置获取连接等待超时的时间
        dataSource.setMaxWait(15000);
        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        // 配置一个连接在池中最小生存的时间，一个小时
        dataSource.setMinEvictableIdleTimeMillis(3600000);
        dataSource.setTestWhileIdle(true);
        // 这里建议配置为TRUE，防止取到的连接不可用
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(false);
        // 这里配置提交方式，默认就是TRUE，可以不用配置
        dataSource.setDefaultAutoCommit(true);
        // 验证连接有效与否的SQL，不同的数据配置不同
        dataSource.setValidationQuery("SELECT 1");
        return dataSource;
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
