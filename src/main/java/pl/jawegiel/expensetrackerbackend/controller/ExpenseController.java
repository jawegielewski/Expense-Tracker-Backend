package pl.jawegiel.expensetrackerbackend.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jawegiel.expensetrackerbackend.model.Expense;
import pl.jawegiel.expensetrackerbackend.service.ExpenseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/get-expenses")
    public List<Expense> getExpenses() {
        return expenseService.findAll();
    }

    @PostMapping("/save-expense")
    public ResponseEntity<String> saveCoach(@Valid @RequestBody Expense expense) {
        expenseService.save(expense);
        return ResponseEntity.ok("Expense saved successfully");
    }
}