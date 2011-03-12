package org.hack;

import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AssetFirstEngineTest extends AbstractEngineTest {


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

}
