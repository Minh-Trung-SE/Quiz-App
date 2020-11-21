import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Examiner {
    private String nameExaminer;
    private String passWord;

    public Examiner() {

    }

//    abstract void logIn(); /*extend method*/
//    abstract void updateQuestion();
//    abstract void showResultQuizzes();
//    abstract void filterResultQuizzes();
//    abstract void deleteResultQuizzes();

    public void addFileQuestion() {
        String idQuestion;
        String question;
        String answerA;
        String answerB;
        String answerC;
        String answerD;
        String keyAnswer;
        int choseContinue;

        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose type and level of question to add: ");
        FileData fileData = new FileData();

        try {
            FileOutputStream file = new FileOutputStream(fileData.setPatchFileQuestion(fileData.selectionKindOfQuestion()));
            ObjectOutputStream writeQuestion = new ObjectOutputStream(file);
            while (true) {
                System.out.println("Input ID Question: ");
                idQuestion = sc.nextLine();
                idQuestion = idQuestion.toUpperCase();
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
                while (true){
                    System.out.println("Input key answer: ");
                    keyAnswer = sc.nextLine();
                    if(keyAnswer.equalsIgnoreCase("A")){
                        keyAnswer = answerA;
                        break;
                    }
                    if(keyAnswer.equalsIgnoreCase("B")){
                        keyAnswer = answerB;
                        break;
                    }
                    if(keyAnswer.equalsIgnoreCase("C")){
                        keyAnswer = answerC;
                        break;
                    }
                    if(keyAnswer.equalsIgnoreCase("D")){
                        keyAnswer = answerD;
                        break;
                    }
                    System.out.println("Input key answer invaluable input key answer again:");
                }
                Question listQuestion = new Question(idQuestion, question, answerA, answerB, answerC, answerD, keyAnswer);
                writeQuestion.writeObject(listQuestion);
                System.out.println("Continue add question Yes = 1 / No = 0? ");
                try {
                    choseContinue = scanner.nextInt();
                }catch (Exception e){
                    System.out.println("Input is a exception default save file and end function");
                    choseContinue = 0;
                }
                if (choseContinue == 0) {
                    writeQuestion.close();
                    file.close();
                    System.out.println("Save SUCCESS!");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred ):");
        }
    }

    public Examiner(String nameExaminer, String passWord) {
        this.nameExaminer = nameExaminer;
        this.passWord = passWord;
    }

    public void showResult(){
        FileData fileData = new FileData();
        ArrayList<Contestants> arrayListResult = new ArrayList<Contestants>();
        System.out.println("Selection kind of Question to show result!");
        String patchFile = fileData.selectionKindOfQuestion();
        patchFile = "D:\\Quizz App\\Result\\"+ patchFile + ".txt";
        arrayListResult = fileData.readFileResult(patchFile);
        System.out.println("\nResult Quizzes:");
        for (Contestants contestants: arrayListResult) {
            System.out.println(contestants.toString());
        }
    }

    public void getMaxResult(){
        String patchFile;
        FileData fileData = new FileData();
        patchFile = fileData.selectionKindOfQuestion();
        patchFile = "D:\\Quizz App\\Result\\"+ patchFile + ".txt";
        ArrayList<Contestants> contestants = new ArrayList<Contestants>();
        contestants = fileData.readFileResult(patchFile);
        try {
            Contestants contestants1 = contestants.get(0);
            for (Contestants contestant:
                    contestants) {
                if(contestant.getScore() > contestants1.getScore()){
                    contestants1 = contestant;
                }
            }
            System.out.println("Max score: ");
            System.out.println(contestants1.toString());
        }catch (Exception e){
            System.out.println("File not Found");
        }
    }
    public void getMinResult(){
        String patchFile;
        FileData fileData = new FileData();
        patchFile = fileData.selectionKindOfQuestion();
        patchFile = "D:\\Quizz App\\Result\\"+ patchFile + ".txt";
        ArrayList<Contestants> contestants = new ArrayList<Contestants>();
        contestants = fileData.readFileResult(patchFile);
        Contestants contestants1 = contestants.get(0);
        for (Contestants contestant:
                contestants) {
            if(contestant.getScore() < contestants1.getScore()){
                contestants1 = contestant;
            }
        }
        System.out.println("Max score: ");
        System.out.println(contestants1.toString());
    }
    public void updateExaminer() {
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

    public void logIn() {
        //Read file
        //Loop check logIn
    }


}
