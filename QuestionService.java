package hwhwhw.question;

import hwhwhw.question.Question;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.regex.*;

@Service
public class QuestionService {
    public Question getQuestion() throws IOException, URISyntaxException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://jservice.io/api/random"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 400) {
            throw new RuntimeException("Bad request. Type to try again.");
        } else if (response.statusCode() == 500) {
            throw new RuntimeException("Internal server error. Type to try again.");
        }
        Question q = new Question();
        Pair<String,String> QandA = interpret(response.body());
        q.setQuestionText(QandA.a);
        q.setOriginalAnswer(QandA.b);
        return q;
    }

    private Pair<String,String> interpret(String text) throws PatternSyntaxException {
        String question = "";
        String originalAnswer = "";
        Matcher m = Pattern.compile("answer\":\"(.*)\",\"question").matcher(text);
        if (m.find()) {
            originalAnswer = m.group(1);
        }
        m = Pattern.compile("question\":\"(.*)\",\"value").matcher(text);
        if (m.find()) {
            question = m.group(1);
        }
        return new Pair<>(originalAnswer,question);
    }
}
