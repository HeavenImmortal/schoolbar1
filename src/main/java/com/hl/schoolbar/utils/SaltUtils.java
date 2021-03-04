package com.hl.schoolbar.utils;

import java.util.Random;

/**
 * author: huangLong
 * date:2020/12/7 10:22
 * describe:
 */

public class SaltUtils {

    /**
     * 生成盐值
     * @param n
     * @return
     */
    public static String getSalt(int n){
        char[] chars = "adasdafgasdaskodasdlasdlaskdpoaskdopaskdopaslpdlqwokoqpwkdqwpleqwpldppdlpLDPLpldPlD".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i =0 ;i<n;i++){
            char chara = chars[new Random().nextInt(chars.length-1)];
            sb.append(chara);
        }
        return sb.toString();
    }
}
