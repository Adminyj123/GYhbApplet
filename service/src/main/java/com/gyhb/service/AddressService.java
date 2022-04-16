package com.gyhb.service;


import com.gyhb.entity.Appletaddress;
import com.gyhb.entity.bo.AddressBO;

import java.util.List;

public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     * @param userId
     * @return
     */
    public List<Appletaddress> queryAll(String userId);

    /**
     * 添加用户的收货地址
     * @param addressBO
     */
    public void addNewUserAddress(AddressBO addressBO);


    /**
     * 更新用户的收货地址
     * @param addressBO
     */
    public void updateAddress(AddressBO addressBO);

    /**
     * 删除用户的收货地址
     * @param userId
     * @param addressId
     */
    public void deleteUserAddress(String userId, String addressId);

    /**
     * 更新用户的默认收货地址
     * @param userId
     * @param addressId
     */
    public void updateUserAddressToBeDefault(String userId, String addressId);

    /**
     * 查询一条用户的收货地址
     * @param userId
     * @param addressId
     * @return
     */
    public Appletaddress queryUserAddres(String userId, String addressId);
}
