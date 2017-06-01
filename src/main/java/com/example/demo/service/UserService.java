package com.example.demo.service;

import com.example.demo.dao.cluster.Address;
import com.example.demo.dao.master.User;
import com.example.demo.mapper.cluster.AddressMapper;
import com.example.demo.mapper.master.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/6/1.
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private AddressMapper addressMapper;


    public User find(int id) {
        User user = userMapper.selectByPrimaryKey(1);
        Address address = addressMapper.selectByPrimaryKey(1);
        Address address2 = addressMapper.selectByPrimaryKey(2);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address2);
        user.setAddresses(addressList);
        return user;
    }


}
