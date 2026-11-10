package pl.jawegiel.expensetrackerbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tbl_expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 3, max = 50, message = "Last name must be of length between 3-50")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    @Digits(integer = 6, fraction = 2, message = "Price format must be up to 6 digits and 2 decimals")
    private BigDecimal price;


    @Column(name = "date_millis")
    @Min(value = 1000000000000L, message = "Must be exactly 13 digits")
    @Digits(integer = 13, fraction = 0, message = "Must be exactly 13 digits")
    private String dateMillis;
}