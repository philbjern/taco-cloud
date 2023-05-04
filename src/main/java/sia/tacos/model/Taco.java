package sia.tacos.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class Taco {

    @NotNull
    @Size(min=5, message="Nazwa musi składać się z przynajmniej pięciu znaków.")
    private String name;

    @NotNull(message = "Musisz wybrać przynajmniej jeden składnik.")
    @Size(min=1, message="Musisz wybrać przynajmniej jeden składnik.")
    private List<String> ingredients;

}
