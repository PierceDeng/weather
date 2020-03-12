package com.zzzfyrw.repository;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;

public class MyBatisGenerator{

    static String url = "jdbc:mysql://rm-bp1r7od3hc4rh63amuo.mysql.rds.aliyuncs.com:3306/weather?useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=true";
    static String user = "prsandd";
    static String pwd = "Dpz440504";

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        GlobalConfig config = new GlobalConfig();
        config.setAuthor("dpz");
        config.setOutputDir(System.getProperty("user.dir")
                + File.separator+"repository"+File.separator+"src"
                + File.separator+"main"+File.separator+"java");
        config.setOpen(false);
        config.setEntityName("%sEntity");
        config.setMapperName("%sMapper");
        config.setXmlName("%sMapper");
        config.setBaseColumnList(true);
        config.setBaseResultMap(true);
        config.setFileOverride(true);

        DataSourceConfig source = new DataSourceConfig();
        source.setUrl(url);
        source.setDriverName("com.mysql.cj.jdbc.Driver");
        source.setUsername(user);
        source.setPassword(pwd);
        source.setDbType(DbType.MYSQL);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.zzzfyrw.repository");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("dao");
        packageConfig.setXml("xml");

        StrategyConfig strategy = new StrategyConfig();
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityLombokModel(true);

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                ;
            }
        };

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);

        generator.setGlobalConfig(config);
        generator.setPackageInfo(packageConfig);
        generator.setDataSource(source);
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.setCfg(injectionConfig);
        generator.setTemplate(templateConfig);

        generator.execute();
    }

}
