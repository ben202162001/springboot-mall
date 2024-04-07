package com.test.springbootmall.util;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Component
public class ErrorMassage {
    String MassageStatus;//錯誤狀態
    String Massage;//錯誤訊息
    LocalTime ErrorTime;//錯誤時間

    public String getMassageStatus() {
        return MassageStatus;
    }

    public void setMassageStatus(String MassageStatus) {
        this.MassageStatus = MassageStatus;
    }

    public String getMassage() {
        return Massage;
    }

    public void setMassage(String massage) {
        Massage = massage;
    }

    public LocalTime  getErrorTime() {
        return ErrorTime;
    }

    public void setErrorTime(LocalTime  errorTime) {
        ErrorTime = errorTime;
    }

}
