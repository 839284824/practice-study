package practice;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Stu extends People {
    @Override
   public String chat(String string) {
        return "i am stu";
    }
}