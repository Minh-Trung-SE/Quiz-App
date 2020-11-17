import java.io.File;
import java.util.Scanner;

class Examiner {
    private String nameExaminer;
    private String passWord;

//    abstract viod logIn(); /*extend method*/
//    abstract void updateQuestion();
//    abstract void showResultQuizzes();
//    abstract viod filterResultQuizzes();
//    abstract viod deleteResultQuizzes();

    public void updateQuestion(){
        //Format file example: CSS_Level-1_Question
        //Check file question exits
        //If files exits show question edit question
        //If no created file contain list questions

//        File fileQuestion = new File();

        //Created file contain list questions
        String idQuestion;
        String question;
        String answerA;
        String answerB;
        String answerC;
        String answerD;
        String keyAnswer;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID Question: ");
        idQuestion = sc.nextLine();
        System.out.println("Input detail Question: ");
        question = sc.nextLine();
        System.out.println("Input answer A: ");
        answerA = sc.nextLine();
        System.out.println("Input answer B: ");
        answerB = sc.nextLine();
        System.out.println("Input answer C: ");
        answerC = sc.nextLine();
        System.out.println("Input answer D: ");
        answerD = sc.nextLine();
        System.out.println("Input key answer: ");
        keyAnswer = sc.nextLine();
        Question listQuestion = new Question(idQuestion, question, answerA, answerB, answerC, answerD, keyAnswer);
    }

    public Examiner(String nameExaminer, String passWord) {
        this.nameExaminer = nameExaminer;
        this.passWord = passWord;
    }

    public void updateExaminer(){
        //File array list store user name and password;
        // add Examiner
        // edit Examiner
        // delete Examiner

        String nameExaminer;
        String passWord;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name of Examiner: ");
        nameExaminer = scanner.nextLine();
        System.out.println("Input password of Examiner: ");
        passWord = scanner.nextLine();
        Examiner examiner = new Examiner(nameExaminer, passWord);
    }

    public void logIn (){
        //Read file
        //Loop check logIn
    }

}
