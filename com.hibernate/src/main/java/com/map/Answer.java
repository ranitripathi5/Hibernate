package com.map;


import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name="answer_id")
    private Integer answerId;
    private String answer;

    @ManyToOne
    private Question q;

    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer() {
        super();
    }

    public Answer(Integer answerId, String answer) {
        super();
        this.answerId = answerId;
        this.answer = answer;
    }
}
