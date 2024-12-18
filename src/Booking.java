import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private GuestUser guestUser; // Relation to GuestUser

    @ManyToOne
    private Show show; // Relation to Show

    // Default constructor
    public Booking() {}

    // Parameterized constructor
    public Booking(GuestUser guestUser, Show show) {
        this.guestUser = guestUser;
        this.show = show;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GuestUser getGuestUser() {
        return guestUser;
    }

    public void setGuestUser(GuestUser guestUser) {
        this.guestUser = guestUser;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    // Display booking details
    public void displayBookingDetails() {
        System.out.println("Booking ID: " + id);
        System.out.println("Guest user: " + guestUser.getName());
        System.out.println("Show Title: " + show.getTitle());
    }
}
