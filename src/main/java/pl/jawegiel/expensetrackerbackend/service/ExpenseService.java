package pl.jawegiel.expensetrackerbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.jawegiel.expensetrackerbackend.model.Expense;
import pl.jawegiel.expensetrackerbackend.repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExpenseService {

    public final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void save(Expense expense) {
        log.info("Adding expense: {}", expense.toString());
        expenseRepository.save(expense);
        log.info("Expense successfully added");
    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> findByName(String name) {
        return expenseRepository.findByName(name);
    }

//    public boolean isCoachFound(Team team) {
//        return team.getCoach() != null;
//    }
}