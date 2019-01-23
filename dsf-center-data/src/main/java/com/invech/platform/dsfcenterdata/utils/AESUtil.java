package com.invech.platform.dsfcenterdata.utils;


import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Date;

@Slf4j
public class AESUtil {

    private final static int OUT_TIME = 1;

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码 ,时间
     * @return
     */
    public static byte[] encrypt(String content, String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        byte[] byteContent = content.getBytes("utf-8");
        byte [] result = cipher.doFinal(byteContent);
        return result;
    }




    /**
     * 当前时间戳为密码进行编码AES
     * @param content
     * @return
     * @throws Exception
     */
    public static String encrypt(String content) throws Exception {
        String time =String.valueOf(new Date().getTime());
        byte[] code =encrypt(content+time,time);
        return parseByte2HexStr(code)+time;
    }

    public static  String decrypt(String content) {
        try {
            if(StringUtils.isEmpty(content)){
                return "test";
                /*log.error("SToken == null");
                throw new RRException("schemaName error");*/
            }
            String pwd =content.substring(content.length()-13,content.length());
            byte[] codes =parseHexStr2Byte(content.substring(0,content.length()-13));
            //获取密码器
            byte[] schemaByte = AESUtil.decrypt(codes,pwd);
            String schema = new String(schemaByte);
            /*if(new Date().getTime() - Long.valueOf(pwd) > OUT_TIME*3600000){
                return "201";
            }*/
            return  schema.substring(0,schema.length()-13) ;
        }catch (Exception e){

            throw new RuntimeException("schemaName error");
        }
    }



    public static void main(String[] args) throws Exception{
       // String content =AESUtil.encrypt("test");
        //System.out.println(content);
        System.out.println(AESUtil.decrypt("B96390CDE4496DF913118AF5A5E4BD328DB33185CF7A6F7237FF2A865A57A03B1521785338526"));
    }
    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(content);
        return result; // 解密
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
