import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseDAOTest {

    @Test
    void testFindById() {
        CourseDAO courseDAO = mock(CourseDAO.class);
        Course course = new Course(1, "Java Basics");
        when(courseDAO.findById(1)).thenReturn(course);

        Course result = courseDAO.findById(1);
        assertEquals("Java Basics", result.getName());
    }

    @Test
    void testFindAll() {
        CourseDAO courseDAO = mock(CourseDAO.class);
        List<Course> courses = List.of(new Course(1, "Java Basics"));
        when(courseDAO.findAll()).thenReturn(courses);

        List<Course> result = courseDAO.findAll();
        assertEquals(1, result.size());
    }
}
