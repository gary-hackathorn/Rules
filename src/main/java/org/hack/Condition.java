package org.hack;

import java.util.Map;

public interface Condition {
    boolean evaluate(Map<String,Object> asset, Map<String,Object> globals);
}
