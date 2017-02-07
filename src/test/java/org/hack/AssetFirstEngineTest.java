package org.hack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AssetFirstEngineTest {


    @Test
    public void testEngineWithRealObjects() throws Exception {
        List<Map<String,Object>> assetList = new ArrayList<Map<String, Object>>();
        Map<String,Object> asset1 = new HashMap<String, Object>();
        asset1.put("X", 3);
        asset1.put("Y", 20);
        asset1.put("result", "na");
        assetList.add(asset1);
        Map<String,Object> globals = new HashMap<String, Object>();
        DefaultEvaluationContext context = new DefaultEvaluationContext(assetList, globals);
        JexlCondition condition = new JexlCondition("X < Y");
        JexlAction action = new JexlAction("result = X * Y");
        List<Rule> rulesList = new ArrayList<Rule>();
        rulesList.add(new AssetModifyingRule(condition, action));

        AssetFirstEngine engine = new AssetFirstEngine(rulesList);
        engine.evaluate(context);
        assertEquals("Should be 3 * 20 = 60", 60, asset1.get("result")) ;
    }
}
