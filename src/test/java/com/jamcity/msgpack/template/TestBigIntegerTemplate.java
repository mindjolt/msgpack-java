package com.jamcity.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.packer.BufferPacker;
import org.junit.Test;
import com.jamcity.msgpack.TestSet;
import com.jamcity.msgpack.packer.Packer;
import com.jamcity.msgpack.unpacker.BufferUnpacker;
import com.jamcity.msgpack.unpacker.Unpacker;


public class TestBigIntegerTemplate {

    @Test
    public void testPackUnpack() throws Exception {
	new TestPackUnpack().testBigInteger();
    }

    @Test
    public void testPackBufferUnpack() throws Exception {
	new TestPackBufferUnpack().testBigInteger();
    }

    @Test
    public void testBufferPackBufferUnpack() throws Exception {
	new TestBufferPackBufferUnpack().testBigInteger();
    }

    @Test
    public void testBufferPackUnpack() throws Exception {
	new TestBufferPackUnpack().testBigInteger();
    }

    public static class TestPackUnpack extends TestSet {
	@Test @Override
	public void testBigInteger() throws Exception {
	    super.testBigInteger();
	}

	@Override
	public void testBigInteger(BigInteger v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigInteger> tmpl = BigIntegerTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    BigInteger ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestPackBufferUnpack extends TestSet {
	@Test @Override
	public void testBigInteger() throws Exception {
	    super.testBigInteger();
	}

	@Override
	public void testBigInteger(BigInteger v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigInteger> tmpl = BigIntegerTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    BigInteger ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackBufferUnpack extends TestSet {
	@Test @Override
	public void testBigInteger() throws Exception {
	    super.testBigInteger();
	}

	@Override
	public void testBigInteger(BigInteger v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigInteger> tmpl = BigIntegerTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    BigInteger ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackUnpack extends TestSet {
	@Test @Override
	public void testBigInteger() throws Exception {
	    super.testBigInteger();
	}

	@Override
	public void testBigInteger(BigInteger v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<BigInteger> tmpl = BigIntegerTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    BigInteger ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }
}
