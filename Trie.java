
public class Trie {

    static class Node{
        Node[] children = new Node[26];
        boolean eow;

        public Node(){
            for (int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }


public static Node root = new Node();

    static void insert(String word) {// O(n)

        int len = word.length();
        int idx = 0;

        Node curr = root;

        for (int i = 0; i < len; i++){
            idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word){
        int len = word.length();
        int idx = 0;

        Node curr = root;

        for (int i = 0; i < len; i++){
            idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;

    }
    public static void main(String[] args) {
String words[] = {"the" , "a" , "there" , "their" , "any" , "thee"};
for (String word : words){
    insert(word);
}

        System.out.println(search("the"));
        System.out.println(search("their"));
        System.out.println(search("thi"));


    }
}
