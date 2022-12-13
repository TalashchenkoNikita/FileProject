package homework;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


class FileUtilsTest {
    String file = "C:\\Users\\HP\\IdeaProjects\\FileProject\\picture";
    String URL = "https://upload.wikimedia.org/wikipedia" +
            "/ru/thumb/3/39/Java_logo.svg/1200px-Java_logo.svg.png";

    @Test
    void shouldDownloadPicture() throws IOException {
        assertThat(Objects.requireNonNull(FileUtils.downloadPicture(URL, file)).exists()).isTrue();
    }

    @Test
    void shouldHaveRightFormat() throws IOException {
        File picture = FileUtils.downloadPicture(URL, file);
        assert picture != null;
        assertThat(picture.toString().endsWith(".png")
                ||picture.toString().endsWith("jpeg")).isTrue();
    }

}