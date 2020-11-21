import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileData {

    public String selectionNameFile(){
            String KindOfQuestion = null;
            String levelOfQuestion = null;
            String patchFile;

            /*Select Question*/
            System.out.println("Select Question: ");
            System.out.println("1: CSS");
            System.out.println("2: Java");
            System.out.println("3: Html");
            System.out.println("4: Python");
            Scanner scanner = new Scanner(System.in);
            int chose;
            /*Handle Exception and Invaluable selection*/
            while (true){
                try {
                    System.out.println("Input selection: ");
                    chose = scanner.nextInt();
                    if(chose >= 1 && chose <= 4){
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Input Invaluable");
                }
            }
            switch(chose){
                case 1:
                    KindOfQuestion = "CSS";
                    break;
                case 2:
                    KindOfQuestion = "JAVA";
                    break;
                case 3:
                    KindOfQuestion = "HTML";
                    break;
                case 4:
                    KindOfQuestion = "PYTHON";
                    break;
            }

            /*Select level Question*/
            System.out.println("Select of level Question: ");
            System.out.println("1: BASIC");
            System.out.println("2: MEDIUM");
            System.out.println("3: HIGH");
            Scanner sc = new Scanner(System.in);
            int selection;
            /*Handle Exception and Invaluable selection*/
            while (true){
                try {
                    System.out.println("Input selection: ");
                    selection = sc.nextInt();
                    if(selection >= 1 && selection <= 3){
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Input Invaluable");
                }
            }

            switch(selection){
                case 1:
                    levelOfQuestion = "BASIC";
                    break;
                case 2:
                    levelOfQuestion = "MEDIUM";
                    break;
                case 3:
                    levelOfQuestion = "HIGH";
                    break;
            }
            patchFile = KindOfQuestion + "-" + levelOfQuestion;
            return patchFile;
    }

    public String setPatchFile(String kindOfQuestion){
        String patchFile = kindOfQuestion;
        patchFile = "D:\\Quiz App\\Question\\"+ patchFile + ".txt";
        return patchFile;
    }

    public ArrayList<Question> readFilesQuestion(String patchFile){
        ArrayList<Question> listQuestion = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(patchFile);
            ObjectInputStream objectQuestion = new ObjectInputStream(file);
            while (file.available() > 0){
                Question question = (Question) objectQuestion.readObject();
                listQuestion.add(question);
            }
            file.close();
        }catch (Exception e){
            System.out.println("An error occurred");
        }
        return listQuestion;
    }

    public String[] getAnswerFromFileQuestion(ArrayList<Question> questionArrayList){
        ArrayList<Question> questions;
        questions = questionArrayList;
        String[] answer = new String[questions.size()];
        for(int i = 0; i < questions.size(); i++){
            Question question = questions.get(i);
            if(question.getAnswerA().equalsIgnoreCase(question.getKeyAnswer())){
                answer[i] = (i+1)+".A";
                continue;
            }
            if(question.getAnswerB().equalsIgnoreCase(question.getKeyAnswer())){
                answer[i] = (i+1)+".B";
            }
            if(question.getAnswerC().equalsIgnoreCase(question.getKeyAnswer())){
                answer[i] = (i+1)+".C";
            }
            if(question.getAnswerD().equalsIgnoreCase(question.getKeyAnswer())){
                answer[i] = (i+1)+".D";
            }
        }
        return answer;
    }

    public ArrayList<Contestants> readFileResult(String patchFile){
        ArrayList<Contestants> resultTest = new ArrayList<>();
        try{
            FileInputStream fileResultInput = new FileInputStream(patchFile);
            ObjectInputStream objectContestants = new ObjectInputStream(fileResultInput);
            while (fileResultInput.available() > 0){
                Contestants contestants = (Contestants) objectContestants.readObject();
                resultTest.add(contestants);
            }
            fileResultInput.close();
        }catch (Exception e){
            System.out.println("No check results");
        }
        return resultTest;
    }

    public void saveFileResult(String patchFile, ArrayList<Contestants> listResult){


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(patchFile);
            ObjectOutputStream writeObject = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < listResult.size(); i++){
                Contestants contestants = listResult.get(i);
                writeObject.writeObject(contestants);
            }
            writeObject.close();
            fileOutputStream.close();
            System.out.println("Save result SUCCESS!");
        }catch (Exception e){
            System.out.println("An error occur");
        }

    }

    public ArrayList<Examiner> readFileExaminer(){
        ArrayList<Examiner> examiners = new ArrayList<Examiner>();
        try {
            FileInputStream fileExaminer = new FileInputStream("D:\\Quiz App\\Examiner\\Examiner.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileExaminer);
            while (fileExaminer.available() > 0){
                Examiner examiner = (Examiner) objectInputStream.readObject();
                examiners.add(examiner);
            }
            fileExaminer.close();
        }catch (Exception e){
            System.out.println("File Examiner.txt Not Found!");
        }
        return examiners;
    }


}


