package com.test.springbootmall.controller;

import com.test.springbootmall.util.ErrorMassage;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static class book {
        String ID;
        String bookname;
        Date pub_date;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getBookname() {
            return bookname;
        }

        public void setBookname(String bookname) {
            this.bookname = bookname;
        }

        public Date getPub_date() {
            return pub_date;
        }

        public void setPub_date(Date pub_date) {
            this.pub_date = pub_date;
        }
    }

    @GetMapping("/books")
    public List<book> books() throws ParseException {
        List<book> books = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        book book1 = new book();
        book1.setID("00A3");
        book1.setBookname("黑心建商的告白");
        Date date = dateFormat.parse("2022-10-31");
        book1.setPub_date(date);

        book book2 = new book();
        book2.setID("FBA9");
        book2.setBookname("Java 編程入門");
        date = dateFormat.parse("2022-10-31");
        book2.setPub_date(date);


        book book3 = new book();
        book3.setID("9786132156437");
        book3.setBookname("Head First Java");
        date = dateFormat.parse("2022-10-31 09:00:00");
        book3.setPub_date(date);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }
    @PostMapping("/books")
    public ErrorMassage books(@RequestBody book book) {
        book book1 = new book();
        book1.setID(book.getID());
        book1.setBookname(book.getBookname());
        book1.setPub_date(book.getPub_date());


        ErrorMassage ErrorMassage = new ErrorMassage();
        ErrorMassage.setMassage("新增成功");

        return ErrorMassage;

    }

//    【題目2】字串處理
//
//● 題目敘述：寫一個可輸入的main方法，將輸入IP資訊反轉順序後輸出呈現。
//
//            ● 輸入/輸出結果範例：
//    輸入:"127.0.0.1" --> 輸出:"1.0.0.127"
public static void main(String[] args) {
        String xxx = "127.0.0.1";

        //用.分隔裝
        String[] reverse = xxx.split("\\.");

        //把LIST反轉
        for (int i=0;i<reverse.length;i++){
            System.out.print(reverse[reverse.length-1-i]);
            if (i != reverse.length-1) {
            System.out.print(".");}

        }
}
}