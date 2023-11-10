package sia.rector.fun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void createAFlux_just() {
		Flux<String> fruitFlux = Flux
				.just("Apple", "Orange", "Grape", "Banana", "Strawberry");

		fruitFlux.subscribe(
				f -> System.out.println("Here's some fruit: " + f)
		);
	}

	@Test
	void createFlux_fromArrray() {
		String[] fruits = new String[] {
				"Apple", "Orange", "Grape", "Banana", "Strawberry"};

		Flux<String> fruitFlux = Flux.fromArray(fruits);

		StepVerifier.create(fruitFlux)
				.expectNext("Apple")
				.expectNext("Orange")
				.expectNext("Grape")
				.expectNext("Banana")
				.expectNext("Strawberry")
				.verifyComplete();
	}

}
