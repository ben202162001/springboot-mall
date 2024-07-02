package com.test.springbootmall.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestHomeController2 {
    //TestHomeController 的 main12 的客戶端
    //編寫一個簡單的客戶端-服務器應用程序。服務器接收客戶端發來的消息並回覆相同的消息。客戶端連接到服務器並發送一條消息，然後接收服務器的回覆並打印出來。
    public static void main(String[] arg) {//main12_client
        String serverAddress = "localhost"; // 服務器地址
        int portNumber = 12345; // 服務器端口號

        try (
                // 創建與服務器的連接
                Socket socket = new Socket(serverAddress, portNumber);
                // 獲取輸出流，向服務器發送消息
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // 獲取輸出流，接收服务器的響應消息
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 從控制台獲取输入
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;

            // 从控制台讀取輸入
            System.out.print("请输入消息發送给服務器：");
            userInput = stdIn.readLine();

            // 發送消息给服務器
            out.println(userInput);

            // 接收服務器的響應消息并打印
            System.out.println("服務器響應：" + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
