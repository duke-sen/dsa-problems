package strings;

/*
Referred from here : https://medium.com/nerd-for-tech/concept-of-string-pool-and-string-object-creation-in-java-27ed2b3089f5
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("Java");

        String s2 = s1;
        System.out.println(s2 == s1); // true

        String s3 = "Java";
        System.out.println(s3 == s1); // false
        System.out.println(s3 == s2); // false

        String s4 = "Program";
        String s5 = s4;

        String s6 = new String(s5);
        System.out.println(s5 == s4); // true
        System.out.println(s6 == s5); // false

        s1 = "Python";
        System.out.println(s2 == s1); // false

        s1.concat("JavaScript");
        System.out.println(s6 == s5); // false

        System.out.println("==================");

        String s9 = new String("Duke");
        String s10 = "Duke";

        System.out.println(s9 == s10); // false
        s9 = s9.intern();
        System.out.println(s9 == s10);
    }
}
