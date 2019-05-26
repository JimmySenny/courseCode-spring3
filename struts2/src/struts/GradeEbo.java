package struts;

import java.util.ArrayList;
import java.util.List;

import struts.model.CourseModel;
import struts.model.GradeModel;
import struts.model.StudentModel;

public class GradeEbo {
    
    public static List<GradeModel> list() {
        List<GradeModel> gmList = new ArrayList<GradeModel>();
        StudentModel sm1 = new StudentModel();
        sm1.setSname("张开涛");
        StudentModel sm2 = new StudentModel();
        sm2.setSname("王斌");
        StudentModel sm3 = new StudentModel();
        sm3.setSname("陈臣");
        
        CourseModel cm1 = new CourseModel();
        cm1.setCname("语文");
        CourseModel cm2 = new CourseModel();
        cm2.setCname("数学");
        
        GradeModel gm11 = new GradeModel();
        gm11.setSm(sm1);
        gm11.setCm(cm1);
        gm11.setScore(100);
        GradeModel gm12 = new GradeModel();
        gm12.setSm(sm1);
        gm12.setCm(cm2);
        gm12.setScore(100);
        

        GradeModel gm21 = new GradeModel();
        gm21.setSm(sm2);
        gm21.setCm(cm1);
        gm21.setScore(15);
        GradeModel gm22 = new GradeModel();
        gm22.setSm(sm2);
        gm22.setCm(cm2);
        gm22.setScore(20);

        GradeModel gm31 = new GradeModel();
        gm31.setSm(sm3);
        gm31.setCm(cm1);
        gm31.setScore(10);
        GradeModel gm32 = new GradeModel();
        gm32.setSm(sm3);
        gm32.setCm(cm2);
        gm32.setScore(10);
        
        gmList.add(gm11);
        gmList.add(gm12);
        gmList.add(gm21);
        gmList.add(gm22);
        gmList.add(gm31);
        gmList.add(gm32);
        
        return gmList;
    }
}
