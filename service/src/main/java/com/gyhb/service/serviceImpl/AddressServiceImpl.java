package com.gyhb.service.serviceImpl;

import com.gyhb.entity.Appletaddress;
import com.gyhb.entity.bo.AddressBO;
import com.gyhb.mapper.AppletaddressMapper;
import com.gyhb.service.AddressService;
import com.gyhb.utils.utils.YesOrNo;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AppletaddressMapper addressMapper;

    private final Sid sid;

    public AddressServiceImpl(AppletaddressMapper addressMapper, Sid sid) {
        this.addressMapper = addressMapper;
        this.sid = sid;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Appletaddress> queryAll(String userId) {

        Appletaddress ua = new Appletaddress();
        ua.setUserid(userId);

        return addressMapper.select(ua);
    }

   @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {

        // 1. 判断当前用户是否存在地址，如果没有，则新增为‘默认地址’
        int isDefault = 0;
        List<Appletaddress> addressList = this.queryAll(addressBO.getUserid());
        if (addressList == null || addressList.isEmpty() || addressList.size() == '0') {
            isDefault = 1;
        }

        String addressId = sid.nextShort();

        // 2. 保存地址到数据库
       Appletaddress newAddress = new Appletaddress();
        BeanUtils.copyProperties(addressBO, newAddress);

        newAddress.setId(addressId);
        newAddress.setFlag(Integer.toString(isDefault));
        newAddress.setCreatedTime(new Date());
        newAddress.setUpdatedTime(new Date());

       addressMapper.insert(newAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateAddress(AddressBO addressBO) {

        String addressId = addressBO.getAddressId();

        Appletaddress pendingAddress = new Appletaddress();
        BeanUtils.copyProperties(addressBO, pendingAddress);

        pendingAddress.setId(addressId);
        pendingAddress.setUpdatedTime(new Date());

        addressMapper.updateByPrimaryKeySelective(pendingAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserAddress(String userId, String addressId) {

        Appletaddress address = new Appletaddress();
        address.setId(addressId);
        address.setUserid(userId);

        addressMapper.delete(address);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddressToBeDefault(String userId, String addressId) {

        // 1. 查找默认地址，设置为不默认
        Appletaddress queryAddress = new Appletaddress();
        queryAddress.setUserid(userId);
        queryAddress.setFlag(YesOrNo.YES.type.toString());
        List<Appletaddress> list  = addressMapper.select(queryAddress);
        for (Appletaddress ua : list) {
            ua.setFlag(YesOrNo.NO.type.toString());
            addressMapper.updateByPrimaryKeySelective(ua);
        }

        // 2. 根据地址id修改为默认的地址
        Appletaddress defaultAddress = new Appletaddress();
        defaultAddress.setId(addressId);
        defaultAddress.setUserid(userId);
        defaultAddress.setFlag(YesOrNo.YES.type.toString());
        addressMapper.updateByPrimaryKeySelective(defaultAddress);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Appletaddress queryUserAddress(String userId, String addressId) {

        Appletaddress singleAddress = new Appletaddress();
        singleAddress.setId(addressId);
        singleAddress.setUserid(userId);

        return addressMapper.selectOne(singleAddress);
    }
}
