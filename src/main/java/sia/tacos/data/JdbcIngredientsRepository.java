package sia.tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sia.tacos.model.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientsRepository implements IngredientsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Ingredient findById(String id) {
        return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id);
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type")));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(), ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
