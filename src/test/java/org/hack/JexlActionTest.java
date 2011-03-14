package org.hack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class JexlActionTest {
    @Test
    public void testSimpleAction() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        Action action = new JexlAction("key='value'");
        action.evaluate(map);
        assertEquals("value", map.get("key"));
    }
}
