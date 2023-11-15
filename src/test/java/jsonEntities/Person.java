package jsonEntities;

import lombok.Data;

import java.util.List;

@Data
public class Person {

String name;
int age;

String girlFriend;
List<String> nicknames;
List<Person> siblings;

}
