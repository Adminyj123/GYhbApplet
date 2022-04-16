package com.gyhb.service;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserVo;
import com.gyhb.utils.utils.IMOOCJSONResult;

public interface AppletFeedbackService {

    /**
     *
     * @param appletfeedback
     * @return
     */
    public IMOOCJSONResult create(Appletfeedback appletfeedback);
}
