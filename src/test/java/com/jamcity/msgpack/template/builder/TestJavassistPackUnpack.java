package com.jamcity.msgpack.template.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.template.TemplateRegistry;
import com.jamcity.msgpack.unpacker.Unpacker;
import org.junit.Test;
import com.jamcity.msgpack.packer.Packer;
import com.jamcity.msgpack.template.Template;
import com.jamcity.msgpack.testclasses.AbstractClass;
import com.jamcity.msgpack.testclasses.FinalClass;
import com.jamcity.msgpack.testclasses.InheritanceClass;
import com.jamcity.msgpack.testclasses.InheritanceClassNotNullable;
import com.jamcity.msgpack.testclasses.Interface;
import com.jamcity.msgpack.testclasses.ListTypeFieldsClass;
import com.jamcity.msgpack.testclasses.ListTypeFieldsClassNotNullable;
import com.jamcity.msgpack.testclasses.MapTypeFieldsClass;
import com.jamcity.msgpack.testclasses.MapTypeFieldsClassNotNullable;
import com.jamcity.msgpack.testclasses.MessagePackableTypeFieldsClass;
import com.jamcity.msgpack.testclasses.MessagePackableTypeFieldsClassNotNullable;
import com.jamcity.msgpack.testclasses.ModifiersFieldsClass;
import com.jamcity.msgpack.testclasses.ModifiersFieldsClassNotNullable;
import com.jamcity.msgpack.testclasses.PrimitiveTypeFieldsClass;
import com.jamcity.msgpack.testclasses.PrimitiveTypeFieldsClassNotNullable;
import com.jamcity.msgpack.testclasses.ReferenceCycleTypeFieldsClass;
import com.jamcity.msgpack.testclasses.ReferenceCycleTypeFieldsClassNotNullable;
import com.jamcity.msgpack.testclasses.ReferenceTypeFieldsClass;
import com.jamcity.msgpack.testclasses.ReferenceTypeFieldsClassNotNullable;
import com.jamcity.msgpack.testclasses.UserDefinedTypeFieldsClass;
import com.jamcity.msgpack.testclasses.UserDefinedTypeFieldsClassNotNullable;


public class TestJavassistPackUnpack extends TestSet {

    @Test @Override
    public void testPrimitiveTypeFieldsClass() throws Exception {
	super.testPrimitiveTypeFieldsClass();
    }

