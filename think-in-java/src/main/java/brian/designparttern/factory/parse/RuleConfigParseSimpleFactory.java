package brian.designparttern.factory.parse;

import brian.designparttern.factory.parse.impl.JsonRuleConfigParser;
import brian.designparttern.factory.parse.impl.PropertiesRuleConfigParser;
import brian.designparttern.factory.parse.impl.XmlRuleConfigParser;
import brian.designparttern.factory.parse.impl.YamlRuleConfigParser;

public class RuleConfigParseSimpleFactory {
    public static IRuleConfigParser createParse(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}
