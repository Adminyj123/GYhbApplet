package com.gyhb.controller;

import com.gyhb.service.FileService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "文件上传", tags = {"文件上传接口"})
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    final static Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 上传用户头像，默认最大单个文件上传为1M，否则报错,如需修改上传文件大小，需要进行配置spring.servlet.multipart.max-file-size=20MB
     * @param file
     * @return
     */
    @ApiOperation("用户文件上传")
    @PostMapping(value = "/upload")
    public IMOOCJSONResult uploadUserImg(@ApiParam(value = "文件上传",required=true)
                                         @RequestPart("file") MultipartFile file){

        String result = fileService.uploadUserImg(file);
        return result!=null ? IMOOCJSONResult.ok(result):IMOOCJSONResult.errorMsg("上传文件到服务器失败，请稍后再试");
    }
}
