package struts.model;

public class GradeModel {
    

    private StudentModel sm;
    private CourseModel cm;
    private int score;
    
    public void setCm(CourseModel cm) {
        this.cm = cm;
    }
    public void setSm(StudentModel sm) {
        this.sm = sm;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    public CourseModel getCm() {
        return cm;
    }
    public int getScore() {
        return score;
    }
    public StudentModel getSm() {
        return sm;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cm == null) ? 0 : cm.hashCode());
        result = prime * result + ((sm == null) ? 0 : sm.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GradeModel other = (GradeModel) obj;
        if (cm == null) {
            if (other.cm != null)
                return false;
        } else if (!cm.equals(other.cm))
            return false;
        if (sm == null) {
            if (other.sm != null)
                return false;
        } else if (!sm.equals(other.sm))
            return false;
        return true;
    }
    
}
