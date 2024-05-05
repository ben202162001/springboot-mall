package com.test.springbootmall.service.impl;

import com.test.springbootmall.dao.UserDao;
import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.Product;
import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.model.User;
import com.test.springbootmall.service.UserService;
import com.test.springbootmall.util.ErrorMassage;
import com.test.springbootmall.util.MyOrderPage;
import com.test.springbootmall.util.ProductPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao UserDao;

    @Autowired
    public UserServiceImpl(UserDao UserDao) {
        this.UserDao = UserDao;
    }
    @Autowired
    ErrorMassage ErrorMassage;

    @Override
    public ErrorMassage DoLogin(UserDto UserDto) {
        LocalTime dtf = LocalTime.now();
        //判斷帳號是否有輸入
        if (UserDto == null || UserDto.getPhone_Number().equals("")||UserDto.getPassword().equals("")) {
            ErrorMassage.setMassageStatus("fail");
            ErrorMassage.setMassage("帳號請輸入完整");
            ErrorMassage.setErrorTime(dtf);
            return ErrorMassage;
        }
        //判斷帳號是否存在
        Boolean isExsitAccount =UserDao.CheckPhoneNumber(UserDto);
        if (isExsitAccount.equals(false)){
            ErrorMassage.setMassageStatus("fail");
            ErrorMassage.setMassage("帳號不存在");
            ErrorMassage.setErrorTime(dtf);
            return ErrorMassage;
        }
        //判斷帳號密碼是否正確
        User user=UserDao.DoLoginCheck(UserDto);
        if (user == null){
            ErrorMassage.setMassageStatus("fail");
            ErrorMassage.setMassage("密碼不正確");
            ErrorMassage.setErrorTime(dtf);
            return ErrorMassage;
        }
        ErrorMassage.setMassageStatus("success");
        ErrorMassage.setMassage("");
        ErrorMassage.setErrorTime(dtf);
        return ErrorMassage;
    }
    @Override
    public User getUserData(UserDto UserDto){
        return UserDao.getUserData(UserDto);
    }

    @Override
    public MyOrderPage<Purchase> getMemberOrders(String PhoneNumber) {

        MyOrderPage<Purchase> Purchase_record = new MyOrderPage<>();

        //使用者資料
        UserDto UserDto = new UserDto();
        UserDto.setPhone_Number(PhoneNumber);
        User User = getUserData (UserDto);
        Purchase_record.setPhoneNumber(PhoneNumber);
        Purchase_record.setUserId(User.getUserId());
        Purchase_record.setUserName(User.getUserName());

        //使用者訂單資料
        List<Purchase> PurchaseList= UserDao.getMemberOrders(PhoneNumber);
        Purchase_record.setOrders(PurchaseList);

        return Purchase_record;
    }


}
