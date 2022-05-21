import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest {
    class Teacher{
        public String roll;
        public String name;
        public String date;
        public Integer cake;

        public Teacher(String name, Integer cake) {
            this.name = name;
            this.cake = cake;
        }

        public Teacher(String roll, String name, Integer cake) {
            this.roll = roll;
            this.name = name;
            this.cake = cake;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "roll='" + roll + '\'' +
                    ", name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    ", cake=" + cake +
                    '}';
        }

        public String getRoll() {
            return roll;
        }

        public void setRoll(String roll) {
            this.roll = roll;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getCake() {
            return cake;
        }

        public void setCake(Integer cake) {
            this.cake = cake;
        }
    }

    @Test
    public void countCakeFromFileTXT() throws IOException {
        HashMap<String, Teacher> mapTeacher = new HashMap<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("test.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine()) != null;) {
            // Process line
            String[] splitedLine =  line.split(" ");
            if (splitedLine.length == 4){
                String teacherId = splitedLine[0];
                String name = splitedLine[1];
                int cakeCount = Integer.parseInt(splitedLine[3]);
                Teacher teacher = new Teacher(teacherId, name, cakeCount);
               if (mapTeacher.containsKey(teacher.getRoll())){
                   Teacher oldTeacher = mapTeacher.get(teacher.getRoll());
                   oldTeacher.setCake(oldTeacher.getCake() + teacher.getCake());
                   mapTeacher.put(oldTeacher.getRoll(), oldTeacher);
               }else {
                   mapTeacher.put(teacher.getRoll(), teacher);
               }
            }
        }
        ArrayList<Teacher> listTeacher = new ArrayList<>(mapTeacher.values());
        for (Teacher teacher:
             listTeacher) {
            System.out.println(teacher.toString());
        }
    }

    @Test
    public void run(){

    }
}
