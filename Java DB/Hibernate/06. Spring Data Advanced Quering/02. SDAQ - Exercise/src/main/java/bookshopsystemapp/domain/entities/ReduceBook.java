package bookshopsystemapp.domain.entities;

import java.math.BigDecimal;

public interface ReduceBook {
    String getTitle();

    EditionType getEditionType();

    AgeRestriction getAgeRestriction();

    BigDecimal getPrice();
}
