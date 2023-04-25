package requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.*;

public class Request {

    public Request() {
        originalAnswer = "idk";
    }

    private String originalAnswer;

    public String interpret(String text) throws PatternSyntaxException {
        String matches = "";
        Matcher m = Pattern.compile("answer\":\"(.*)\",\"question").matcher(text);
        if (m.find()) {
            originalAnswer = m.group(1);
        }
        m = Pattern.compile("question\":\"(.*)\",\"value").matcher(text);
        if (m.find()) {
            matches = m.group(1);
        }
        return matches;
    }

    public String getAQuestion() throws IOException {
        URL url = new URL("http://jservice.io/api/random");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return interpret(content.toString());
    }

    public String getOriginalAnswer() {
        return originalAnswer;
    }
}
