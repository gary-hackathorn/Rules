package org.hack;

import com.google.common.base.Predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * AssetModifyingRule - modifies asset attributes
 *     <ul>
 *         <li>Attributes should be unique to each list</li>
 *         <li>New attributes will be added to the asset list<li>
 *     </ul>
 */
public class AssetModifyingRule implements Rule {

    private final Predicate<Map<String,Object>> condition;
    private final Action action;

    public AssetModifyingRule(Predicate<Map<String, Object>> condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public void evaluate(Map<String, Object> asset, Map<String, Object> globals) {
        Map<String, Object> commonMap = new HashMap<String, Object>(asset);
        commonMap.putAll(globals);
        if (condition.apply(commonMap))
            action.evaluate(commonMap);
        for(String key: globals.keySet())
            commonMap.remove(key);
        asset.putAll(commonMap);
    }
}
