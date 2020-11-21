import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Contestants implements Serializable {
    private String nameContestants;
    private String result;
    private float score;

    public Contestants() {}

    public Contestants(String nameContestants, String result, float score) {
        this.nameContestants = nameContestants;
        this.result = result;
        this.score = score;
    }

    //    abstract String selectKindOfQuestion();
//    abstract int selectLevelQuestion();
//    abstract void showQuestionToTest();
//    abstract ArrayList inputQuestion();
//    abstract void showResult();
//    abstract void saveResult();
    public String inputNameContestant(){
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Input your name here! ");
        name = scanner.nextLine();
        return name;
    }

    public void showQuestionToTest(String patchFile){
        FileData fileData = new FileData();
        ArrayList<Question> listQuestion = fileData.readFilesQuestion(patchFile);
        for(Question q: listQuestion){
            System.out.println(q.showQuestion());
        }
    }

    public String[] inputQuestion(){
//        int size;
//        size = length;
        Scanner sc = new Scanner(System.in);
        String answer;
        System.out.println("Input answer in here: ");
        System.out.println("Example: ");
        System.out.println("1.A, 2.B, 3.C");
        answer = sc.nextLine();
        answer = answer.toUpperCase();
        String[] arrOfAnswer = answer.split("[ ,]+");
//        for(String an: arrOfAnswer){
//            System.out.println(an);
//        }
        return arrOfAnswer;
    }

    public float handleScore(String patchFile,String[] answerInput){
        FileData file = new FileData();
        String[] answer = file.getAnswerFromFileQuestion(file.readFilesQuestion(patchFile));
        String[] answerIn = answerInput;
        float score;
        int totalQuestion = answer.length;
        int countTrueQuestion = 0;

        for(int i = 0; i < answer.length; i++){
            try {
                if (answer[i].equalsIgnoreCase(answerIn[i])) {
                    countTrueQuestion = countTrueQuestion + 1;
                }
            }catch (IndexOutOfBoundsException e){
                break;
            }

        }
        score = (float)(countTrueQuestion) / (float)(totalQuestion) * 10;
        return score;
    }

    public String showCorrectAnswer(String patchFile,String[] answerInput){
        FileData file = new FileData();
        String[] answer = file.getAnswerFromFileQuestion(file.readFilesQuestion(patchFile));
        String[] answerIn = answerInput;
        String result;
        result = "Answer Correct: ";
        for (int i = 0; i < answer.length; i++){
            result = result + answer[i] + " ";
        }
        result = result+ "\nAnswer Input  : ";
        for (int i = 0; i < answerIn.length; i++){
            result = result + answerIn[i] + " ";
        }
        return result;
    }

    public void saveResult(String nameContestants, String result, float score, String choseQuestion){
        ArrayList<Contestants> resultArray = new ArrayList<Contestants>();
        String patchFile = choseQuestion;
        patchFile = "D:\\Quizz App\\Result\\"+ patchFile + ".txt";
        FileData fileData = new FileData();
        resultArray = fileData.readFileResult(patchFile);
        Contestants contestants = new Contestants(nameContestants, result, score);
        resultArray.add(contestants);
        fileData.saveFileResult(patchFile, resultArray);
    }

    @Override
    public String toString() {
        return  "Name: " + nameContestants +
                "\nScore: " + score +
                "\nResult: " + result + "\n";
    }

    public String getNameContestants() {
        return nameContestants;
    }

    public void setNameContestants(String nameContestants) {
        this.nameContestants = nameContestants;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
