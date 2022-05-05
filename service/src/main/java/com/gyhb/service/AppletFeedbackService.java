package com.gyhb.service;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.utils.utils.IMOOCJSONResult;

public interface AppletFeedbackService {

    /**
     *新增
     */
     IMOOCJSONResult create(Appletfeedback appletfeedback);
}
