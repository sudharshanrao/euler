package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Map<String, Integer> wordCountMap = new HashMap<>();
        for(String str: magazine){
            if(wordCountMap.containsKey(str)) {
            	int count = wordCountMap.get(str);
            	wordCountMap.put(str, count+1);
            } else {
            	wordCountMap.put(str, 1);
            }
        }
        boolean flag = false;
        for(String str: note){
            if(wordCountMap.containsKey(str)){
            	int count = wordCountMap.get(str);
            	if(count == 0) {
            		flag= true;
            		break;
            	}
            	wordCountMap.put(str, count - 1);
            }
            else {
            	flag= true;
        		break;
            }
        }
        if(flag){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
