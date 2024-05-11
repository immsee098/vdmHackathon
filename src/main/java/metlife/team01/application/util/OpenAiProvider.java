package metlife.team01.application.util;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.ai.openai.models.ChatResponseMessage;
import com.azure.core.credential.AzureKeyCredential;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OpenAiProvider {
    private String openaiKey = "05ff7fed90d04e27a5a0887f0d81b0f9";
    private String endpoint = "https://oai-metlife-team001.openai.azure.com/";
    private String deploymentOrModelId = "gpt4-metlife-team01";

    public String request(String contents, String twoDepth) {

        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(openaiKey))
                .endpoint(endpoint)
                .buildClient();

        List<ChatRequestMessage> prompt = new ArrayList<>();
        prompt.add(new ChatRequestUserMessage(String.format("질문은 아래와 같아. 질문은 %s 중 어떤 카테고리일까? 명시한 카테고리 내에서만 대답해줘. \n %s", twoDepth, contents)));

        ChatCompletions chatCompletions = client.getChatCompletions(deploymentOrModelId,
                new ChatCompletionsOptions(prompt));

        return chatCompletions.getChoices().stream()
                .map(ChatChoice::getMessage)
                .map(ChatResponseMessage::getContent)
                .collect(Collectors.joining("\n"));
    }
}
