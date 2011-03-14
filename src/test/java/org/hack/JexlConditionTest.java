package org.hack;

import com.google.common.base.Predicate;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class JexlConditionTest {
    @Test
    public void testApply() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("x", 2);
        map.put("y", 4);
        Predicate<Map<String,Object>> condition = new JexlCondition("x + x eq y");
        assertEquals(true, condition.apply(map));
    }
}
