package brian.designparttern.factory.parse;

import brian.designparttern.factory.RuleConfig;

public interface IRuleConfigParser {
    /**
     * 规则解析
     * @param configText
     * @return
     */
    public RuleConfig parse(String configText);
}
