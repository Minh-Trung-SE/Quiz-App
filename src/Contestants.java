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
        Scanner sc = new Scanner(System.in);
        String answer;
        System.out.println("Input answer in here: ");
        System.out.println("Example: ");
        System.out.println("1.A, 2.B, 3.C");
        answer = sc.nextLine();
        answer = answer.toUpperCase();
        return answer.split("[ ,]+");
    }

    public float handleScore(String patchFile,String[] answerInput){
        FileData file = new FileData();
        String[] answer = file.getAnswerFromFileQuestion(file.readFilesQuestion(patchFile));
        float score;
        int totalQuestion = answer.length;
        int countTrueQuestion = 0;

        for(int i = 0; i < answer.length; i++){
            try {
                if (answer[i].equalsIgnoreCase(answerInput[i])) {
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
        StringBuilder result;
        result = new StringBuilder("Answer Correct: ");
        for (String s : answer) {
            result.append(s).append(" ");
        }
        result.append("\nAnswer Input  : ");
        for (String s : answerInput) {
            result.append(s).append(" ");
        }
        return result.toString();
    }

    public void saveResult(String nameContestants, String result, float score, String nameFile){
        ArrayList<Contestants> resultArray;
        String patchFile = nameFile;
        patchFile = "D:\\Quiz App\\Result\\"+ patchFile + ".txt";
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
                "\nResult:\n" + result + "\n";
    }

    public float getScore() {
        return score;
    }

}
