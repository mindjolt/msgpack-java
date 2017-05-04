package com.jamcity.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.TestSet;
import com.jamcity.msgpack.packer.BufferPacker;
import com.jamcity.msgpack.unpacker.BufferUnpacker;
import com.jamcity.msgpack.unpacker.Unpacker;
import org.junit.Test;
import com.jamcity.msgpack.packer.Packer;

public class TestCharacterTemplate {

    @Test
    public void testPackUnpack() throws Exception {
        new TestPackUnpack().testCharacter();
    }

    @Test
    public void testPackBufferUnpack() throws Exception {
        new TestPackBufferUnpack().testCharacter();
    }

    @Test
    public void testBufferPackBufferUnpack() throws Exception {
        new TestBufferPackBufferUnpack().testCharacter();
    }

    @Test
    public void testBufferPackUnpack() throws Exception {
        new TestBufferPackUnpack().testCharacter();
    }

    public static class TestPackUnpack extends TestSet {
        @Test @Override
        public void testCharacter() throws Exception {
            super.testCharacter();
        }

        @Override
        public void testCharacter(Character v) throws Exception {
            MessagePack msgpack = new MessagePack();
            Template<Character> tmpl = CharacterTemplate.instance;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Packer packer = msgpack.createPacker(out);
            tmpl.write(packer, v);
            byte[] bytes = out.toByteArray();
            Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
            unpacker.resetReadByteCount();
            Character ret = tmpl.read(unpacker, null);
            assertEquals(v, ret);
            assertEquals(bytes.length, unpacker.getReadByteCount());
        }
    }

    public static class TestPackBufferUnpack extends TestSet {
        @Test @Override
        public void testCharacter() throws Exception {
            super.testCharacter();
        }

        @Override
        public void testCharacter(Character v) throws Exception {
            MessagePack msgpack = new MessagePack();
            Template<Character> tmpl = CharacterTemplate.instance;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Packer packer = msgpack.createPacker(out);
            tmpl.write(packer, v);
            byte[] bytes = out.toByteArray();
            BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
            unpacker.resetReadByteCount();
            Character ret = tmpl.read(unpacker, null);
            assertEquals(v, ret);
            assertEquals(bytes.length, unpacker.getReadByteCount());
        }
    }

    public static class TestBufferPackBufferUnpack extends TestSet {
        @Test @Override
        public void testCharacter() throws Exception {
            super.testCharacter();
        }

        @Override
        public void testCharacter(Character v) throws Exception {
            MessagePack msgpack = new MessagePack();
            Template<Character> tmpl = CharacterTemplate.instance;
            BufferPacker packer = msgpack.createBufferPacker();
            tmpl.write(packer, v);
            byte[] bytes = packer.toByteArray();
            BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
            unpacker.resetReadByteCount();
            Character ret = tmpl.read(unpacker, null);
            assertEquals(v, ret);
            assertEquals(bytes.length, unpacker.getReadByteCount());
        }
    }

    public static class TestBufferPackUnpack extends TestSet {
        @Test @Override
        public void testCharacter() throws Exception {
            super.testCharacter();
        }

        @Override
        public void testCharacter(Character v) throws Exception {
            MessagePack msgpack = new MessagePack();
            Template<Character> tmpl = CharacterTemplate.instance;
            BufferPacker packer = msgpack.createBufferPacker();
            tmpl.write(packer, v);
            byte[] bytes = packer.toByteArray();
            Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
            unpacker.resetReadByteCount();
            Character ret = tmpl.read(unpacker, null);
            assertEquals(v, ret);
            assertEquals(bytes.length, unpacker.getReadByteCount());
        }
    }
}
