package test;

import entities.Project;
import entities.ProjectUser;
import entities.Task;
import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author nickl
 */
public class SchemaBuilder {

    private static final boolean DEBUGGING = false;

    public static void main(String[] args) {
        HashMap<String, Object> puproperties = new HashMap<>();

        puproperties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        puproperties.put("javax.persistence.sql-load-source", "scripts/clearDB.sql");

//        Persistence.generateSchema("jpaE_PU", puproperties);

        if (DEBUGGING) {
            Facade f = new Facade();
            ProjectUser user = new ProjectUser("Nicklas", "Molving", "Today");
            f.createUser(user);
            Project p = new Project("TestProject2", "Test Desc", "Today", "Today");
            f.createProject(p);
            ProjectUser pu = f.findUser("Molving");
            System.out.println(pu.getEmail());

            p = f.findProject(p.getName());
            System.out.println(p.getId());

            System.out.println(f.assignUserToProject(pu, p));

            Task t = new Task("Test Task", "Test Desc", 1, 1);

            System.out.println(f.createTaskAndAssignToProject(p, t));
        }
    }
}
