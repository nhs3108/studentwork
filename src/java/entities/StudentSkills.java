package entities;
// Generated Mar 21, 2015 9:28:13 PM by Hibernate Tools 4.3.1



/**
 * StudentSkills generated by hbm2java
 */
public class StudentSkills  implements java.io.Serializable {


     private Integer id;
     private int studentId;
     private String skill;
     private String level;

    public StudentSkills() {
    }

	
    public StudentSkills(int studentId) {
        this.studentId = studentId;
    }
    public StudentSkills(int studentId, String skill, String level) {
       this.studentId = studentId;
       this.skill = skill;
       this.level = level;
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
    public String getSkill() {
        return this.skill;
    }
    
    public void setSkill(String skill) {
        this.skill = skill;
    }
    public String getLevel() {
        return this.level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }




}

