package hwhwhw.answer;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private String answerText;

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
