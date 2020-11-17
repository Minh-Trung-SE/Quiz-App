abstract class Examiner {
    private String nameExaminer;
    private String passWord;

    abstract viod logIn(); /*extend method*/
    abstract void updateQuestion();
    abstract void editQuestion();
    abstract viod showResultQuizzes();
    abstract viod filterResultQuizzes();
    abstract viod deleteResultQuizzes();
}
