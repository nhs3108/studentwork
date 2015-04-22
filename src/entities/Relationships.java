package entities;
// Generated Apr 10, 2015 2:29:07 PM by Hibernate Tools 4.3.1



/**
 * Relationships generated by hbm2java
 */
public class Relationships  implements java.io.Serializable {


     private Integer relationshipId;
     private int user1Id;
     private int user2Id;
     private int status;

    public Relationships() {
    }

	
    public Relationships(int user1Id, int user2Id) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
    }
    public Relationships(int user1Id, int user2Id, int status) {
       this.user1Id = user1Id;
       this.user2Id = user2Id;
       this.status = status;
    }
   
    public Integer getRelationshipId() {
        return this.relationshipId;
    }
    
    public void setRelationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
    }
    public int getuser1Id() {
        return this.user1Id;
    }
    
    public void setuser1Id(int user1Id) {
        this.user1Id = user1Id;
    }
    public int getuser2Id() {
        return this.user2Id;
    }
    
    public void setuser2Id(int user2Id) {
        this.user2Id = user2Id;
    }
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }




}


