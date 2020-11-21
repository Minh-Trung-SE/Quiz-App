
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        byte selection;
        byte selectionLogin;
        byte selectionUser;
        float score;
        String result;
        String[] answer;
        String nameContestants;
        String nameFile;
        Scanner sc = new Scanner(System.in);
        Examiner examiner = new Examiner();
        FileData fileData = new FileData();
        Contestants contestants = new Contestants();
        while (true){
            System.out.println("1. Admin");
            System.out.println("2. Use");
            System.out.println("0. Exit");
            System.out.print("Input selection: ");
            try {
                selection = sc.nextByte();
            }catch (Exception e){
                System.out.println("Input invaluable Exit");
                selection = 0;
            }

            switch (selection){
                case 1:
                    examiner.logIn();
                    while (true){
                        System.out.println("1. Create file question");
                        System.out.println("2. View result quiz");
                        System.out.println("3. Show max result");
                        System.out.println("4. Show min result");
                        System.out.println("5. Add admin");
                        System.out.println("0. Exit");
                        System.out.print("Input selection: ");
                        try {
                            selectionLogin = sc.nextByte();
                        }catch (Exception e){
                            System.out.println("Input invaluable Exit");
                            selectionLogin = 0;
                        }
                        switch (selectionLogin){
                            case 1:
                                examiner.addFileQuestion();
                                break;
                            case 2:
                                examiner.showResult();
                                break;
                            case 3:
                                examiner.getMaxResult();
                                break;
                            case 4:
                                examiner.getMinResult();
                                break;
                            case 5:
                                examiner.addExaminer();
                                break;
                            default:
                                break;
                        }
                        if (selectionLogin == 0){
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true){
                        System.out.println("Begin");
                        nameContestants = contestants.inputNameContestant();
                        nameFile = fileData.selectionNameFile();
                        contestants.showQuestionToTest(fileData.setPatchFile(nameFile));
                        answer = contestants.inputQuestion();
                        score = contestants.handleScore(fileData.setPatchFile(nameFile),answer);
                        result = contestants.showCorrectAnswer(fileData.setPatchFile(nameFile), answer);

                        while (true){
                            System.out.println("Finish Quiz!");
                            System.out.println("1. Show score");
                            System.out.println("2. Do quiz again");
                            System.out.println("3. Show correct answer");
                            System.out.println("4. Save result");
                            System.out.println("0. Exit");
                            try {
                                selectionUser = sc.nextByte();
                            }catch (Exception e){
                                System.out.println("Input invaluable exit");
                                selectionUser = 0;
                            }
                            switch (selectionUser){
                                case 1:
                                    System.out.println("Score: " + score);
                                    break;
                                case 2:
                                    System.out.println("Attempt Quiz Again!");
                                    break;
                                case 3:
                                    System.out.println(contestants.showCorrectAnswer(fileData.setPatchFile(nameFile), answer));
                                    break;
                                case 4:
                                    contestants.saveResult(nameContestants,result,score,nameFile);
                                    break;
                                default:
                                    break;
                            }

                            if(selectionUser == 0){
                                break;
                            }
                        }
                        break;
                    }
            }
            if(selection == 0){
                System.out.println("Exit program");
                break;
            }
        }

    }
}
