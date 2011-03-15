package org.hack;

import com.google.common.base.Predicate;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.Map;

class JexlCondition extends CommonJexl implements Predicate<Map<String,Object>> {

    private final Expression expression;

    public JexlCondition(String jexlString) {
        this.expression = engine.createExpression(jexlString);
    }

    @Override
    public boolean apply( Map<String,Object> map) {
        JexlContext jc = new MapContext(map);
        return (Boolean) expression.evaluate(jc);
    }
}
