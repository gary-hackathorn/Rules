package org.hack;


import java.util.List;
import java.util.Map;

public interface EvaluationContext {
    List<Map<String, Object>> getAssets();
    Map<String, Object> getGlobals();
}
