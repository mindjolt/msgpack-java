package com.jamcity.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

import com.jamcity.msgpack.packer.BufferPacker;
import org.junit.Test;
import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.TestSet;
import com.jamcity.msgpack.packer.Packer;
import com.jamcity.msgpack.unpacker.BufferUnpacker;
import com.jamcity.msgpack.unpacker.Unpacker;


public class TestBigDecimalTemplate {

    @Test
    public void testPackUnpack() throws Exception {
	new TestPackUnpack().testBigDecimal();
    }

    @Test
    public void testPackBufferUnpack() throws Exception {
	new TestPackBufferUnpack().testBigDecimal();
    }

    @Test
    public void testBufferPackBufferUnpack() throws Exception {
	new TestBufferPackBufferUnpack().testBigDecimal();
    }

    @Test
    public void testBufferPackUnpack() throws Exception {
	new TestBufferPackUnpack().testBigDecimal();
    }

    public static class TestPackUnpack extends TestSet {
	@Test @Override
	public void testBigDecimal() throws Exception {
	    super.testBigDecimal();
	}

	@Override
	public void testBigDecimal(BigDecimal v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigDecimal> tmpl = BigDecimalTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    BigDecimal ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestPackBufferUnpack extends TestSet {
	@Test @Override
	public void testBigDecimal() throws Exception {
	    super.testBigDecimal();
	}

	@Override
	public void testBigDecimal(BigDecimal v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigDecimal> tmpl = BigDecimalTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    BigDecimal ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackBufferUnpack extends TestSet {
	@Test @Override
	public void testBigDecimal() throws Exception {
	    super.testBigDecimal();
	}

	@Override
	public void testBigDecimal(BigDecimal v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigDecimal> tmpl = BigDecimalTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    BigDecimal ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackUnpack extends TestSet {
	@Test @Override
	public void testBigDecimal() throws Exception {
	    super.testBigDecimal();
	}

	@Override
	public void testBigDecimal(BigDecimal v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigDecimal> tmpl = BigDecimalTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    BigDecimal ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }
}
