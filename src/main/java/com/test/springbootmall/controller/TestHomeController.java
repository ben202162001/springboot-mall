package com.test.springbootmall.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.model.User;
import com.test.springbootmall.util.ErrorMassage;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.awt.print.Book;
import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@CrossOrigin
public class TestHomeController {

    @GetMapping("/")
    public String Home() {
        String list = "http://localhost:8080/AllProducts" + "<br>" +
                "http://localhost:8080/Products" + "<br>" +
                "http://localhost:8080/login?phone_Number=0912345678&password=password" + "<br>" +
                "http://localhost:8080/getUserData?phone_Number=0912345678&password=password";
        return list;
    }

//main1
//    【題目1】用Spring Boot 撰寫簡單的 RESTful API 服務，該服務能夠管理一個書籍資料庫。
//
//            ● 題目描述：
//
//    書籍資料庫：
//    {"ID":"00A3","書名":"黑心建商的告白","出版日期":"2022-10-31"}。
//    {"ID":"FBA9","書名":"Java 編程入門","出版日期":"2022-10-31"}。
//    {"ID":"9786132156437","書名":"Head First Java, 3/e","出版日期":"2022-10-31T09:00:00Z"}。
//
//            1.每本書籍都應該有以下屬性：ID、書名、出版日期。
//            2.API呼叫時以JSON格式回應。
//            3.API需實作下列介面：
//            -"GET"  /books： 回傳所有書籍的資料,並以ID做排序(由小至大)。
//            -"POST" /books：新增一本書籍。書籍的詳細信息應該在Request body中提供。
//
//            ＊ API GET-查詢所有書籍(輸入/輸出)結果範例：
//            1.Client端，呼叫Get請求 。
//    輸出：
//    {"ID":"00A3","書名":"黑心建商的告白","出版日期":"2022-10-31"}。
//    {"ID":"9786132156437","書名":"Head First Java, 3/e","出版日期":"2022-10-31T09:00:00Z"}。
//    {"ID":"FBA9","書名":"Java 編程入門","出版日期":"2022-10-31"}。
//
//            ＊API POST 新增一本書籍(輸入/輸出)結果範例：
//            1.Client端，執行POST 請求 。輸出: {"處理結果":"新增成功"}。
//    Request body參考
//    {"ID":"888","書名":"TEST","出版日期":"2024-04-23"}。


    @GetMapping("/books")
    public List<book> books() throws ParseException {
        List<book> list_book = new ArrayList<>();


        book book1 = new book();
        book1.setBook_id("00A3");
        book1.setBook_name("黑心建商的告白");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date1 = sdf1.parse("2022-10-31");
        book1.setBook_date(date1);
        list_book.add(book1);

        book book2 = new book();
        book2.setBook_id("FBA9");
        book2.setBook_name("Java 編程入門");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date2 = sdf1.parse("2022-10-31");
        book2.setBook_date(date2);
        list_book.add(book2);

        book book3 = new book();
        book3.setBook_id("9786132156437");
        book3.setBook_name("Head First Java, 3/e\"");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf3.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date3 = sdf3.parse("2022-10-31T09:00:00Z");
        book3.setBook_date(date3);
        list_book.add(book3);

        Collections.sort(list_book, new Comparator<book>() {
            @Override
            public int compare(book b1, book b2) {
                return b1.getBook_id().compareTo(b2.getBook_id());
            }
        });


        return list_book;
    }

    @PostMapping("/books")
    public ErrorMassage books(@RequestBody book book) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        ErrorMassage ErrorMassage = new ErrorMassage();
        ErrorMassage.setMassage("新增成功");
        return ErrorMassage;
    }

    static class book {
        String book_id;
        String book_name;
        Date book_date;

        public String getBook_id() {
            return book_id;
        }

        public void setBook_id(String book_id) {
            this.book_id = book_id;
        }

        public String getBook_name() {
            return book_name;
        }

        public void setBook_name(String book_name) {
            this.book_name = book_name;
        }

        public Date getBook_date() {
            return book_date;
        }

        public void setBook_date(Date book_date) {
            this.book_date = book_date;
        }
    }

    //main2
    //    【題目2】字串處理
