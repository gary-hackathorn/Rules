package org.hack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertSame;

public class DefaultEvaluationContextTest {

    @Test
    public void testConstructor() throws Exception {
        List<Map<String, Object>> asset = new ArrayList<Map<String,Object>>();
        Map<String, Object> globals = new HashMap<String, Object>();
        EvaluationContext context = new DefaultEvaluationContext(asset, globals);
        assertSame(asset, context.getAssets());
        assertSame(globals, context.getGlobals());
    }
}
