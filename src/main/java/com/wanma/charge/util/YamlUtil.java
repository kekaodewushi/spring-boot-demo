package com.wanma.charge.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;

/**
 * @author zangyy
 * @date 2018/10/10
 * yaml工具类
 */
public class YamlUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(YamlUtil.class);

    private static Map yamlMap = getConfigMapByYmlFile();

    public static String getProperty(String key) {
        Object obj = yamlMap.get(key);
        return obj == null ? null : obj.toString();
    }

    private static Map getConfigMapByYmlFile() {
        try {
            URL url = YamlUtil.class.getClassLoader().getResource("system.yml");
            if (url == null) {
                LOGGER.error("config file is not find");
                return null;
            }

            Yaml yaml = new Yaml();
            return (Map) yaml.load(new FileInputStream(url.getFile()));
        } catch (Exception e) {
            LOGGER.error("Test-getConfigMapByYmlFile is error", e);
            return null;
        }
    }
}
