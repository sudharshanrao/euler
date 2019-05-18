package leetcode;
class Palindrome {
    public static boolean isPalindrome(String s) {
        if(s == null){ 
            return false;
        }
        if(s.length() == 0){
            return true;
        }            
        char[] chArray = s.toCharArray();
        
        int low = 0;
        int high = chArray.length - 1;
        while(low < high){
            if(!Character.isLetterOrDigit(chArray[low])){
                low++;
                continue;
            }
            if(!Character.isLetterOrDigit(chArray[high])){
                high--;
                continue;
            }
            char leftCh = Character.toLowerCase(chArray[low++]);
            char rightCh = Character.toLowerCase(chArray[high--]);
            if(leftCh != rightCh){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	System.out.println(isPalindrome(""));
    	
    	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}