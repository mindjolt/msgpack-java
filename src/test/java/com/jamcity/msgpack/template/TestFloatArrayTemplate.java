package com.jamcity.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.packer.BufferPacker;
import com.jamcity.msgpack.unpacker.BufferUnpacker;
import com.jamcity.msgpack.unpacker.Unpacker;
import org.junit.Test;
import com.jamcity.msgpack.TestSet;
import com.jamcity.msgpack.packer.Packer;


public class TestFloatArrayTemplate {

    @Test
    public void testPackUnpack00() throws Exception {
	new TestPackUnpack().setIndex(0).testFloatArray();
    }

    @Test
    public void testPackUnpack01() throws Exception {
	new TestPackUnpack().setIndex(1).testFloatArray();
    }

    @Test
    public void testPackUnpack02() throws Exception {
	new TestPackUnpack().setIndex(2).testFloatArray();
    }

    @Test
    public void testPackBufferUnpack00() throws Exception {
	new TestPackBufferUnpack().setIndex(0).testFloatArray();
    }

    @Test
    public void testPackBufferUnpack01() throws Exception {
	new TestPackBufferUnpack().setIndex(1).testFloatArray();
    }

    @Test
    public void testPackBufferUnpack02() throws Exception {
	new TestPackBufferUnpack().setIndex(2).testFloatArray();
    }

    @Test
    public void testBufferPackBufferUnpack00() throws Exception {
	new TestBufferPackBufferUnpack().setIndex(0).testFloatArray();
    }

    @Test
    public void testBufferPackBufferUnpack01() throws Exception {
	new TestBufferPackBufferUnpack().setIndex(1).testFloatArray();
    }

    @Test
    public void testBufferPackBufferUnpack02() throws Exception {
	new TestBufferPackBufferUnpack().setIndex(2).testFloatArray();
    }

    @Test
    public void testBufferPackUnpack00() throws Exception {
	new TestBufferPackUnpack().setIndex(0).testFloatArray();
    }

    @Test
    public void testBufferPackUnpack01() throws Exception {
	new TestBufferPackUnpack().setIndex(1).testFloatArray();
    }

    @Test
    public void testBufferPackUnpack02() throws Exception {
	new TestBufferPackUnpack().setIndex(2).testFloatArray();
    }

    public static class TestPackUnpack extends TestSet {
	private int index;

		public TestPackUnpack() {
			index = 0;
		}
		public TestPackUnpack setIndex(int i) {
	    index = i;
	    return this;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[v.length];
		}
		break;
	    case 2:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[(int) v.length / 2];
		}
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertFloatArrayEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestPackBufferUnpack extends TestSet {
	private int index;

		public TestPackBufferUnpack() {
			index = 0;
		}
		public TestPackBufferUnpack setIndex(int i) {
	    index = i;
	    return this;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[v.length];
		}
		break;
	    case 2:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[(int) v.length / 2];
		}
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertFloatArrayEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackBufferUnpack extends TestSet {
	private int index;

		public TestBufferPackBufferUnpack() {
			index = 0;
		}
		public TestBufferPackBufferUnpack setIndex(int i) {
	    index = i;
	    return this;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.resetReadByteCount();
	    unpacker.wrap(bytes);
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[v.length];
		}
		break;
	    case 2:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[(int) v.length / 2];
		}
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertFloatArrayEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static class TestBufferPackUnpack extends TestSet {
	private int index;

		public TestBufferPackUnpack() {
			index = 0;
		}
		public TestBufferPackUnpack setIndex(int i) {
	    index = i;
	    return this;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    unpacker.resetReadByteCount();
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[v.length];
		}
		break;
	    case 2:
		if (v == null) {
		    ret0 = new float[0];
		} else {
		    ret0 = new float[(int) v.length / 2];
		}
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertFloatArrayEquals(v, ret);
	    assertEquals(bytes.length, unpacker.getReadByteCount());
	}
    }

    public static void assertFloatArrayEquals(float[] v, float[] ret) {
	if (v == null) {
	    assertEquals(null, ret);
	    return;
	}
	assertEquals(v.length, ret.length);
	for (int i = 0; i < v.length; ++i) {
	    assertEquals(v[i], ret[i], 10e-10);
	}
    }
}