package com.etc.controller;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
@Controller
@RequestMapping("/file")
public class UploadController {
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception{
        String filePath = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println(filePath);
        File file = new File(filePath);
        if(!file.exists()){
            System.out.println("文件夹不存在，并创建");
            file.mkdirs();
        }else{
            System.out.println("文件夹存在");
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItem = upload.parseRequest(request);
        for (FileItem item:fileItem) {
            if (item.isFormField()){
                System.out.println("-----普通文本域------");
            }else{
                String fileName =filePath+item.getName();
                System.out.println(fileName);
                item.write(new File(fileName));
                item.delete();
            }
        }
        return "success";
    }
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request,MultipartFile upload) throws Exception{
        System.out.println("test fileUpload2");
        String filePath = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(filePath);
        if(!file.exists()){
            System.out.println("文件夹不存在，并创建");
            file.mkdirs();
        }else{
            System.out.println("文件夹存在");
        }
        String fileName = upload.getOriginalFilename();
        upload.transferTo(new File(filePath,fileName));

        return "success";
    }
    @RequestMapping("/fileUpload3")
    public String testUpload3(HttpServletRequest request, MultipartFile upload) throws  Exception {
        System.out.println("跨服务器传递");
        //将上传的文件需要放到其他服务器的一个目录下面
        String path="http://localhost:9090/upload";
        //获取文件名字
        String fileName = upload.getOriginalFilename();
        path=path+fileName;
        System.out.println(path);
        //创建客户端
        Client client = Client.create();
        //客户端取连接文件服务器
        WebResource webResource = client.resource(path);
        //把文件放入到指定位置
        webResource.put(upload.getBytes());
        return "ok";
    }
}
