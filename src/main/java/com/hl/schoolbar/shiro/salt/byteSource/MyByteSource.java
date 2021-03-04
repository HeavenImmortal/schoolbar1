package com.hl.schoolbar.shiro.salt.byteSource;

import org.apache.shiro.util.SimpleByteSource;

import java.io.Serializable;

/**
 * author: huangLong
 * date:2020/12/9 10:16
 * describe:用来实现盐值的序列化
 */

public class MyByteSource extends SimpleByteSource implements Serializable {

    public MyByteSource(String string) {
        super(string);
    }
}
