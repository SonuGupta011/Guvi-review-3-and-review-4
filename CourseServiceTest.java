import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    @Test
    void testGetCourseById() {
        CourseDAO courseDAO = mock(CourseDAO.class);
        Course course = new Course(1, "Java Basics");
        when(courseDAO.findById(1)).thenReturn(course);

        CourseService courseService = new CourseService(courseDAO);
        Course result = courseService.getCourseById(1);
        assertEquals("Java Basics", result.getName());
    }

    @Test
    void testGetAllCourses() {
        CourseDAO courseDAO = mock(CourseDAO.class);
        List<Course> courses = List.of(new Course(1, "Java Basics"));
        when(courseDAO.findAll()).thenReturn(courses);

        CourseService courseService = new CourseService(courseDAO);
        List<Course> result = courseService.getAllCourses();
        assertEquals(1, result.size());
    }
}
