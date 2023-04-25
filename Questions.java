package visual;

import requests.*;
import org.apache.logging.log4j.*;

import java.io.IOException;
import java.util.Scanner;

public class Questions {
    private final Scanner in = new Scanner(System.in);
    private final Logger logger = LogManager.getLogger();
    private final Request req = new Request();

    final String newQuestion() throws IOException {
        logger.info(req.getAQuestion());
        return in.nextLine();
    }

    public String original() {
        return req.getOriginalAnswer();
    }
}