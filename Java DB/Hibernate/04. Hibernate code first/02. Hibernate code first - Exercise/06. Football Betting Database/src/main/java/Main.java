import entities.Color;
import entities.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        String persistenceUnitName = "FootballBetting";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();

//        em.getTransaction().begin();
//        Color blue = new Color("blue");
//        Color orange = new Color("orange");
//        Color yellow = new Color("yellow");
//        Color green = new Color("green");
//
//        em.persist(blue);
//        em.persist(orange);
//        em.persist(green);
//
//        Team team = new Team("CSKA", blue, orange);
//        Team team1 = new Team("Levski", blue, green);
//
//        em.persist(team);
//        em.persist(team1);
//        em.getTransaction().commit();
    }
}
