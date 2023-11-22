import java.util.Comparator;

public interface MyStudentComparator extends Comparator<T> {
    int compare(Student left, Student right);
}
