package com.gyhb.service;

import com.gyhb.entity.AppletAgreement;
import com.gyhb.utils.utils.IMOOCJSONResult;

public interface AppletAgreementService {

    public AppletAgreement queryAgreement(String id);

    public IMOOCJSONResult create(AppletAgreement agreement);

    public int update(AppletAgreement agreement);

    public IMOOCJSONResult deletAgreement(String id);

}
