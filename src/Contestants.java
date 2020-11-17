import java.util.ArrayList;

abstract class Contestants {
    private String nameContestants;
    private ArrayList<String> answerQuizzes;

    abstract String selectKindOfQuestion();
    abstract int selectLevelQuestion();
    abstract void showQuestionToTest();
    abstract ArrayList inputQuestion();
    abstract viod showResult();
    abstract viod saveResult();
}
