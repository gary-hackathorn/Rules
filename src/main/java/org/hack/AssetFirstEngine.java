package org.hack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssetFirstEngine implements Engine {
    List<Rule> rules = new ArrayList<Rule>();

    public AssetFirstEngine(List<Rule> rules) {
        this.rules = rules;
    }

    public EvaluationContext evaluate(EvaluationContext context)
    {
        for(Map<String,Object> asset:context.getAssets())
            for(Rule rule: rules)
                rule.evaluate(asset, context.getGlobals());
        return context;
    }
}