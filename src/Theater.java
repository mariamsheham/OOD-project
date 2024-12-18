import javax.persistence.*;
import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screens; // Relationship to screens

    // Default constructor
    public Theater() {}

    // Parameterized constructor
    public Theater(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    // Display theater details
    public void displayDetails() {
        System.out.println("Theater Name: " + name);
        System.out.println("Location: " + location);
    }
}
