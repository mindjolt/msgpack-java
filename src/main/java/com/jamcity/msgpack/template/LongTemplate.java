//
// MessagePack for Java
//
// Copyright (C) 2009 - 2013 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package com.jamcity.msgpack.template;

import java.io.IOException;

import com.jamcity.msgpack.unpacker.Unpacker;
import com.jamcity.msgpack.packer.Packer;
import com.jamcity.msgpack.MessageTypeException;

public class LongTemplate extends AbstractTemplate<Long> {
    private LongTemplate() {
    }

    public void write(Packer pk, Long target, boolean required)
            throws IOException {
        if (target == null) {
            if (required) {
                throw new MessageTypeException("Attempted to write null");
            }
            pk.writeNil();
            return;
        }
        pk.write((long) target);
    }

    public Long read(Unpacker u, Long to, boolean required) throws IOException {
        if (!required && u.trySkipNil()) {
            return null;
        }
        return u.readLong();
    }

    static public LongTemplate getInstance() {
        return instance;
    }

    static final LongTemplate instance = new LongTemplate();
}