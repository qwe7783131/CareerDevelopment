package bean;
// Generated 2017-9-13 8:41:34 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Internship generated by hbm2java
 */
@Entity
@Table(name="internship"
    ,catalog="career_development"
)
public class Internship  implements java.io.Serializable {


     private int id;
     private String type;
     private Integer jobId;

    public Internship() {
    }

	
    public Internship(int id) {
        this.id = id;
    }
    public Internship(int id, String type, Integer jobId) {
       this.id = id;
       this.type = type;
       this.jobId = jobId;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="type")
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="job_id")
    public Integer getJobId() {
        return this.jobId;
    }
    
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }




}


