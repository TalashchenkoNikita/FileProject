package homework;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        List<People> peopleList = Arrays.asList(new People("Вася", 16, People.Sex.MAN),
                new People("Елена", 42, People.Sex.WOMAN),
                new People("Иван Иванович", 69, People.Sex.MAN));
        Path outputDir = Path
                .of("C:\\Users\\HP\\IdeaProjects\\FileProject\\output");
        Path result = Path
                .of("C:\\Users\\HP\\IdeaProjects\\FileProject\\output\\result.cvs");
        String file = "C:\\Users\\HP\\IdeaProjects\\FileProject\\picture";
        String URL = "https://upload.wikimedia.org/wikipedia/ru/thumb/3/39/Java_logo.svg/1200px-Java_logo.svg.png";
        FileUtils.createDirectory(outputDir);
        FileUtils.createFile(result);
        FileUtils.inputDataOfPeople(result, peopleList);
        FileUtils.downloadPicture(URL, file);
        System.out.println(URL.substring(URL.lastIndexOf(".")));
    }
}