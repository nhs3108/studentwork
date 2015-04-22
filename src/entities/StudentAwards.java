package entities;
// Generated 31-Mar-2015 00:53:37 by Hibernate Tools 4.3.1



/**
 * StudentAwards generated by hbm2java
 */
public class StudentAwards  implements java.io.Serializable {


     private Integer id;
     private int studentId;
     private String award;
     private Integer year;
     private String more;

    public StudentAwards() {
    }

	
    public StudentAwards(int studentId) {
        this.studentId = studentId;
    }
    public StudentAwards(int studentId, String award, Integer year, String more) {
       this.studentId = studentId;
       this.award = award;
       this.year = year;
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
    public String getAward() {
        return this.award;
    }
    
    public void setAward(String award) {
        this.award = award;
    }
    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getMore() {
        return this.more;
    }
    
    public void setMore(String more) {
        this.more = more;
    }




}


