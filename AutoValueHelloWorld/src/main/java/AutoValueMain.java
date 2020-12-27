import java.util.*;

public class AutoValueMain {
    public static void main(String[] args) {
        List<MyValue> myValueList = Arrays.asList(MyValue.create("apple", 100), MyValue.create("strawberry", 1), MyValue.create("banana", 3));
        myValueList.stream().forEach(System.out::println);
        System.out.println(myValueList.indexOf(MyValue.create("apple", 100)));

        Set<MyValue> myValueSet = new HashSet<>();
        myValueSet.addAll(myValueList);
        System.out.println(myValueSet.contains(MyValue.create("strawberry", 3)));
        System.out.println(myValueSet.contains(MyValue.create("banana", 3)));
    }
}
