package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("박하민");
        helloLombok.setAge(23);

        String name = helloLombok.getName();
        int age = helloLombok.getAge();

        System.out.println("helloLombok = " + helloLombok);
    }
}
