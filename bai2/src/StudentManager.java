import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager implements MyStudentComparator {
    private List<Student> studentList;

    public StudentManager() {
        this.studentList = new LinkedList<>();
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        if(index < 0 || index > limit){
            return false;
        }
        return true;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index, chỉ thêm vào nếu index có giá trị
     * nằm trong đoạn từ [0 - length], trong đó length là số sinh viên trong danh sách hiện tại.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        if(checkBoundaries(index, studentList.size()) == true){
            studentList.add(index, student);
        }
    }

    /**
     * Xóa sinh viên ở vị trí index, chỉ xóa được nếu index nằm trong đoạn [0 - (length - 1)],
     * trong đó length là số sinh viên trong danh sách hiện tại.
     * @param index
     */
    public void remove(int index) {
        if(checkBoundaries(index, studentList.size()) == true){
            studentList.remove(index);
        }
    }

    /**
     * Lấy ra sinh viên ở vị trí index.
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        if(checkBoundaries(index, studentList.size()) == true){
           return studentList.get(index);
        }
        return null;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên và sau đó đến họ.
     * @return
     */
    public List<Student> sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int compareResult = o1.getFirstname().compareTo(o2.getFirstname());
                if (compareResult == 0) {
                    // Nếu tên giống nhau, so sánh theo họ
                    compareResult = o1.getLastname().compareTo(o2.getLastname());
                }
                return compareResult;
            }
    });

        return studentList;
    }


    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeIncreasing() {

        Collections.sort(studentList, this::compare);
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự giảm dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeDecreasing() {
        Collections.sort(studentList, Collections.reverseOrder(this::compare));

        return studentList;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả tốt nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestGrade(int howMany) {
        Collections.sort(studentList, Collections.reverseOrder(this::compare));

        // Limit the list to contain at most howMany students
        List<Student> filteredList = studentList.stream()
                .limit(howMany)
                .collect(Collectors.toList());

        return filteredList;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả thấp nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestGrade(int howMany) {
        Collections.sort(studentList, this::compare);

        // Limit the list to contain at most howMany students
        List<Student> filteredList = studentList.stream()
                .limit(howMany)
                .collect(Collectors.toList());

        return filteredList;
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }

    @Override
    public int compare(Student left, Student right) {
        return 0;
    }
}
