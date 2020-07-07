package brian.designparttern.factory;

import brian.designparttern.factory.parse.IRuleConfigParser;
import brian.designparttern.factory.parse.RuleConfigParseSimple2Factory;
import brian.designparttern.factory.parse.RuleConfigParseSimpleFactory;
import brian.designparttern.factory.parse.impl.JsonRuleConfigParser;
import brian.designparttern.factory.parse.impl.PropertiesRuleConfigParser;
import brian.designparttern.factory.parse.impl.XmlRuleConfigParser;
import brian.designparttern.factory.parse.impl.YamlRuleConfigParser;
import brian.exception.InvalidRuleConfigException;

public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        //简单工厂第一种实现方法 将创建解析类的逻辑抽取到单独的一个类中 if-else实现
//        IRuleConfigParser parser = RuleConfigParseSimpleFactory.createParse(ruleConfigFileExtension);
        //简单工厂第二种实现方法 将解析类放到一个Map中,通过传入的标识来获取
        IRuleConfigParser parser = RuleConfigParseSimple2Factory.createParse(ruleConfigFileExtension);
//        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new XmlRuleConfigParser();
//        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new PropertiesRuleConfigParser();
//        } else {
//            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
//        }//        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new XmlRuleConfigParser();
//        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new PropertiesRuleConfigParser();
//        } else {
//            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
//        }
        String configText = ""; //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
