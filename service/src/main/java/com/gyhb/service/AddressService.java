package com.gyhb.service;


import com.gyhb.entity.Appletaddress;
import com.gyhb.entity.bo.AddressBO;

import java.util.List;

public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     */
     List<Appletaddress> queryAll(String userId);

    /**
     * 添加用户的收货地址
     */
     void addNewUserAddress(AddressBO addressBO);


    /**
     * 更新用户的收货地址
     */
     void updateAddress(AddressBO addressBO);

    /**
     * 删除用户的收货地址
     */
     void deleteUserAddress(String userId, String addressId);

    /**
     * 更新用户的默认收货地址
     */
     void updateUserAddressToBeDefault(String userId, String addressId);

    /**
     * 查询一条用户的收货地址
     */
     Appletaddress queryUserAddress(String userId, String addressId);
}
