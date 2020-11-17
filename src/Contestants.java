import java.util.ArrayList;

abstract class Contestants {
    private String nameContestants;
    private ArrayList<String> answerQuizzes;

    abstract String selectKindOfQuestion();
    abstract int selectLevelQuestion();
    abstract void showQuestionToTest();
    abstract ArrayList inputQuestion();
    abstract void showResult();
    abstract void saveResult();
}
