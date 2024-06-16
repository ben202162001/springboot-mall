package com.test.springbootmall.controller;

import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.util.ErrorMassage;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
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
    //最小公倍數
    public static void main3(String arg[]) {
        int z = 2;
        int x = 3;

        for (int i = z ; i<= z*x ;i++){
            System.out.println(i);
            if (i%z ==0 && i%x ==0){
                System.out.println(i+"!!");
            }
        }

    }
    //最大公因數
    public static void main4(String arg[]) {
        int x = 100;
        int y = 200;
        int z = 300;
        int max = 0;

        for (int i = 1 ; i<= z ;i++){
            if (x%i ==0 && y%i ==0 && z%i ==0){
                max = i;
            }
        }
        System.out.println(max);

    }
//    不死母蜂一年生一隻公蜂，每隻公蜂一年生一隻普通的母蜂和一個公蜂後就死掉，
//    普通的母蜂一年生一隻公蜂後死掉。現在在一個只有一隻不死母蜂的實驗環境下，
//    Input N年，Output 公蜂有幾隻、總共有幾隻蜜蜂
    public static void main5(String arg[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入幾年:");
        int year = input.nextInt();
        int man = 0 ;
        int women = 0;
        int man_pre = 0;
        int women_pre =0;
        for (int i = 1 ; i<= year ;i++){
            man = man_pre +women_pre;
            man = man+1;
            women = man_pre ;

            man_pre = man;
            women_pre = women;
        }
        System.out.println("男峰:"+man);
        System.out.println("女峰:"+women);
    }
    //輸入一串可重複的整數數列，求出重複最多次的整數以及重複次數。
    public static void main6(String arg[]) {
        System.out.print("請輸入一串整數數列（用.分隔）：");
        Scanner input = new Scanner(System.in);
        String nums = input.nextLine();
        String[] num_list = nums.split("\\.");
        Map<Integer, Integer> countMap = new HashMap<>();
        // 記錄每個數字出現的次數
        for (int i = 0; i<num_list.length; i++) {
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
        System.out.println("mostFrequentNumber:"+mostFrequentNumber);
        System.out.println("maxCount:"+maxCount);
    }
}
