import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student = new Student("Petya");
        student.addGrade(5);
        System.out.println(student);
    }
}

@ToString
@EqualsAndHashCode
class Student {

    @Getter
    @Setter
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    @SneakyThrows
    public void addGrade(int grade) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:5352/checkGrade?grade=" + grade);
        CloseableHttpResponse httpResponse = httpClient.execute(request);
        HttpEntity entity = httpResponse.getEntity();
        if (!Boolean.parseBoolean(EntityUtils.toString(entity))) {
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        grades.add(grade);
    }

    @SneakyThrows
    public int raiting() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:5352/educ?sum=" + grades.stream().mapToInt(x -> x).sum());
        CloseableHttpResponse httpResponse = httpClient.execute(request);
        HttpEntity entity = httpResponse.getEntity();
        return Integer.parseInt(EntityUtils.toString(entity));
    }
}


class Tests {
    @BeforeAll
    public static void mockServer() {
        WireMockServer server = new WireMockServer();
        server.start();
        configureFor("localhost", 5352);
        stubFor(get(urlEqualTo("/checkGrade")).willReturn(aResponse().withBody("true")));
    }

    @ParameterizedTest(name = "Корректные оценки добавляются")
    @MethodSource("Generators#positiveGradeGenerator")
    public void testCorrectGrades(int x) throws IOException {
        Student s = new Student("Petya");
        s.addGrade(x);
        Assertions.assertEquals(x, s.getGrades().get(0));
    }

    @ParameterizedTest(name = "Некорректные оценки не добавляются")
    @MethodSource("Generators#negativeGradeGenerator")
    public void testIncorrectGrades(int x) {
        Student s = new Student("Petya");
        Assertions.assertThrows(IllegalArgumentException.class, () -> s.addGrade(x));
    }
}

class Generators {
    public static Stream<Integer> negativeGradeGenerator() {
        return Stream.of(-1, 1, 6, Integer.MAX_VALUE);
    }

    public static Stream<Integer> positiveGradeGenerator() {
        return Stream.of(2, 3, 4, 5);
    }
}