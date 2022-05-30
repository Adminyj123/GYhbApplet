package com.gyhb.service;

import com.gyhb.entity.AppletAgreement;
import com.gyhb.utils.utils.IMOOCJSONResult;

/**
 * @author YangJie
 * @date 2022/5/30 11:20
*/
public interface AppletAgreementService {

     /**
      * 根据id去查询相应的数据
      *
      * @param id
      * @return AppletAgreement
      */
     AppletAgreement queryAgreement(String id);

     /**
      *  新增
      * @param agreement
      * @return IMOOCJSONResult
      */
     IMOOCJSONResult create(AppletAgreement agreement);

     /**
      *  更新数据
      * @param agreement
      * @return int
      */
     int update(AppletAgreement agreement);

     /**
      * 删除数据
      * @param id
      * @return
      */
     IMOOCJSONResult deleteAgreement(String id);

}
