package entities;

import entities.Project;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-15T22:14:24")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, Integer> hoursUsed;
    public static volatile SingularAttribute<Task, String> decription;
    public static volatile SingularAttribute<Task, String> name;
    public static volatile SingularAttribute<Task, Project> project;
    public static volatile SingularAttribute<Task, Integer> hoursAssigned;
    public static volatile SingularAttribute<Task, Integer> id;

}