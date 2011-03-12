package org.hack;

import java.util.List;
import java.util.Map;

public class DefaultEvaluationContext implements EvaluationContext{
    List<Map<String, Object>> assets;
    Map<String, Object> globals;

    public DefaultEvaluationContext(List<Map<String, Object>> asset, Map<String, Object> globals) {
        this.assets = asset;
        this.globals = globals;
    }

    public List<Map<String, Object>> getAssets() {
        return assets;
    }

    public Map<String, Object> getGlobals() {
        return globals;
    }
}
