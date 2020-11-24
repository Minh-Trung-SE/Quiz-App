import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Examiner implements Serializable{
    private String username;
    private String password;

    public Examiner() {}

    public Examiner(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

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
            FileOutputStream file = new FileOutputStream(fileData.setPatchFileQuestion(fileData.selectionNameFile()));
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

    public void showResult(){
        FileData fileData = new FileData();

        System.out.println("Selection kind of Question to show result!");
        String patchFile = fileData.selectionNameFile();
        patchFile = "D:\\Quiz App\\Result\\"+ patchFile + ".txt";
        ArrayList<Contestants> arrayListResult = fileData.readFileResult(patchFile);
        System.out.println("\nResult Quizzes:");
        for (Contestants contestants: arrayListResult) {
            System.out.println(contestants.toString());
        }
    }

    public void getMaxResult(){
        String patchFile;
        FileData fileData = new FileData();
        System.out.println("Selection Type Question to find max result!");
        patchFile = fileData.selectionNameFile();
        patchFile = "D:\\Quiz App\\Result\\"+ patchFile + ".txt";
        ArrayList<Contestants> contestants = fileData.readFileResult(patchFile);
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
        System.out.println("Selection Type Question to find min result!");
        patchFile = fileData.selectionNameFile();
        patchFile = "D:\\Quiz App\\Result\\"+ patchFile + ".txt";
        ArrayList<Contestants> contestants = fileData.readFileResult(patchFile);
        Contestants contestants1 = contestants.get(0);
        for (Contestants contestant:
                contestants) {
            if(contestant.getScore() < contestants1.getScore()){
                contestants1 = contestant;
            }
        }
        System.out.println("Min score: ");
        System.out.println(contestants1.toString());
    }

    public void addExaminer(){
        System.out.println("Warning: all old accounts will be disappear and replace by this account.");
        String username;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input username:");
        username = sc.nextLine();
        System.out.println("Input password:");
        password = sc.nextLine();
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Quiz App\\Examiner\\Examiner.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Examiner examiner = new Examiner(username, password);
            objectOutputStream.writeObject(examiner);
            fileOutputStream.close();
            System.out.println("Create user Admin SUCCESS!");
        }catch (Exception e){
            System.out.println("Can't create File Examiner.txt");
        }
    }

    public void logIn() {
        String username;
        String password;
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        FileData fileData = new FileData();
        ArrayList<Examiner> examiners = fileData.readFileExaminer();
        while (loop){
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();
            for (Examiner examiner: examiners) {
                if (username.equals(examiner.getUsername()) && password.equals(examiner.password)){
                    System.out.println("LogIn SUCCESS!");
                    loop = false;
                    break;
                }
            }
        }
    }

    public void editFileQuestion(){
        FileData fileData = new FileData();
        Question question = new Question();
        Question questionAdd;
        String patchFile;
        Scanner sc = new Scanner(System.in);
        byte selection;
        byte number;
        ArrayList<Question> listQuestion = new ArrayList<>();
        while (true){
            patchFile = fileData.setPatchFileQuestion(fileData.selectionNameFile());
            listQuestion = fileData.readFilesQuestion(patchFile);
            while (true){
                System.out.println("1. Add Question");
                System.out.println("2. Delete Question");
                System.out.println("3. Save");
                System.out.println("0. Exit");
                try {
                    selection = sc.nextByte();
                }catch (Exception e){
                    selection = 0;
                }
                while (true){
                    switch (selection){
                        case 1:
                            System.out.println("Input number question to add");
                            while (true){
                                try {
                                    number = sc.nextByte();
                                }catch (Exception e){
                                    number = 0;

                                }
                                break;
                            }
                            for(int i = 0; i < number; i++){
                                System.out.println("Input Question " + (i + 1) +": ");
                                questionAdd = question.addQuestion();
                                listQuestion.add(questionAdd);
                            }
                            for (Question q: listQuestion){
                                System.out.println(q.toString());
                            }
                            break;
                        case 2:
                            System.out.println("Input index question to delete");
                            while (true){
                                try {
                                    number = sc.nextByte();
                                    number = (byte) (number - 1);
                                    if(number < 0){
                                        break;
                                    }
                                }catch (Exception e){
                                    number = 0;

                                }
                                listQuestion.remove(number);
                                break;
                            }
                            break;
                        case 3:
                            fileData.saveFileQuestion(patchFile, listQuestion);
                            break;
                        default:
                            break;
                    }
                    System.out.println("1. Add Question");
                    System.out.println("2. Delete Question");
                    System.out.println("3. Save");
                    System.out.println("0. Exit");
                    try {
                        selection = sc.nextByte();
                    }catch (Exception e){
                        selection = 0;
                    }
                    if (selection == 0){
                        break;
                    }
                }
                break;
            }

        }
    }

    @Override
    public String toString() {
        return "Examiner{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
