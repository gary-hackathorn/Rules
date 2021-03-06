package org.hack;

import java.util.List;
import java.util.Map;

public class AssetFirstEngine implements Engine {
    private final List<Rule> rules;

    public AssetFirstEngine(List<Rule> rules) {
        this.rules = rules;
    }

    public void evaluate(EvaluationContext context)
    {
        for(Map<String,Object> assetMap:context.getAssets())
            for(Rule rule: rules)
                rule.evaluate(assetMap, context.getGlobals());
    }
}
