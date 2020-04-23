package com.reimia.socketTest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AllotmentShowSocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.69.78", 50000);
            //得到一个输出流，用于向服务器发送数据
            OutputStream outputStream = socket.getOutputStream();
            String s = "CC DD C0 01 00 00 0D CE 9C";
            while (true) {
                System.out.println("请输入16进制数据:");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                if ("exit".equals(data)) {
                    return;
                }
                byte[] byteArray = hexStringToByteArray(data);
                outputStream.write(byteArray);
                //刷新缓冲
                outputStream.flush();
                //得到一个输入流，用于接收服务器响应的数据
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1]; // 一次读取一个byte
                String info = "";
                while (true) {
                    if (inputStream.available() > 0) {
                        inputStream.read(bytes);
                        String hexStr = bytesToHexString(bytes);
                        info = info + hexStr;

                        //已经读完
                        if (inputStream.available() == 0) {
                            System.out.println("收到来自服务端的信息:" + info);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}