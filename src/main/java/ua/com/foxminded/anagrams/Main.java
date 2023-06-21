package ua.com.foxminded.anagrams;

public class Main {
    
    private static Anagram anagram = new Anagram();
    
    public void setAnagram(Anagram anagram) {
        Main.anagram = anagram;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg + " => " + anagram.makeAnagrams(arg));
        }
    }
}
