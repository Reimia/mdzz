package com.reimia.md5;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        String s = encryptData("tbrain");
        System.out.println(s);
    }


    private static String key = "0102030405060708";

    public static String encryptData(String data) {
        int len = data.getBytes().length;
        byte[] tmp = new byte[(len / 8 + 1) * 8];
        System.arraycopy(data.getBytes(), 0, tmp, 0, len);
        try {
            byte[] result = doEncrypt(tmp, ascToBin(key));
            return String.format("%02d", len) + binToAsc(result);
        } catch (Exception e) {
            //add by jwg 异常日志前增加时间戳信息，方便问题定位
            System.out.println(String.format("%s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()))));

            e.printStackTrace();
            return null;
        }
    }

    private static byte[] doEncrypt(byte[] plainText, byte[] desKey) throws Exception {
        //byte[] encryptionIV = "00000000".getBytes();

		/*byte[] iv = new byte[]{
		        (byte)0x8E, 0x12, 0x39, (byte)0x9C,
		        0x07, 0x72, 0x6F, 0x5A
		    };
		    AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
		*/
        // DES算法要求有一个可信任的随机数源
        //SecureRandom sr = new SecureRandom();
        /* 用某种方法获得密匙数据 */
        byte rawKeyData[] = desKey;
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding"); //  DES/CBC/NoPadding");	;;;PKCS5Padding

        // Create IvParameterSpec object with initialization vector
        //IvParameterSpec spec = new IvParameterSpec(encryptionIV);
        //        IvParameterSpec spec = new IvParameterSpec();

        // 用密匙初始化Cipher对象
        //        cipher.init(Cipher.ENCRYPT_MODE, key, spec);  //, sr);
        cipher.init(Cipher.ENCRYPT_MODE, key); //, sr);
        // 现在，获取数据并加密
        //byte[] data = plainText;
        // 正式执行加密操作
        byte[] encryptedData = cipher.doFinal(plainText);

        return encryptedData;
    }

    public static byte[] ascToBin(String val){
        byte interByte[] = val.toUpperCase().getBytes();
        byte[] result = new byte[interByte.length/2];
        for (int i = 0; i < result.length; i++) {
            byte hi = interByte[i * 2];
            byte lo = interByte[i * 2 + 1];
            int h = hi > 0x40 ? 10 + hi - 0x41 : hi - 0x30;
            int l = lo > 0x40 ? 10 + lo - 0x41 : lo - 0x30;
            result[i] = (byte) (h << 4 | l);
        }
        return result;
    }

    public static String binToAsc(byte[] val){
        StringBuffer str = new StringBuffer(val.length * 2);
        for (int i = 0; i < val.length; i++) {
            char hi = Character.forDigit((val[i] >> 4) & 0x0F, 16);
            char lo = Character.forDigit(val[i] & 0x0F, 16);
            str.append(Character.toUpperCase(hi));
            str.append(Character.toUpperCase(lo));
        }
        return str.toString();
    }
}
