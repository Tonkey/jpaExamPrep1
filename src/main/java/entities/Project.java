package entities;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**
 *
 * @author nickl
 */
@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String description;
    private String created;
    private String lastModified;
    
    @ManyToMany
    private List<ProjectUser> usersAssigned = new ArrayList();
    
    @OneToMany(mappedBy = "project")
    private List<Task> assignedTasks = new ArrayList();
    
    public Project(){
        
    }
    
    public Project(String name, String description, String created, String lastModified){
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated() {
        return created;
    }

    public String getLastModified() {
        return lastModified;
    }

    public List<ProjectUser> getUsersAssigned() {
        return usersAssigned;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public void setUsersAssigned(List<ProjectUser> usersAssigned) {
        this.usersAssigned = usersAssigned;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}
