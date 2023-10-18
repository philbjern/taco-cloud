package sia.rector.fun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void createAFlux_just() {
		Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
		fruitFlux.subscribe(
				f -> System.out.println("Here's some fruit: " + f)
		);
	}

}
