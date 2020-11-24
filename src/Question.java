import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Question implements Serializable {

    private String idQuestion;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String keyAnswer;

    public Question addQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID Question: ");
        String idQuestion = sc.nextLine();
        idQuestion = idQuestion.toUpperCase();
        System.out.println("Input detail Question: ");
        String question = sc.nextLine();
        System.out.println("Input answer A: ");
        String answerA = sc.nextLine();
        System.out.println("Input answer B: ");
        String answerB = sc.nextLine();
        System.out.println("Input answer C: ");
        String answerC = sc.nextLine();
        System.out.println("Input answer D: ");
        String answerD = sc.nextLine();
        while (true) {
            System.out.println("Input key answer: ");
            keyAnswer = sc.nextLine();
            if (keyAnswer.equalsIgnoreCase("A")) {
                keyAnswer = answerA;
                break;
            }
            if (keyAnswer.equalsIgnoreCase("B")) {
                keyAnswer = answerB;
                break;
            }
            if (keyAnswer.equalsIgnoreCase("C")) {
                keyAnswer = answerC;
                break;
            }
            if (keyAnswer.equalsIgnoreCase("D")) {
                keyAnswer = answerD;
                break;
            }
            System.out.println("Input key answer invaluable input key answer again:");
        }
        Question addQuestion = new Question(idQuestion, question, answerA, answerB, answerC, answerD, keyAnswer);
        return addQuestion;
    }

    public Question() {
    }

    public Question(String idQuestion, String question, String answerA, String answerB, String answerC, String answerD, String keyAnswer) {
        this.idQuestion = idQuestion;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.keyAnswer = keyAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getKeyAnswer() {
        return keyAnswer;
    }

    public void setKeyAnswer(String keyAnswer) {
        this.keyAnswer = keyAnswer;
    }


    public String showQuestion() {
        return "ID Question: " + idQuestion +
                "\n" + question +
                "\n\t A: " + answerA +
                "\n\t B: " + answerB +
                "\n\t C: " + answerC +
                "\n\t D: " + answerD;
    }

    @Override
    public String toString() {
        return "ID Question:" + idQuestion +
                "\nQuestion: " + question +
                "\n\t A: " + answerA +
                "\n\t B: " + answerB +
                "\n\t C: " + answerC +
                "\n\t D: " + answerD +
                "\n\t Answer: " + keyAnswer + "\n";
    }
}

