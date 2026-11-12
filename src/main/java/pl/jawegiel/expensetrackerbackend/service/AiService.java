package pl.jawegiel.expensetrackerbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AiService {

    private static final String QUERY_MAIN = "Tell me the cheapest gas station in ";

    private final ChatClient chatClient;

    public AiService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getCheapestGasStation(String queryCity) {
        if (queryCity == null || queryCity.isBlank()) {
            throw new IllegalArgumentException("Message is required.");
        }
        String finalCity = queryCity.trim();
        String reply = requestReply(QUERY_MAIN + finalCity);
        log.info("Response from Gemini: {}", reply);
        return reply;
    }

    private String requestReply(String userPrompt) {
        try {
            String reply = chatClient.prompt()
                    .user(userPrompt)
                    .call()
                    .content();

            if (reply == null || reply.isBlank()) {
                throw new IllegalStateException("The AI provider returned an empty response.");
            }
            return reply;
        } catch (RuntimeException ex) {
            log.error("Gemini AI request failed", ex);
            throw new IllegalStateException(
                    "Gemini AI request failed. Check the API key, model availability, and provider quota.",
                    ex
            );
        }
    }
}