import javax.persistence.*;

@Entity
public class GuestUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    // Default constructor
    public GuestUser() {}

    // Parameterized constructor
    public GuestUser(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Method to book tickets without an account
    public void bookWithoutAccount(EntityManager em, Show show) {
        System.out.println("Booking ticket for guest user: " + name);
        Booking booking = new Booking(this, show);
        em.getTransaction().begin();
        em.persist(booking);
        em.getTransaction().commit();
    }

    // Display guest user details
    public void displayDetails() {
        System.out.println("Guest Name: " + name);
        System.out.println("Guest Email: " + email);
        System.out.println("Guest Phone: " + phoneNumber);
    }
}
