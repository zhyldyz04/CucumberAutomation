package jsonEntities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyTest {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue("json", Person.class);
        person.getSiblings().get(0).getName();

    }

}
