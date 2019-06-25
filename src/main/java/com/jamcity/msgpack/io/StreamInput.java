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
package com.jamcity.msgpack.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

public class StreamInput extends AbstractInput {
    private final InputStream in;

    protected byte[] castBuffer;    // JamCity-Mods: Changed private to protected
    private ByteBuffer castByteBuffer;
    protected int filled;           // JamCity-Mods: Changed private to protected

    public StreamInput(InputStream in) {
        this.in = in;
        this.castBuffer = new byte[8];
        this.castByteBuffer = ByteBuffer.wrap(castBuffer);
        this.filled = 0;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int remain = len;
        while (remain > 0) {
            int n = in.read(b, off, remain);
            if (n <= 0) {
                throw new EOFException();
            }
            incrReadByteCount(n);
            remain -= n;
            off += n;
        }
        return len;
    }

    public boolean tryRefer(BufferReferer ref, int size) throws IOException {
        return false;
    }

    public byte readByte() throws IOException {
        int n = in.read();
        if (n < 0) {
            throw new EOFException();
        }
        incrReadOneByteCount();
        return (byte) n;
    }

    public void advance() {
        incrReadByteCount(filled);
        filled = 0;
    }

    private void require(int len) throws IOException {
        while (filled < len) {
            int n = in.read(castBuffer, filled, len - filled);
            if (n < 0) {
                throw new EOFException();
            }
            filled += n;
        }
    }

    public byte getByte() throws IOException {
        require(1);
        return castBuffer[0];
    }

    public short getShort() throws IOException {
        require(2);
        return castByteBuffer.getShort(0);
    }

    public int getInt() throws IOException {
        require(4);
        return castByteBuffer.getInt(0);
    }

    public long getLong() throws IOException {
        require(8);
        return castByteBuffer.getLong(0);
    }

    public float getFloat() throws IOException {
        require(4);
        return castByteBuffer.getFloat(0);
    }

    public double getDouble() throws IOException {
        require(8);
        return castByteBuffer.getDouble(0);
    }

    public void close() throws IOException {
        in.close();
    }

    // JamCity-Mods: Implement seekable inputs...
    public boolean canSeek() {
        return in != null && in instanceof FileInputStream;
    }

    public long getPosition() throws IOException {
        if (!canSeek())
            throw new UnsupportedOperationException(String.format("getPosition() not supported for stream: %s", in != null ? in.getClass().getName() : "null"));
        return ((FileInputStream)in).getChannel().position();
    }

    public void setPosition(long position) throws IOException {
        if (!canSeek())
            throw new UnsupportedOperationException(String.format("setPosition() not supported for stream: %s", in != null ? in.getClass().getName() : "null"));
        FileChannel channel = ((FileInputStream)in).getChannel();
        long oldPosition = channel.position();
        long delta = position - oldPosition;
        setReadByteCount((int)(getReadByteCount() + delta));    // NOTE: stream might not have been at start when Input was first instantiated from it
        channel.position(position);
    }
}