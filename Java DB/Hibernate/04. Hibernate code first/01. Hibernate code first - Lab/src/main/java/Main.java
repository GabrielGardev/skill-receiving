import ingredients.AmmoniumChloride;
import ingredients.BasicIngredient;
import ingredients.Mint;
import ingredients.Nettle;
import shampoos.BasicLabel;
import shampoos.BasicShampoo;
import shampoos.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("shampoo_company");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();

        BasicLabel basicLabel =
                new BasicLabel("Fresh Nuke Shampoo", "Contains mint and nettle");

        BasicShampoo shampoo = new FreshNuke(basicLabel);

        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(am);
        entityManager.persist(shampoo);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
