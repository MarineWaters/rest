package requests;

import org.apache.logging.log4j.*;

import java.util.Objects;

public class Data {
    public Data() {
        correctAnswers = 0;
        incorrectAnswers = 0;
        originalAnswer = "idk";
    }

    private String originalAnswer;
    private final Logger logger = LogManager.getLogger();
    private int correctAnswers;
    private int incorrectAnswers;

    public void setOriginalAnswer(String orig) {
        originalAnswer = orig;
    }

    public void statistics() {
        logger.info(String.format("Correct answers: %d, incorrect answers: %d.", correctAnswers, incorrectAnswers));
    }

    public void result(String userAnswer) {
        if (!Objects.equals(userAnswer, originalAnswer)) {
            logger.info(String.format("Incorrect answer! Correct answer: %s.", originalAnswer));
            incorrectAnswers++;
        } else {
            logger.info("Correct answer!");
            correctAnswers++;
        }
    }
}
