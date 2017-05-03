package org.msgpack;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.msgpack.annotation.MessagePackMessage;
import org.msgpack.template.Template;
import static org.msgpack.template.Templates.tList;
import static org.msgpack.template.Templates.tMap;
import org.msgpack.type.Value;
import org.msgpack.type.ValueFactory;


public class TestClassTemplate {

    @MessagePackMessage
    public class TestA {
        public int i;
        private float f;
        public TestA() {}
        float getF() { return f; }
        void setF(float v) { f = v; }
    }

    @Test
    public void testClassTemplate() throws Exception {
        TestA t1 = new TestA();
        t1.i = 42;
        t1.setF(-999);
        MessagePack mp = new MessagePack();
        byte[] buffer = mp.write(t1);
        TestA t2 = mp.read(buffer, (TestA)null);
        assertEquals(t1.i, t2.i);
        assertEquals(t1.getF(), t2.getF());
    }
}