package org.hack;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
    public void setUp() throws Exception {
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
}
