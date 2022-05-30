package com.gyhb.service;


import com.gyhb.entity.Appletaddress;
import com.gyhb.entity.bo.AddressBO;

import java.util.List;
/**
 * @author YangJie
 * @date 2022/5/30 11:16
*/
public interface AddressService {
    
    /**
     * 根据用户id查询用户的收货地址列表
     *
     * @param userId userId
     * @return List<Appletaddress>
     */
     List<Appletaddress> queryAll(String userId);

    /**
     * 添加用户的收货地址
     * @param addressBO addressBO
     */
     void addNewUserAddress(AddressBO addressBO);

    /**
     * 更新用户的收货地址
     * @param addressBO addressBO
     */
     void updateAddress(AddressBO addressBO);

    /**
     * 删除用户的收货地址
     * @param userId userId
     * @param addressId addressId
     */
     void deleteUserAddress(String userId, String addressId);

    /**
     * 更新用户的默认收货地址
     * @param userId userId
     * @param addressId addressId
     */
     void updateUserAddressToBeDefault(String userId, String addressId);

    /**
     * 查询一条用户的收货地址
     * @param userId userId
     * @param addressId addressId
     * @return Appletaddress
     */
     Appletaddress queryUserAddress(String userId, String addressId);
}
