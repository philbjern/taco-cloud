package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tacos.data.IngredientsRepository;
import tacos.data.UserRepository;
import tacos.model.Ingredient;
import tacos.model.User;

import static tacos.model.Ingredient.Type;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientsRepository ingredientsRepo, UserRepository userRepo) {
		return args -> {
			ingredientsRepo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
			ingredientsRepo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
			ingredientsRepo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
			ingredientsRepo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
			ingredientsRepo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
			ingredientsRepo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
			ingredientsRepo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
			ingredientsRepo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
			ingredientsRepo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
			ingredientsRepo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

			userRepo.save(new User("user", "$2a$10$ROojOvHLrHFNWlmuaM90VuwUhlunQpLyn.7ZokCx1y9Q3wNFBQHky",
					"Bob Krasinsky", "Sunny Blvd. 25", "Los Angeles", "California", "CA",
					"1234567890"));

		};
	}

}
