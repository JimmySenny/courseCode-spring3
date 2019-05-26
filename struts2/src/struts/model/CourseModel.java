package struts.model;

public class CourseModel {
    
    private String cname;
    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    public String getCname() {
        return cname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cname == null) ? 0 : cname.hashCode());
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
        CourseModel other = (CourseModel) obj;
        if (cname == null) {
            if (other.cname != null)
                return false;
        } else if (!cname.equals(other.cname))
            return false;
        return true;
    }
    
}
