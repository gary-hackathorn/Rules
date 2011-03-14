package org.hack;

import com.google.common.base.Predicate;

import java.util.HashMap;
import java.util.Map;

public class AssetModifyingRule implements Rule {

    Predicate<Map<String,Object>> condition;
    Action action;

    public AssetModifyingRule(Predicate<Map<String, Object>> condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public void evaluate(Map<String, Object> asset, Map<String, Object> globals) {
        Map<String, Object> commponMap = new HashMap<String, Object>(asset);
        commponMap.putAll(globals);
        if (condition.apply(commponMap))
            action.evaluate(commponMap);
        for(String key: globals.keySet())
            commponMap.remove(key);
        asset.putAll(commponMap);
    }
}