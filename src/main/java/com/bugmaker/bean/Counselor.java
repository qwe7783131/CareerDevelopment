package bean;
// Generated 2017-9-13 8:41:34 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Counselor generated by hbm2java
 */
@Entity
@Table(name="counselor"
    ,catalog="career_development"
)
public class Counselor  implements java.io.Serializable {


     private String id;

    public Counselor() {
    }

    public Counselor(String id) {
       this.id = id;
    }
   
     @Id 
    
    @Column(name="id", nullable=false, length=32)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }




}


