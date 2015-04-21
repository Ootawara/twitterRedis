package bean;

/**
 * 
 * @author emmanuel_plaisance
 *
 */
public class Username {

    private String name;
    
    public Username(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Utilisateur : " + name;
    }

}
