package pe.edu.upc.aaw.demo1_202302_si63.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Ingredient;

import java.util.List;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient,Integer> {

    @Query(value = "select d.name_dessert, sum(i.amount_ingredient) from\n" +
            " dessert d\n" +
            " inner join ingredient i on d.id_dessert= i.id_dessert\n" +
            " group by d.name_dessert", nativeQuery = true)//  nativeQuery = true indica que se utiliza el lenguaje original de sql no jpql
    public List<String[]>amountDessert();

}
