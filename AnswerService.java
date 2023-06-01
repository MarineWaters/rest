package hwhwhw.answer;

import hwhwhw.question.Question;
import hwhwhw.user.User;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    public String checkAnswer(User user, Question question, String answerText) {
        boolean correct = answerText.equalsIgnoreCase(question.getOriginalAnswer());
        int rating = correct ? 1 : 0;
        user.setRating(user.getRating()+rating);
        if(rating==0){
            return ("Wrong answer. Correct answer: "+question.getOriginalAnswer());
        }
        else{
            return ("Correct answer.");
        }
    }
}