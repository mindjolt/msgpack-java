package com.jamcity.msgpack.unpacker;

import static org.junit.Assert.assertEquals;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.packer.BufferPacker;
import com.jamcity.msgpack.type.Value;
import com.jamcity.msgpack.type.ValueFactory;
import org.junit.Test;

public class TestUnpackerSkip {
    @Test
    public void testPrimitive() throws Exception {
        MessagePack msgpack = new MessagePack();

        BufferPacker packer = msgpack.createBufferPacker();

        for (int i = 0; i < 10; i++) {
            packer.write(1);
            packer.write(i);
        }

        byte[] bytes = packer.toByteArray();
        BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);

        for (int i = 0; i < 10; i++) {
            unpacker.skip();
            int n = unpacker.readInt();
            assertEquals(i, n);
        }
    }

    @Test
    public void testNested() throws Exception {
        MessagePack msgpack = new MessagePack();

        BufferPacker packer = msgpack.createBufferPacker();

        Value v1 = ValueFactory.createArrayValue(new Value[] {
                ValueFactory.createRawValue("a"),
                ValueFactory.createMapValue(new Value[] {
                        ValueFactory.createRawValue("k1"),
                        ValueFactory
                                .createArrayValue(new Value[] { ValueFactory
                                        .createIntegerValue(1) }) }) });

        Value v2 = ValueFactory.createArrayValue(new Value[] {
                ValueFactory.createMapValue(new Value[] {
                        ValueFactory.createRawValue("k1"),
                        ValueFactory
                                .createArrayValue(new Value[] { ValueFactory
                                        .createIntegerValue(1) }),
                        ValueFactory.createRawValue("k2"),
                        ValueFactory
                                .createArrayValue(new Value[] { ValueFactory
                                        .createIntegerValue(2) }) }),
                ValueFactory.createMapValue(new Value[] {
                        ValueFactory.createRawValue("k1"),
                        ValueFactory
                                .createArrayValue(new Value[] { ValueFactory
                                        .createIntegerValue(1) }),
                        ValueFactory.createRawValue("k2"),
                        ValueFactory
                                .createArrayValue(new Value[] { ValueFactory
                                        .createIntegerValue(2) }) }),
                ValueFactory.createRawValue("a") });

        for (int i = 0; i < 10; i++) {
            packer.write(v1);
            packer.write(v2);
        }

        byte[] bytes = packer.toByteArray();
        BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);

        for (int i = 0; i < 10; i++) {
            unpacker.skip();
            Value v2a = unpacker.readValue();
            assertEquals(v2, v2a);
        }
    }
}
