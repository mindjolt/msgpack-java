package com.jamcity.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.TestSet;
import com.jamcity.msgpack.packer.BufferPacker;
import com.jamcity.msgpack.packer.Packer;
import com.jamcity.msgpack.unpacker.BufferUnpacker;
import com.jamcity.msgpack.unpacker.Unpacker;
import org.junit.Test;


public class TestMapTemplate {

    @Test
    public void testPackUnpack() throws Exception {
	new TestPackUnpack().testMap();
    }

    @Test
    public void testPackBufferUnpack() throws Exception {
	new TestPackBufferUnpack().testMap();
    }

    @Test
    public void testBufferPackBufferUnpack() throws Exception {
	new TestBufferPackBufferUnpack().testMap();
    }

    @Test
    public void testBufferPackUnpack() throws Exception {
	new TestBufferPackUnpack().testMap();
    }

    public static class TestPackUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<K> keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template<V> valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template<Map<K, V>> tmpl = new MapTemplate<K, V>(keyElementTemplate, valueElementTemplate);
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    Map<K, V> ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestPackBufferUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<K> keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template<V> valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template<Map<K, V>> tmpl = new MapTemplate<K, V>(keyElementTemplate, valueElementTemplate);
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    Map<K, V> ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackBufferUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<K> keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template<V> valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template<Map<K, V>> tmpl = new MapTemplate<K, V>(keyElementTemplate, valueElementTemplate);
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    Map<K, V> ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<K> keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template<V> valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template<Map<K, V>> tmpl = new MapTemplate<K, V>(keyElementTemplate, valueElementTemplate);
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    Map<K, V> ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }
}
