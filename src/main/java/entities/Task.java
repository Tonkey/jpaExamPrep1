package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author nickl
 */
@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String decription;
    private int hoursAssigned;
    private int hoursUsed;
    
    @ManyToOne
    private Project project;
    
    public Task(){
        
    }
    
    public Task(String name, String description, int hoursAssigned, int hoursUsed){
        this.name = name;
        this.decription = description;
        this.hoursAssigned = hoursAssigned;
        this.hoursUsed = hoursUsed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDecription() {
        return decription;
    }

    public int getHoursAssigned() {
        return hoursAssigned;
    }

    public int getHoursUsed() {
        return hoursUsed;
    }

    public Project getProject() {
        return project;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setHoursAssigned(int hoursAssigned) {
        this.hoursAssigned = hoursAssigned;
    }

    public void setHoursUsed(int hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
