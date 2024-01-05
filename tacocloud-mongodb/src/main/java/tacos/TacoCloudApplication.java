package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.data.IngredientsRepository;
import tacos.data.TacoRepository;
import tacos.data.UserRepository;
import tacos.model.Ingredient;
import tacos.model.Taco;
import tacos.model.User;

import java.util.Arrays;

import static tacos.model.Ingredient.Type;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientsRepository ingredientsRepo, UserRepository userRepo, PasswordEncoder passwordEncoder,
										TacoRepository tacoRepo) {
		return args -> {
			Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
			Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
			Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
			Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
			Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
			Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
			Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
			Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
			Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
			Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);

			ingredientsRepo.save(flourTortilla);
			ingredientsRepo.save(cornTortilla);
			ingredientsRepo.save(groundBeef);
			ingredientsRepo.save(carnitas);
			ingredientsRepo.save(tomatoes);
			ingredientsRepo.save(lettuce);
			ingredientsRepo.save(cheddar);
			ingredientsRepo.save(jack);
			ingredientsRepo.save(salsa);
			ingredientsRepo.save(sourCream);

			userRepo.save(new User("user", "$2a$10$ROojOvHLrHFNWlmuaM90VuwUhlunQpLyn.7ZokCx1y9Q3wNFBQHky",
					"Bob Krasinsky", "Sunny Blvd. 25", "Los Angeles", "California", "CA",
					"1234567890"));

			Taco taco1 = new Taco();
			taco1.setName("Carnivore");
			taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
			tacoRepo.save(taco1);

			Taco taco2 = new Taco();
			taco2.setName("Bovine Bounty");
			taco2.setIngredients(Arrays.asList(cornTortilla, groundBeef, cheddar, jack, sourCream));
			tacoRepo.save(taco2);

			Taco taco3 = new Taco();
			taco3.setName("Veg-out");
			taco3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
			tacoRepo.save(taco3);
		};
	}

}
