package com.gyhb.service;

import com.gyhb.entity.AppletAgreement;
import com.gyhb.utils.utils.IMOOCJSONResult;

public interface AppletAgreementService {

     AppletAgreement queryAgreement(String id);

     IMOOCJSONResult create(AppletAgreement agreement);

     int update(AppletAgreement agreement);

     IMOOCJSONResult deleteAgreement(String id);

}
