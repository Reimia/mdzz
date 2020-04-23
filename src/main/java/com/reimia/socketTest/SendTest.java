package com.reimia.socketTest;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SendTest {

    private SendTest() {
    }

    public static void main(String[] args) throws Exception {

        SendTest sendTest = new SendTest();
        sendTest.sendMsg();

    }

    private void sendMsg() throws Exception {
        Socket socket = new Socket("192.168.69.78", 50000);
        System.out.println("client start ...");
        OutputStream out = socket.getOutputStream();

//        String filePath = "D:\\xxx.txt";
//        String bodyLength = "000083";
//        String useSubPacket = "0";
//        String fileName = "xxx.txt";
//        File file = new File(filePath);
//        String filesize = "000018";
//        byte[] filehead = (bodyLength + useSubPacket + fileName + "             " + filesize + "                                ").getBytes(StandardCharsets.UTF_8);
//        DataOutputStream dos = new DataOutputStream(out);
//        dos.writeUTF(dealName(filePath));
//
//        byte[] fisbyte = Files.readAllBytes(Paths.get(filePath));
//
//        byte[] all = byteMerger(filehead, fisbyte);
//        dos.write(all);
//        System.out.println(Arrays.toString(all));
//        System.out.println(new String(all));
//        dos.close();
//        InputStream in = socket.getInputStream();

//        String s = "CC DD A1 01 FF FF FF FF 9E 3C";
        String s = "CC DD C0 01 00 00 0D CE 9C";
        byte[] x = hexStringToByteArray(s);
        out.write(x);
        System.out.println("Client:" + Arrays.toString(x));
//        byte[] header = new byte[8];
//        in.read(header);
//        String head = new String(header);
//        System.out.println("Server:" + head);
//        in.close();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len));
        }
        System.out.println("get message from server: " + sb);


//        PrintWriter write = new PrintWriter(socket.getOutputStream());
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//        String readline = "04a";
//
//        write.println(readline);
//        write.flush();
//        System.out.println("Client:" + readline);
//        System.out.println("Server:" + in.readLine());
//        write.close();
//        in.close();
        out.close();
        socket.close();

    }


    public static byte[] hexStringToByteArray(String hexString) {
        hexString = hexString.replaceAll(" ", "");
        int len = hexString.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
                    .digit(hexString.charAt(i + 1), 16));
        }
        return bytes;
    }

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    private String dealName(String filename) {
        return filename.split("\\\\")[filename.split("\\\\").length - 1];
    }

    private static byte[] byteMerger(byte[] bt1, byte[] bt2) {
        byte[] bt3 = new byte[bt1.length + bt2.length];
        System.arraycopy(bt1, 0, bt3, 0, bt1.length);
        System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
        return bt3;
    }

    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

}
