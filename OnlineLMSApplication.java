import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class OnlineLMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineLMSApplication.class, args);
    }
}

@RestController
class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String getCourses(@RequestParam String category) {
        return courseService.getCoursesByCategory(category);
    }
}

@Service
class CourseService {

    public String getCoursesByCategory(String category) {
        // Logic for fetching courses based on category
        return "List of courses for category: " + category;
    }
}
