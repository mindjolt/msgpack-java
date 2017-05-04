package com.jamcity.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.Date;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.jamcity.msgpack.MessagePack;
import com.jamcity.msgpack.packer.BufferPacker;
import com.jamcity.msgpack.unpacker.Unpacker;

import org.junit.Test;


public class TestTemplates {
    public static enum MyEnum {
        A, B, C;
    }

    @SuppressWarnings("unused")
    @Test
    public void testGenericsTypesCompliable() throws IOException {
        Template<Byte> tbyte = Templates.TByte;
        Template<Short> tshort = Templates.TShort;
        Template<Integer> tinteger = Templates.TInteger;
        Template<Long> tlong = Templates.TLong;
        Template<Character> tcharacter = Templates.TCharacter;
        Template<BigInteger> tbiginteger = Templates.TBigInteger;
        Template<BigDecimal> tbigdecimail = Templates.TBigDecimal;
        Template<Float> tfloat = Templates.TFloat;
        Template<Double> tdouble = Templates.TDouble;
        Template<Boolean> tboolean = Templates.TBoolean;
        Template<String> tstring = Templates.TString;
        Template<byte[]> tbytearray = Templates.TByteArray;
        Template<ByteBuffer> tbytebuffer = Templates.TByteBuffer;
        Template<Date> tdate = Templates.TDate;

        Template<List<String>> tlist = Templates.tList(Templates.TString);
        Template<Map<String,Integer>> tmap = Templates.tMap(Templates.TString, Templates.TInteger);
        Template<Collection<Long>> tcollection = Templates.tCollection(Templates.TLong);
        Template<MyEnum> tordinalenum = Templates.tOrdinalEnum(MyEnum.class);
    }

    @Test
    public void testList() throws IOException {
        MessagePack msgpack = new MessagePack();

        BufferPacker pk = msgpack.createBufferPacker();

        Template<List<String>> t = Templates.tList(Templates.TString);
        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        t.write(pk, list1);

        byte[] raw = pk.toByteArray();
        Unpacker u = msgpack.createBufferUnpacker(raw);
        List<String> list2 = t.read(u, new ArrayList<String>());

        assertEquals(list1, list2);
    }
}

