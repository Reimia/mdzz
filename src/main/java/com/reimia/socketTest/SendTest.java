package com.reimia.socketTest;

import java.io.OutputStream;
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
        Socket socket = new Socket("127.0.0.1", 20003);
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
        byte[] x ="30/aaaaaaaaaaaaaaaaaaaaaaaaaaaaa".getBytes(StandardCharsets.UTF_8);
        out.write(x);
        System.out.println("Client:" + Arrays.toString(x));
//        byte[] header = new byte[8];
//        in.read(header);
//        String head = new String(header);
//        System.out.println("Server:" + head);
//        in.close();
        out.close();
        socket.close();

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
