package brian.designparttern.factory.parse;

import brian.designparttern.factory.parse.impl.JsonRuleConfigParser;
import brian.designparttern.factory.parse.impl.PropertiesRuleConfigParser;
import brian.designparttern.factory.parse.impl.XmlRuleConfigParser;
import brian.designparttern.factory.parse.impl.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂的第二种实现方法
 */
public class RuleConfigParseSimple2Factory {
    private static final Map<String, IRuleConfigParser> cacheParsers = new HashMap<String, IRuleConfigParser>();
    static {
        cacheParsers.put("json",new JsonRuleConfigParser());
        cacheParsers.put("xml",new XmlRuleConfigParser());
        cacheParsers.put("properties",new PropertiesRuleConfigParser());
        cacheParsers.put("yaml",new YamlRuleConfigParser());
    }

    public static IRuleConfigParser createParse(String configFormat) {
        if(configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        return cacheParsers.get(configFormat);
    }

}
