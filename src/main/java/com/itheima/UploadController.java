package com.itheima;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class  UploadController {

  @RequestMapping("fileUpload")
    public String testFileUpload(HttpServletRequest request) throws Exception {
    System.out.println(request);
    String basepath = request.getSession().getServletContext().getRealPath("/upload/");
    System.out.println(basepath);
    String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    File file = new File(basepath + date);
    if (!file.exists()){
       file.mkdir();
    }
    System.out.println(file);
    DiskFileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List<FileItem> fileItems = upload.parseRequest(request);
    for (FileItem fileItem : fileItems) {
      if (fileItem.isFormField()){
        System.out.println(fileItem.getString("UTF-8"));
      }else {
        String fileName = fileItem.getName();
        String uuidFileName = UUID.randomUUID().toString().replace("-","").toUpperCase()+"_"+fileName;
        fileItem.write(new File(file,uuidFileName));
        fileItem.delete();
      }

    }
return "success";
  }




}
