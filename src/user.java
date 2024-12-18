import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    // One-to-many relationship with movies
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<movie> movies = new ArrayList<>();

    // Constructor
    public user(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<movie> getMovies() {
        return movies;
    }

    public void addMovie(movie movie) {
        this.movies.add(movie);
        movie.setUser(this); // setting the user reference in movie
    }

    // Method to display user details
    public void displayDetails() {
        System.out.println("user: " + name + ", Email: " + email + ", Phone: " + phone);
    }
}
