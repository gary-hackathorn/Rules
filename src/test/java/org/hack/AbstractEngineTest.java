package org.hack;

import org.easymock.EasyMockSupport;
import org.junit.Before;

import java.util.*;

public class AbstractEngineTest extends EasyMockSupport {
    protected Rule mockRule1;
    protected Rule mockRule2;
    protected List<Rule> rules;
    protected EvaluationContext mockContext;
    protected List<Map<String, Object>> assets;
    protected HashMap<String, Object> asset1;
    protected HashMap<String, Object> asset2;
    protected HashMap<String, Object> globals;
    protected Iterator<Map<String, Object>> mockIterator;


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
        assets = new ArrayList<Map<String,Object>>();
        assets.add(asset1);
        assets.add(asset2);

        globals = new HashMap<String, Object>();
        mockIterator = createMock(Iterator.class);
    }
}
