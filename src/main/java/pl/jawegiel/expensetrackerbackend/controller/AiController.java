package pl.jawegiel.expensetrackerbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jawegiel.expensetrackerbackend.service.AiService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping({"/best-gas-station/{city}"})
    public ResponseEntity<?> ask(@PathVariable String city) {
        try {
            return ResponseEntity.ok(aiService.getCheapestGasStation(city));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (IllegalStateException ex) {
            return ResponseEntity.status(502).body(Map.of("error", ex.getMessage()));
        }
    }
}
