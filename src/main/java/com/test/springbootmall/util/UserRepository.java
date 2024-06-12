package com.test.springbootmall.util;
import com.test.springbootmall.model.UserForHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserForHibernate, Integer>{
    UserForHibernate findByPhoneNumber(String phoneNumber);
}