    @Override
    public void testPrimitiveTypeFieldsClass(PrimitiveTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<PrimitiveTypeFieldsClass> tmpl = builder.buildTemplate(PrimitiveTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	PrimitiveTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testPrimitiveTypeFieldsClassNotNullable() throws Exception {
	super.testPrimitiveTypeFieldsClassNotNullable();
    }

    @Override
    public void testPrimitiveTypeFieldsClassNotNullable(PrimitiveTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<PrimitiveTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(PrimitiveTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	PrimitiveTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testReferenceTypeFieldsClass() throws Exception {
	super.testReferenceTypeFieldsClass();
    }

    @Override
    public void testReferenceTypeFieldsClass(ReferenceTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ReferenceTypeFieldsClass> tmpl = builder.buildTemplate(ReferenceTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ReferenceTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testReferenceTypeFieldsClassNotNullable() throws Exception {
	super.testReferenceTypeFieldsClassNotNullable();
    }

    @Override
    public void testReferenceTypeFieldsClassNotNullable(ReferenceTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ReferenceTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(ReferenceTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ReferenceTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testListTypeFieldsClass() throws Exception {
	super.testListTypeFieldsClass();
    }

    @Override
    public void testListTypeFieldsClass(ListTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ListTypeFieldsClass> tmpl = builder.buildTemplate(ListTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ListTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testListTypeFieldsClassNotNullable() throws Exception {
	super.testListTypeFieldsClassNotNullable();
    }

    @Override
    public void testListTypeFieldsClassNotNullable(ListTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ListTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(ListTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ListTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testMapTypeFieldsClass() throws Exception {
	super.testMapTypeFieldsClass();
    }

    @Override
    public void testMapTypeFieldsClass(MapTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<MapTypeFieldsClass> tmpl = builder.buildTemplate(MapTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	MapTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testMapTypeFieldsClassNotNullable() throws Exception {
	super.testMapTypeFieldsClassNotNullable();
    }

    @Override
    public void testMapTypeFieldsClassNotNullable(MapTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<MapTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(MapTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	MapTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testFinalClass() throws Exception {
	super.testFinalClass();
    }

    @Override
    public void testFinalClass(FinalClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<FinalClass> tmpl = builder.buildTemplate(FinalClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	FinalClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testAbstractClass() throws Exception {
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	try {
	    builder.buildTemplate(AbstractClass.class);
	    fail();
	} catch (Throwable t) {
	    assertTrue(t instanceof TemplateBuildException);
	}
    }

    @Test @Override
    public void testInterface() throws Exception {
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	try {
	    builder.buildTemplate(Interface.class);
	    fail();
	} catch (Throwable t) {
	    assertTrue(t instanceof TemplateBuildException);
	}
    }

    @Test @Override
    public void testModifiersFieldsClass() throws Exception {
	super.testModifiersFieldsClass();
    }

    @Override
    public void testModifiersFieldsClass(ModifiersFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ModifiersFieldsClass> tmpl = builder.buildTemplate(ModifiersFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ModifiersFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testModifiersFieldsClassNotNullable() throws Exception {
	super.testModifiersFieldsClassNotNullable();
    }

    @Override
    public void testModifiersFieldsClassNotNullable(ModifiersFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ModifiersFieldsClassNotNullable> tmpl = builder.buildTemplate(ModifiersFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ModifiersFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testUserDefinedTypeFieldsClass() throws Exception {
	super.testUserDefinedTypeFieldsClass();
    }

    @Override
    public void testUserDefinedTypeFieldsClass(UserDefinedTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<UserDefinedTypeFieldsClass> tmpl = builder.buildTemplate(UserDefinedTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	UserDefinedTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testUserDefinedTypeFieldsClassNotNullable() throws Exception {
	super.testUserDefinedTypeFieldsClassNotNullable();
    }

    @Override
    public void testUserDefinedTypeFieldsClassNotNullable(UserDefinedTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<UserDefinedTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(UserDefinedTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	UserDefinedTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testReferenceCycleTypeFieldsClass() throws Exception {
	super.testReferenceCycleTypeFieldsClass();
    }

    @Override
    public void testReferenceCycleTypeFieldsClass(ReferenceCycleTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ReferenceCycleTypeFieldsClass> tmpl = builder.buildTemplate(ReferenceCycleTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ReferenceCycleTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testReferenceCycleTypeFieldsClassNotNullable() throws Exception {
	super.testReferenceCycleTypeFieldsClassNotNullable();
    }

    @Override
    public void testReferenceCycleTypeFieldsClassNotNullable(ReferenceCycleTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<ReferenceCycleTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(ReferenceCycleTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	ReferenceCycleTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testInheritanceClass() throws Exception {
	super.testInheritanceClass();
    }

    @Override
    public void testInheritanceClass(InheritanceClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<InheritanceClass> tmpl = builder.buildTemplate(InheritanceClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	InheritanceClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testInheritanceClassNotNullable() throws Exception {
	super.testInheritanceClassNotNullable();
    }

    @Override
    public void testInheritanceClassNotNullable(InheritanceClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<InheritanceClassNotNullable> tmpl = builder.buildTemplate(InheritanceClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	InheritanceClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testMessagePackableTypeFieldsClass() throws Exception {
	super.testMessagePackableTypeFieldsClass();
    }

    @Override
    public void testMessagePackableTypeFieldsClass(MessagePackableTypeFieldsClass v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<MessagePackableTypeFieldsClass> tmpl = builder.buildTemplate(MessagePackableTypeFieldsClass.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	MessagePackableTypeFieldsClass ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

    @Test @Override
    public void testMessagePackableTypeFieldsClassNotNullable() throws Exception {
	super.testMessagePackableTypeFieldsClassNotNullable();
    }

    @Override
    public void testMessagePackableTypeFieldsClassNotNullable(MessagePackableTypeFieldsClassNotNullable v) throws Exception {
	MessagePack msgpack = new MessagePack();
	TemplateRegistry registry = new TemplateRegistry(null);
	JavassistTemplateBuilder builder = new JavassistTemplateBuilder(registry);
	Template<MessagePackableTypeFieldsClassNotNullable> tmpl = builder.buildTemplate(MessagePackableTypeFieldsClassNotNullable.class);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	tmpl.write(packer, v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	unpacker.resetReadByteCount();
	MessagePackableTypeFieldsClassNotNullable ret = tmpl.read(unpacker, null);
	assertEquals(v, ret);
	assertEquals(bytes.length, unpacker.getReadByteCount());
    }

}