//
//● 題目敘述：寫一個可輸入的main方法，將輸入IP資訊反轉順序後輸出呈現。
//
//            ● 輸入/輸出結果範例：
//    輸入:"127.0.0.1" --> 輸出:"1.0.0.127"
    public static void main2(String arg[]) {
        String xx = "127.0.0.1";
        String[] show = xx.split("\\.");
        for (int i = show.length - 1; 0 <= i; i--) {
            System.out.print(show[i]);
            if (i != 0) {
                System.out.print(".");
            }

        }

    }

    //main3
    //最小公倍數
    public static void main3(String arg[]) {
        int z = 2;
        int x = 3;

        for (int i = z; i <= z * x; i++) {
            System.out.println(i);
            if (i % z == 0 && i % x == 0) {
                System.out.println(i + "!!");
            }
        }

    }
    //main4
    //最大公因數
    public static void main4(String arg[]) {
        int x = 100;
        int y = 200;
        int z = 300;
        int max = 0;

        for (int i = 1; i <= z; i++) {
            if (x % i == 0 && y % i == 0 && z % i == 0) {
                max = i;
            }
        }
        System.out.println(max);

    }

    //main5
    //    不死母蜂一年生一隻公蜂，每隻公蜂一年生一隻普通的母蜂和一個公蜂後就死掉，
