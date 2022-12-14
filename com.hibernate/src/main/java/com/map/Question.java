package com.map;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @Column(name="question_id")
    private int questionId;
    private String question;

    @OneToMany(mappedBy = "q",fetch = FetchType.EAGER,cascade = CascadeType.ALL)///FetchType.LAZY)
    // we can use this to set fetch type as eager/lazy
    private List<Answer>li;


    /*@OneToOne
    @JoinColumn(name="a_id")
    private Answer answer;*/

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

   /* public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }*/

    public List<Answer> getLi() {
        return li;
    }

    public void setLi(List<Answer> li) {
        this.li = li;
    }

    /*public Question(int questionId, String question){//, Answer answer) {
        super();
        this.questionId = questionId;
        this.question = question;
       // this.answer = answer;
    }*/

    public Question(int questionId, String question, List<Answer> li) {
        this.questionId = questionId;
        this.question = question;
        this.li = li;
    }

    public Question() {
        super();
    }
}
