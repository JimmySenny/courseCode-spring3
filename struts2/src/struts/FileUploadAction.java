package struts;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;

import com.opensymphony.xwork2.ActionSupport;


public class FileUploadAction extends ActionSupport {
    
    private File[] myFile;
    private String[] myFileFileName;
    private String submitFlag = "toUp";
    
    public void setMyFile(File[] myFile) {
        this.myFile = myFile;
    }
    public void setMyFileFileName(String[] myFileFileName) {
        this.myFileFileName = myFileFileName;
    }
    public void setSubmitFlag(String submitFlag) {
        this.submitFlag = submitFlag;
    }
    
    @Override
    public String execute() throws Exception {
        if("toUp".equals(submitFlag)) {
            return "toUp";
        }
        
        FileInputStream is = null;
        try {
            is = new FileInputStream(myFile[0]);
            byte b[] = new byte[is.available()];
            is.read(b);
            System.out.println("========" + myFile[1].getName());
            System.out.println("========" + myFileFileName);
            System.out.println("========" + new String(b));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        
        return this.SUCCESS;
    }
}
