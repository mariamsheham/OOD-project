import javax.persistence.*;

@Entity
public class RegUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;

    // Default constructor
    public RegUser() {}

    // Parameterized constructor
    public RegUser(String name, String email, String phoneNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Registering a new user (adds the user to the database)
    public void register(EntityManager em) {
        em.getTransaction().begin();
        em.persist(this); // Persist the current instance of RegUser
        em.getTransaction().commit();
    }

    // Method for user login (checks if email and password match)
    public boolean login(EntityManager em, String email, String password) {
        RegUser user = em.find(RegUser.class, email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    // Display user details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Username: " + username);
    }

    // Method to update user details
    public void updateDetails(EntityManager em, String newName, String newEmail, String newPhoneNumber) {
        this.name = newName;
        this.email = newEmail;
        this.phoneNumber = newPhoneNumber;
        em.getTransaction().begin();
        em.merge(this); // Merge updates to the database
        em.getTransaction().commit();
    }

    // Method to delete the user from the database
    public void deleteUser(EntityManager em) {
        em.getTransaction().begin();
        RegUser userToDelete = em.find(RegUser.class, this.getId());
        if (userToDelete != null) {
            em.remove(userToDelete); // Remove the user from the database
        }
        em.getTransaction().commit();
    }
}
