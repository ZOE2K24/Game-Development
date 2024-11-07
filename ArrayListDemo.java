import java.util.*;

class ArrayListDemo {
    public static void main(String[] args) {
        //ArrayList

        //int[] newArray = new int[5];
        List<String> list_Strings = new ArrayList<String>();
        int size = list_Strings.size();
        // 0
        list_Strings.add("Red");
        list_Strings.add("Green");
        list_Strings.add("Orange");

        list_Strings.add(0, "White");
        list_Strings.add(3, "Black");
        
        System.out.println(list_Strings);

        list_Strings.set(2, "Yellow");

        //list_Strings.remove(2);

        System.out.println(list_Strings);
        Collections.sort(list_Strings);

        System.out.println(list_Strings);

        List<Integer> list_Integers = new ArrayList<Integer>();

        list_Integers.add(3);
        list_Integers.add(5);
        list_Integers.add(1);
        list_Integers.add(8);
        Collections.sort(list_Integers);

        System.out.println(list_Integers);

        Collections.reverse(list_Integers);

        System.out.println(list_Integers);


    }
}