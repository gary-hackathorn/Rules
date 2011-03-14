package org.hack;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class AssetModifyingRuleTest {
    protected Map<String, Object> asset;
    protected Map<String, Object> globals;

    @Before
    public void setUp() throws Exception {
        asset = new HashMap<String,Object>();
        globals = new HashMap<String,Object>();
    }

    @Test
    public void testAddValue() throws Exception {
        Rule rule = new AssetModifyingRule(new JexlCondition("true"), new JexlAction("key='value'"));
        rule.evaluate(asset, globals);
        assertEquals(null, globals.get("key"));
        assertEquals("value",asset.get("key"));
    }

    @Test
    public void testAddValueWithFalse() throws Exception {
        Rule rule = new AssetModifyingRule(new JexlCondition("false"), new JexlAction("key='value'"));
        rule.evaluate(asset, globals);
        assertEquals(null, globals.get("key"));
        assertEquals("Rule fires action even though condition was false",null ,asset.get("key"));
    }

    @Test
    public void testAddValueWithGlobal() throws Exception {
        Rule rule = new AssetModifyingRule(new JexlCondition("true"), new JexlAction("key='value'"));
        globals.put("globalKey","globalValue");
        rule.evaluate(asset, globals);
        assertEquals("globalValue", globals.get("globalKey"));
        assertEquals("Global got duplicated to asset map", null, asset.get("globalKey"));
        assertEquals("value",asset.get("key"));
    }
}
