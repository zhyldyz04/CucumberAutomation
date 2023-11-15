package jsonEntities;

import lombok.Data;

import java.util.List;
@Data

public class Friend {


    String name;
    int age;
    List<String> nicknames;
}
