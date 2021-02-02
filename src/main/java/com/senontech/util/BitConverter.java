package com.senontech.util;

import java.util.List;

/**
 *
 * 位处理，字节处理
 */

public class BitConverter {
    public static byte[] GetBytes(int value) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((value)&0xFF); //最低位
        bytes[1] = (byte) ((value >> 8)&0xFF);
        bytes[2] = (byte) ((value >> 16)&0xFF);
        bytes[3] = (byte) ((value >>> 24)); //最高位，无符号右移
        return bytes;
    }
    public static byte[] GetBytes(long values) {
        byte[] buffer = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = 64 - (i + 1) * 8;
            buffer[i] = (byte)((values >> offset) & 0xff);
        }
        return buffer;
    }



    /**
     * 将short转成byte[2]
     * @param a
     * @return
     */
    public static byte[] GetBytes(short a){
        byte[] b = new byte[2];

        b[0] = (byte) (a >> 8);
        b[1] = (byte) (a);

        return b;
    }

    public static byte[] GetBytes(float value) {
        return GetBytes(Float.floatToIntBits(value));
    }

    public static byte[] combinationByte(List<byte[]> bytes){
        int length = 0;
        Integer i = 0 ;
        for(byte[] b : bytes){
            length += b.length;
            i+=1;
        }
        byte[] byteList = new byte[length];
        int l = 0;
        for(byte[] b : bytes ){
            System.arraycopy(b,0,byteList,l,b.length);
            l += b.length;
        }
        return byteList;
    }

    public static byte[] GetBytes(boolean value) {
        return new byte[]{(byte)(value? 1:0)};
    }

    public static short ToInt16(byte[] bytes, int offset) {
        short result = (short) ((int)bytes[offset]&0xff);
        result |= ((int)bytes[offset+1]&0xff) << 8;
        return (short) (result & 0xffff);
    }

    public static int ToInt32(byte[] bytes, int offset) {
        int result = (int)bytes[offset]&0xff;
        result |= ((int)bytes[offset+1]&0xff) << 8;
        result |= ((int)bytes[offset+2]&0xff) << 16;
        result |= ((int)bytes[offset+3]&0xff) << 24;
        return result;
    }

    public static long ToInt64(byte[] buffer,int offset) {
        long values = 0;
        for (int i = 0; i < 8; i++) {
            values <<= 8; values |= (buffer[offset+i] & 0xFF);
        }
        return values;
    }
    public static long ToUInt64(byte[] bytes, int offset) {
        long result = 0;
        for (int i = 0; i <= 56; i += 8) {
            result |= ((int)bytes[offset++]&0xff) << i;
        }
        return result;
    }
    public static float ToFloat(byte[] bs, int index) {
        return Float.intBitsToFloat(ToInt32(bs, index));
    }
    public static double ToDouble(byte[] arr,int offset) {
        return Double.longBitsToDouble(ToUInt64(arr, offset));
    }
    public static boolean ToBoolean(byte[] bytes,int offset) {
        return (bytes[offset]==0x00)? false:true;
    }

}
