package pl.jawegiel.expensetrackerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jawegiel.expensetrackerbackend.model.Expense;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Optional<Expense> findById(long id);
    Optional<Expense> findByName(String name);
}