package com.jamcity.msgpack.template.builder;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.template.TemplateRegistry;
import com.jamcity.msgpack.testclasses.EnumTypeFieldsClass;
import com.jamcity.msgpack.testclasses.EnumTypeFieldsClassNotNullable;
import com.jamcity.msgpack.unpacker.BufferUnpacker;
import org.junit.Test;
import com.jamcity.msgpack.packer.Packer;
import com.jamcity.msgpack.template.Template;


public class TestOrdinalEnumPackBufferUnpack extends TestSet {

    @Test @Override
    public void testEnumTypeFieldsClass() throws Exception {
	super.testEnumTypeFieldsClass();
    }

    @Override
    public void testEnumTypeFieldsClass(EnumTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	registry.register(EnumTypeFieldsClass.SampleEnum.class,
		new OrdinalEnumTemplateBuilder(registry).buildTemplate(EnumTypeFieldsClass.SampleEnum.class));
	ReflectionTemplateBuilder builder = new ReflectionTemplateBuilder(registry);
	Template<EnumTypeFieldsClass> tmpl = builder.buildTemplate(EnumTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = msgpack.createBufferUnpacker();
	unpacker.resetReadByteCount();
	unpacker.wrap(bytes);
	EnumTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testEnumTypeFieldsClassNotNullable() throws Exception {
	super.testEnumTypeFieldsClassNotNullable();
    }

    @Override
    public void testEnumTypeFieldsClassNotNullable(EnumTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	registry.register(EnumTypeFieldsClassNotNullable.SampleEnum.class,
		new OrdinalEnumTemplateBuilder(registry).buildTemplate(EnumTypeFieldsClassNotNullable.SampleEnum.class));
	ReflectionTemplateBuilder builder = new ReflectionTemplateBuilder(registry);
	Template<EnumTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(EnumTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = msgpack.createBufferUnpacker();
	unpacker.resetReadByteCount();
	unpacker.wrap(bytes);
	EnumTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }
}