//    普通的母蜂一年生一隻公蜂後死掉。現在在一個只有一隻不死母蜂的實驗環境下，
//    Input N年，Output 公蜂有幾隻、總共有幾隻蜜蜂
    public static void main5(String arg[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入幾年:");
        int year = input.nextInt();
        int man = 0;
        int women = 0;
        int man_pre = 0;
        int women_pre = 0;
        for (int i = 1; i <= year; i++) {
            man = man_pre + women_pre;
            man = man + 1;
            women = man_pre;

            man_pre = man;
            women_pre = women;
        }
        System.out.println("男峰:" + man);
        System.out.println("女峰:" + women);
    }
    //main6
    //輸入一串可重複的整數數列，求出重複最多次的整數以及重複次數。
    public static void main6(String arg[]) {
        System.out.print("請輸入一串整數數列（用.分隔）：");
        Scanner input = new Scanner(System.in);
        String nums = input.nextLine();
        String[] num_list = nums.split("\\.");
        Map<Integer, Integer> countMap = new HashMap<>();
        // 記錄每個數字出現的次數
        for (int i = 0; i < num_list.length; i++) {
            int num = Integer.parseInt(num_list[i]);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int mostFrequentNumber = 0;
        int maxCount = 0;

        // 找出出現次數最多的數字
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentNumber = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("mostFrequentNumber:" + mostFrequentNumber);
        System.out.println("maxCount:" + maxCount);
    }

    //main7

    //    羅馬數字由七種不同的符號表示：I, V, X, L, C, D 和 M。
//
//    符號 數值
//    I 1
//    V 5
//    X 10
//    L 50
//    C 100
//    D 500
//    M 1000
//    輸入字串算出數字，例如III = 3、LVIII = 58
    public static void main7(String[] args) {
        int cnt = 0;
        int now_num = 0;
        int pre_num = 0;
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case ('I'):
                    now_num = 1;
                    break;
                case ('V'):
                    now_num = 5;
                    break;
                case ('X'):
                    now_num = 10;
                    break;
                case ('L'):
                    now_num = 50;
                    break;
                case ('C'):
                    now_num = 100;
                    break;
                case ('D'):
                    now_num = 500;
                    break;
                case ('M'):
                    now_num = 1000;
                    break;
            }

            if (now_num < pre_num) {
                cnt = cnt - now_num;
            } else {
                cnt = cnt + now_num;

            }
            pre_num = now_num;
        }
        System.out.println(cnt);
    }

    //main9
    //編寫一個程序，從一個名為input.txt的文件中讀取內容，並將其逐行打印到控制台。同時，將每一行的內容反轉後寫入到一個名為output.txt的文件中。
    public static void main9(String[] arg) throws FileNotFoundException {
        //String inputFileName = "D:\\input.txt";
        //String outputFileName = "D:\\output.txt";
        String inputFileName = "src/main/resources/input_infile.txt";
        String outputFileName = "src/main/resources/output_infile.txt";
        List<String> data = new ArrayList<String>();

        //從一個名為input.txt的文件中讀取內容
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            line = br.readLine();
            while ((line != null)) {
                data.add(line);
                line = br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //並將其逐行打印到控制台
        System.out.println("資料");
        for (String datas : data) {
            System.out.println(datas);
        }
        System.out.println("");
        System.out.println("從後面印到前面");
        for (int i = data.size() - 1; 0 <= i; i--) {
            System.out.println(data.get(i));
        }
        System.out.println("");
        System.out.println("單行反轉");
        for (int i = 0; i < data.size(); i++) {
            String reversedLine = new StringBuilder(data.get(i)).reverse().toString();
            System.out.println(reversedLine);
        }
        System.out.println("");
        System.out.println("從後面印到前面+單行反轉");
        for (int i = data.size() - 1; 0 <= i; i--) {
            String reversedLine = new StringBuilder(data.get(i)).reverse().toString();
            System.out.println(reversedLine);

        }
        //將每一行的內容反轉後寫入到一個名為output.txt的文件中
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName, true))) {
            for (int i = 0; i < data.size(); i++) {
                String reversedLine = new StringBuilder(data.get(i)).reverse().toString();
                bw.write(reversedLine);
                bw.newLine(); // 換行
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //main10
    //編寫一個程序，讀取一個JSON文件data.json，並解析其內容。假設JSON文件包含一個學生信息的列表，將每個學生的信息打印到控制台。使用Gson庫來解析JSON。
    public static void main10(String[] arg) {
        String inputFileName = "src/main/resources/input_user_json.txt";
        Gson gson = new Gson();
        try (Reader reader = new FileReader(inputFileName)) {
            Type UserListType = new TypeToken<List<User>>() {
            }.getType();
            List<User> Users = gson.fromJson(reader, UserListType);
            System.out.println("資料：");
            for (User student : Users) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //main11
    //編寫一個程序，創建兩個線程。第一個線程每秒打印一次"Hello"，第二個線程每秒打印一次"World"。讓這兩個線程同時運行，並且每個線程運行5次後結束。
    public static void main11(String[] arg) {
        // 創建并啟動第一線程，每秒打印一次 "Hello"
        Thread helloThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(2000); // 線程休眠2秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 創建啟動第二个線程，每秒打印一次 "World"
        Thread worldThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("World!");
                try {
                    Thread.sleep(1000); // 線程休眠1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 啟動兩個線程
        helloThread.start();
        worldThread.start();

        // 等待兩個線程執行完畢
        try {
            helloThread.join();
            worldThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 所有線程執行完畢後输出结束語句
        System.out.println("All threads have finished.");
    }

    //main12
    //編寫一個簡單的客戶端-服務器應用程序。服務器接收客戶端發來的消息並回覆相同的消息。客戶端連接到服務器並發送一條消息，然後接收服務器的回覆並打印出來。

    public static void main12_server(String[] arg) {//main12_server
        //TestHomeController 的 main12 的主機端
        int portNumber = 12345; // 服務器監聽的端口号

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("服務器啟動，監聽端口：" + portNumber);

            // 等待客戶端連接
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已連接");

            // 獲取输入流，用於接收客户端消息
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // 獲取输出流，用於向客户端發送消息
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // 讀取客户端發送的消息
            String clientMessage = input.readLine();
            System.out.println("客戶端消息：" + clientMessage);

            // 發送相同的消息给客戶端
            output.println("服務器收到消息：" + clientMessage);

            // 關閉連接
            clientSocket.close();
            System.out.println("客户端已斷開連接");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main12_client(String[] arg) {//main12_client
        //TestHomeController 的 main12 的客戶端
        String serverAddress = "localhost"; // 服務器地址
        int portNumber = 12345; // 服務器端口號

        try (
                // 創建與服務器的連接
                Socket socket = new Socket(serverAddress, portNumber);
                // 獲取输出流，向服務器發送消息
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // 獲取输出流，接收服務器的響應消息
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 從控制台獲取输入
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;

            // 從控制台讀取輸入
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

    //main13
    //實作一個簡單的加密和解密程式，使用常見的加密算法（如AES）來加密一段文字，並能夠將其解密回原始內容
    public static void main13(String[] arg) throws Exception {
        String originalText = "Hello, world! This is a secret message.";

        // Generate AES key
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        // Encrypt the text
        String encryptedText = main13_encrypt(originalText, secretKey);
        System.out.println("加密: " + encryptedText);

        // Decrypt the text
        String decryptedText = main13_decrypt(encryptedText, secretKey);
        System.out.println("解密: " + decryptedText);

    }
    public static String main13_encrypt(String plaintext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String main13_decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

}
