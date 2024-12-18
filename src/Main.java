import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create an EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest1.odb");
        EntityManager em = emf.createEntityManager();

        // Create a new user object
        user user1 = new user("John Doe", "john@example.com", "123-456-7890");

        // Check if user with this email already exists in the database
        TypedQuery<user> query = em.createQuery("SELECT u FROM user u WHERE u.email = :email", user.class);
        query.setParameter("email", user1.getEmail());
        List<user> existingUsers = query.getResultList();

        // If the user doesn't exist, persist the new user
        if (existingUsers.isEmpty()) {
            em.getTransaction().begin();
            em.persist(user1);  // Persisting the new user
            em.getTransaction().commit();
            System.out.println("User persisted: " + user1.getName());
        } else {
            System.out.println("User with this email already exists!");
        }

        // Create new movies for the user
        movie movie1 = new movie("Harry Potter and the Goblet of Fire", "Fantasy", 175, 7.7);
        movie movie2 = new movie("The Lord of the Rings", "Fantasy", 200, 8.9);

        // Add movies to the user
        user1.addMovie(movie1);
        user1.addMovie(movie2);

        // Persist the user and associated movies
        em.getTransaction().begin();
        em.persist(user1);  // Persist user and cascade to movies
        em.getTransaction().commit();
        System.out.println("Movies persisted for " + user1.getName());

        // Retrieve the user and display their movies
        user foundUser = em.find(user.class, user1.getId());
        if (foundUser != null) {
            System.out.println("Found User: ");
            foundUser.displayDetails();

            // Access and display the movies of the user
            List<movie> userMovies = foundUser.getMovies();
            System.out.println("Movies of " + foundUser.getName() + ":");
            for (movie m : userMovies) {
                m.displayDetails();
            }
        }

        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}
