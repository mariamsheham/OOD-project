import javax.persistence.*;
import java.util.List;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Theater theater; // Relation to Theater

    @OneToMany(mappedBy = "screen")
    private List<Show> shows; // Relation to Shows

    // Default constructor
    public Screen() {}

    // Parameterized constructor
    public Screen(String name, Theater theater) {
        this.name = name;
        this.theater = theater;
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

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    // Display screen details
    public void displayDetails() {
        System.out.println("Screen Name: " + name);
        System.out.println("Theater: " + theater.getName());
    }
}
