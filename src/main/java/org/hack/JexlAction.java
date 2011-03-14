package org.hack;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.MapContext;

import java.util.Map;

public class JexlAction extends CommonJexl implements Action{

    Expression expression;

    public JexlAction(String expressionString) {
        this.expression = engine.createExpression(expressionString);
    }

    @Override
    public void evaluate(Map<String, Object> map) {
        JexlContext jc = new MapContext(map);
        expression.evaluate(jc);
    }
}
