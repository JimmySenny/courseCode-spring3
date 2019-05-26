package cn.javass.web.action;

import java.io.File;
import java.io.FileInputStream;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
    
    public File[] myfile;
    
    public String[] myfileFileName;

    public String[] myfileContentType;
    
    @Override
    public String execute() throws Exception {
        for(int i=0;i<myfile.length;i++) {
            FileInputStream fis = new FileInputStream(myfile[i]);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            System.out.println("==========================");
            System.out.println(myfileFileName[i]);
            System.out.println(myfileContentType[i]);
            System.out.println(new String(bytes));
            System.out.println("==========================");
            
        }
        return "success";
    }

}
