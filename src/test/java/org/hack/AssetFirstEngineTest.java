package org.hack;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.easymock.EasyMock.expect;

public class AssetFirstEngineTest extends EasyMockSupport {


    private Rule mockRule1;
    private Rule mockRule2;
    private List<Rule> rules;
    private EvaluationContext mockContext;
    private List<Map<String, Object>> assets;
    private HashMap<String, Object> asset1;
    private HashMap<String, Object> asset2;
    private HashMap<String, Object> globals;


    @Test
    public void testEngine() throws Exception {


        expect(mockContext.getAssets()).andReturn(assets).anyTimes();
        expect(mockContext.getGlobals()).andReturn(globals).anyTimes();
        mockRule1.evaluate(asset1, globals);
        mockRule2.evaluate(asset1, globals);
        mockRule1.evaluate(asset2, globals);
        mockRule2.evaluate(asset2, globals);
        Engine engine = new AssetFirstEngine(rules);
        replayAll();
        engine.evaluate(mockContext);
        verifyAll();
    }

    @SuppressWarnings(value = "unchecked")
    @Before
    public void setUp() {
        rules = new ArrayList<Rule>();
        mockRule1 = createMock(Rule.class);
        rules.add(mockRule1);
        mockRule2 = createMock(Rule.class);
        rules.add(mockRule2);
        mockContext = createMock(EvaluationContext.class);
        asset1 = new HashMap<String, Object>();
        asset2 = new HashMap<String, Object>();
        assets = new ArrayList<Map<String,Object>>();
        assets.add(asset1);
        assets.add(asset2);

        globals = new HashMap<String, Object>();
    }

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
        System.out.println("result = "+asset1.get("result")) ;
    }
}
