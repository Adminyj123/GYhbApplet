package com.gyhb.service.serviceImpl;

import com.gyhb.service.FileService;
import com.gyhb.utils.utils.COSConfig;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private COSConfig cosConfig;

    /**
     * 用户头像上传到腾讯云cos对象存储后返回文件URL地址
     * @param multipartFile  (MultipartFile是一个java中的文件上传对象，通过这个对象可以拿到许多上传的相关信息)
     * @return
     */
    @Override
    public String uploadUserImg(MultipartFile multipartFile) {
        //获取相关配置
        String secretId =cosConfig.getSecretId();
        String secretKey =cosConfig.getSecretKey();
        String bucketName =cosConfig.getBucketName();
        String bucketRegion =cosConfig.getBucketRegion();

        //创建COS对象
// 1 初始化用户身份信息（secretId, secretKey）。
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        Region reg = new Region(bucketRegion);
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        ClientConfig clientConfig = new ClientConfig(reg);
// 这里建议设置使用 https 协议，从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        //获取上传的文件的原生文件扩展名xxx.jpg
        String originalFileName = multipartFile.getOriginalFilename();
        System.out.println("获取上传的文件的原生文件扩展名:"+originalFileName);

        //设置JDK8的日期格式，用于下面进行桶的存储URL的拼接
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //拼接存储的地址路径 2022/12/1/sdagfsfas.jpg
        String floder = dtf.format(ldt);
        String fileName = generateUUID(); //生成随机UUID作为文件名
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String newFileName = "user/" + floder + "/" + fileName + extension;


        try {

            ObjectMetadata objectMetadata = new ObjectMetadata();
            // 从输入流上传必须制定content length, 不然http客户端可能会缓存全部数据，存在内存OOM的状况
            objectMetadata.setContentLength(multipartFile.getSize());
            // 默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值
            // objectMetadata.setContentType("image/jpeg");

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, newFileName,multipartFile.getInputStream(),objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            if(putObjectResult!=null){
                String imgUrl = "https://"+bucketName+".cos."+bucketRegion+".myqcloud.com/"+newFileName;
                return imgUrl;
            }
        } catch (IOException e) {
            System.out.println("文件上传失败，打印错误日志");
            System.out.println(e);
        }finally {
            //一定要关闭COS服务，否则会造成OOM内存泄露。
            cosClient.shutdown();
        }

        return null;
    }


    /**
     * 生成 uuid，
     * @return
     */
    public String generateUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","").substring(0,32);
        return uuid;
    }

}

