package com.test.springbootmall.service;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.model.User;
import com.test.springbootmall.model.UserForHibernate;
import com.test.springbootmall.util.ErrorMassage;
import com.test.springbootmall.util.MyOrderPage;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
     ErrorMassage DoLogin(UserDto UserDto);
     User getUserData(UserDto UserDto);
     MyOrderPage<Purchase> getMemberOrders( String userId);
     UserForHibernate getUserDataByHibernate(UserDto UserDto);
}
