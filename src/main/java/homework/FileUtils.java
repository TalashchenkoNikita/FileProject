package homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {
    public static void createDirectory(Path path) {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            System.out.println("Directory is already created");
        }
    }

    public static void createFile(Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            System.out.println("File is already created");
        }
    }

    public static void inputDataOfPeople(Path path, List<People> peopleList) throws IOException {
        FileWriter writer = new FileWriter(String.valueOf(path));
        for (People people : peopleList) {
            if (people.getSex().equals(People.Sex.MAN)) {
                writer.write(people.getName() + " " + people.getAge() + " чоловік" + "\n");
            } else {
                writer.write(people.getName() + " " + people.getAge() + " жінка" + "\n");
            }
        }
        writer.close();
    }

    public static File downloadPicture(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        String urlEnding = urlStr.substring(urlStr.lastIndexOf("."));
        if (urlStr.endsWith(".png") || urlStr.endsWith(".jpeg")) {
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(file + urlEnding);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
            return Path.of(file+urlEnding).toFile();
        } else {
            System.out.println("Wrong format of file");
            return null;
        }
    }
}
