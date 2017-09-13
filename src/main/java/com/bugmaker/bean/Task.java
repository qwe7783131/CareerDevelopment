package bean;
// Generated 2017-9-13 8:41:34 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Task generated by hbm2java
 */
@Entity
@Table(name="task"
    ,catalog="career_development"
)
public class Task  implements java.io.Serializable {


     private String id;
     private String title;
     private String content;
     private String jobId;
     private Date startTime;
     private Date endTime;

    public Task() {
    }

	
    public Task(String id) {
        this.id = id;
    }
    public Task(String id, String title, String content, String jobId, Date startTime, Date endTime) {
       this.id = id;
       this.title = title;
       this.content = content;
       this.jobId = jobId;
       this.startTime = startTime;
       this.endTime = endTime;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false, length=32)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="title", length=32)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="content", length=100)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="job_id", length=32)
    public String getJobId() {
        return this.jobId;
    }
    
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_time", length=19)
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_time", length=19)
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }




}


