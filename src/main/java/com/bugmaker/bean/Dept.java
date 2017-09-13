package bean;
// Generated 2017-9-13 8:41:34 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dept generated by hbm2java
 */
@Entity
@Table(name="dept"
    ,catalog="career_development"
)
public class Dept  implements java.io.Serializable {


     private String id;
     private String deptName;

    public Dept() {
    }

	
    public Dept(String id) {
        this.id = id;
    }
    public Dept(String id, String deptName) {
       this.id = id;
       this.deptName = deptName;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false, length=32)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="dept_name", length=32)
    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }




}


