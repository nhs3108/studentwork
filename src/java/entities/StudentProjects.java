package entities;
// Generated Mar 21, 2015 9:28:13 PM by Hibernate Tools 4.3.1



/**
 * StudentProjects generated by hbm2java
 */
public class StudentProjects  implements java.io.Serializable {


     private Integer id;
     private int studentId;
     private String project;
     private String link;
     private String more;

    public StudentProjects() {
    }

	
    public StudentProjects(int studentId) {
        this.studentId = studentId;
    }
    public StudentProjects(int studentId, String project, String link, String more) {
       this.studentId = studentId;
       this.project = project;
       this.link = link;
       this.more = more;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getProject() {
        return this.project;
    }
    
    public void setProject(String project) {
        this.project = project;
    }
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    public String getMore() {
        return this.more;
    }
    
    public void setMore(String more) {
        this.more = more;
    }




}


