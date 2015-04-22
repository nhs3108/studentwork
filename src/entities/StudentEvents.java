package entities;
// Generated 31-Mar-2015 00:53:37 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * StudentEvents generated by hbm2java
 */
public class StudentEvents  implements java.io.Serializable {


     private Integer id;
     private Integer studentId;
     private String event;
     private String place;
     private Date time;
     private String more;

    public StudentEvents() {
    }

    public StudentEvents(Integer studentId, String event, String place, Date time, String more) {
       this.studentId = studentId;
       this.event = event;
       this.place = place;
       this.time = time;
       this.more = more;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public String getEvent() {
        return this.event;
    }
    
    public void setEvent(String event) {
        this.event = event;
    }
    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
    public String getMore() {
        return this.more;
    }
    
    public void setMore(String more) {
        this.more = more;
    }




}

