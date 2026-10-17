package mock;

import com.gp.beershop.dto.Beer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class BeerMock {
    private BeerMock() {
    }

    private static Map<Long, Beer> beerMap = new HashMap<>() {{
        put(1L, Beer.builder()
            .id(1L)
            .type("light")
            .inStock(true)
            .name("Lidskoye")
            .description("The best beer by grandmother's recipes")
            .alcohol(5.0)
            .density(11.5)
            .country("Republic of Belarus")
            .price(BigDecimal.valueOf(5).setScale(2)).build());
        put(2L, Beer.builder()
            .id(2L)
            .type("dark")
            .inStock(true)
            .name("Alivaria")
            .description("The No. 1 beer in Belarus")
            .alcohol(4.6)
            .density(10.2)
            .country("Republic of Belarus")
            .price(BigDecimal.valueOf(3).setScale(2)).build());
        put(3L, Beer.builder()
            .id(3L)
            .type("pale lager")
            .inStock(true)
            .name("Pilsner Urquell")
            .description("unpasteurized")
            .alcohol(4.2)
            .density(12.0)
            .country("Czechia")
            .price(BigDecimal.valueOf(8).setScale(2)).build());
        put(4L, Beer.builder()
            .id(4L)
            .type("light")
            .inStock(true)
            .name("Krynitsa Pilsner")
            .description("A mellow beer with a clean, harmonious taste, " +
                         "a sparkling golden color and a thick snow-white head. " +
                         "This variety will appeal to those looking for a light beer, " +
                         "preserving a fresh bouquet of aromatic hops and a delicate " +
                         "bitterness on the finish.")
            .alcohol(4.4)
            .density(10.5)
            .country("Republic of Belarus")
            .price(BigDecimal.valueOf(3.2).setScale(2)).build());
        put(5L, Beer.builder()
            .id(3L)
            .type("pale lager")
            .inStock(false)
            .name("Pilsner Urquell Extra")
            .description("unpasteurized")
            .alcohol(4.5)
            .density(12.2)
            .country("Czechia")
            .price(BigDecimal.valueOf(8.3).setScale(2)).build());
        put(6L, Beer.builder()
            .id(4L)
            .type("light")
            .inStock(true)
            .name("Krynitsa Pilsner")
            .description("A mellow beer with a clean, harmonious taste, " +
                         "a sparkling golden color and a thick snow-white head. " +
                         "This variety will appeal to those looking for a light beer, " +
                         "preserving a fresh bouquet of aromatic hops and a delicate " +
                         "bitterness on the finish.")
            .alcohol(4.4)
            .density(10.5)
            .country("Republic of Belarus")
            .price(BigDecimal.valueOf(5.2).setScale(2)).build());
    }};

    public static Beer getById(final Long id) {
        return beerMap.get(id);
    }
}
