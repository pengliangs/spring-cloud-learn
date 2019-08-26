package com.github.pengliangs.user;

import com.github.pengliangs.common.core.generate.GeneratorParam;
import com.github.pengliangs.common.core.generate.MySqlCodeGenerator;

/**
 * @author pengliang
 * @date 2019/8/26 15:30
 */
public class CodeGenerator {
    public static void main(String[] args){
        MySqlCodeGenerator.generator(new GeneratorParam()
                .setAuthorName("pengliang")
                .setUrl("jdbc:mysql:///database?useUnicode=true&characterEncoding=gbk&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai")
                .setUsername("root")
                .setPassword("root")
                .setPrefixExcludes("user_")
                .setTables("user_base_info")
        );
    }
}
