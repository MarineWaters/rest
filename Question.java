package hwhwhw.question;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String questionText;
    private String originalAnswer;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String text) {
        this.questionText = text;
    }

    public String getOriginalAnswer() {
        return originalAnswer;
    }

    public void setOriginalAnswer(String answer) {
        this.originalAnswer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}