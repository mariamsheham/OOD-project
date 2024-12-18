import javax.persistence.*;
import java.util.List;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String showTime;

    @ManyToOne
    private Screen screen; // Relation to Screen

    @OneToMany(mappedBy = "show")
    private List<Booking> bookings; // Relation to bookings

    // Default constructor
    public Show() {}

    // Parameterized constructor
    public Show(String title, String showTime, Screen screen) {
        this.title = title;
        this.showTime = showTime;
        this.screen = screen;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    // Display show details
    public void displayDetails() {
        System.out.println("Show Title: " + title);
        System.out.println("Show Time: " + showTime);
        System.out.println("Screen: " + screen.getName());
    }
}
