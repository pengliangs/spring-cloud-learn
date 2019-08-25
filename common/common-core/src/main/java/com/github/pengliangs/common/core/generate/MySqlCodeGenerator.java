package com.github.pengliangs.common.core.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.github.pengliangs.common.core.constant.CharacterConstant;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author: pengliang
 * @date: 2019/4/1 13:59
 * @description：
 */
@SuppressWarnings("unchecked")
@Slf4j
public class MySqlCodeGenerator {

    public static void main(String[] args) {
        String username = "depuser";
        String password = "a4|n7:Bb*Kgaqvu";
        String url = "jdbc:mysql://120.78.87.3:3306/yinian_app_user?useUnicode=true&characterEncoding=gbk&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai";
        String[] excludePrefix = {"bs_","sys_"};
        String tableNames = "base_university";
        String authorName = "pengliang";
        MySqlCodeGenerator mySqlCodeGenerator = new MySqlCodeGenerator();
        new AutoGenerator()
                .setGlobalConfig(mySqlCodeGenerator.getGlobalConfig(authorName))
                .setDataSource(mySqlCodeGenerator.getDataSourceConfig(username, password, url))
                .setPackageInfo(mySqlCodeGenerator.getPackageConfig())
                .setStrategy(mySqlCodeGenerator.getStrategyConfig(excludePrefix, tableNames))
                .setCfg(mySqlCodeGenerator.getInjectionConfig())
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setTemplate(mySqlCodeGenerator.getTemplateConfig())
                .execute();
    }


    /**
     * 获取TemplateConfig
     *
     * @return
     */
    private TemplateConfig getTemplateConfig() {
        return new TemplateConfig().setXml(null);
    }

    /**
     * 读取控制台内容
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 全局配置
     */
    private GlobalConfig getGlobalConfig(String authorName) {
        return new GlobalConfig()
                //是否打开文件目录
                .setOpen(false)
                //输出目录
                .setOutputDir(getJavaPath())
                // 是否覆盖文件
                .setFileOverride(false)
                // 开启 activeRecord 模式
                .setActiveRecord(false)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(false)
                // XML columList
                .setBaseColumnList(false)
                .setAuthor(authorName)
                .setSwagger2(true)
                //各层文件名称方式，例如： %sAction 生成 UserAction
                .setEntityName("%s")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("I%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sRestController");
    }

    /**
     * 数据原配置
     */
    private DataSourceConfig getDataSourceConfig(String username, String password, String url) {
        // 数据源配置
        return new DataSourceConfig()
                // 数据库类型
                .setDbType(DbType.MYSQL)
                //基本信息
                .setUrl(url)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername(username)
                .setPassword(password);
    }

    /**
     * 包配置
     */
    private PackageConfig getPackageConfig() {
        return new PackageConfig()
                .setParent("com.zynn.generate")
                .setEntity("model")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper");
    }

    /**
     * 获取InjectionConfig
     *
     * @return
     */
    private InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = Maps.newHashMap();
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getResourcePath() + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        }));
    }

    /**
     * 策略配置
     *
     * @param tableName
     * @return
     */
    private StrategyConfig getStrategyConfig(String[] excludePrefix, String tableName) {
        return new StrategyConfig()
                // 全局大写命名
                .setCapitalMode(false)
                // 去除前缀
                .setTablePrefix(excludePrefix)
                // 表名生成策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setSuperEntityClass("com.zynn.framework.model.convert.Convert")
                // 自定义 mapper 父类
                .setSuperMapperClass("com.zynn.framework.mapper.BaseMapper")
                // 自定义 controller 父类
                .setSuperControllerClass("com.zynn.framework.controller.SuperController")
                // 自定义 service 实现类父类
                .setSuperServiceImplClass("com.zynn.framework.service.impl.BaseServiceImpl")
                // 自定义 service 接口父类
                .setSuperServiceClass("com.zynn.framework.service.BaseService")
                // 【实体】是否生成字段常量（默认 false）
                .setEntityColumnConstant(false)
                // 【实体】是否为构建者模型（默认 false）
                .setEntityBuilderModel(false)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setRestControllerStyle(true)
                //是否生成实体时，生成字段注解
                .setEntityTableFieldAnnotationEnable(true)
                .setInclude(StringUtils.split(tableName, CharacterConstant.SYMBOL_COMMA));
    }


    /**
     * 获取当前工程跟路径
     *
     * @return
     */
    private String getThisProjectRootPath() {
        String file = Objects.requireNonNull(MySqlCodeGenerator.class.getClassLoader().getResource("")).getFile();
        return new File(file).getParentFile().getParent();
    }


    /**
     * 获取JAVA目录
     *
     * @return
     */
    private String getJavaPath() {
        return getThisProjectRootPath() + "/src/main/java";
    }

    /**
     * 获取资源路径
     *
     * @return
     */
    private String getResourcePath() {
        return getThisProjectRootPath() + "/src/main/resources";
    }
}
