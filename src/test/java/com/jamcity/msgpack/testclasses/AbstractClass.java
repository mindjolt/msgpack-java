package com.jamcity.msgpack.testclasses;

import org.junit.Ignore;
import com.jamcity.msgpack.annotation.Beans;
import com.jamcity.msgpack.annotation.Message;


@Ignore @Message @Beans
public abstract class AbstractClass {

    @Override
    public boolean equals(Object o) {
	return o instanceof AbstractClass;
    }
}
