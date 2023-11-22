import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        init();
        testOriginalData();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "data/students.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào studentManager để quản lý.

                Gợi ý:
                Các đội tượng Student không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Student newStudent = new Student.StudentBuilder(id).
                    .withLastname(lastname)
                    .withFirstname(firstname)
                    ...
                    .build();
                */
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    /**
     * Phương thức test dữ liệu đọc được từ file dữ liệu.
     */
    public static void testOriginalData() {
        List<Student> studentList =  studentManager.getStudentList();
        studentManager.print(studentList);
    }

    /**
     * Phương thức test dữ liệu được sắp xếp theo tên
     * (đầu tiên so sánh tên, sau đó đến họ).
     */
    public static void testSortStudentByName() {
        studentManager.sortStudentByName();
    }

    /**
     * Phương thức test dữ liệu được sắp xếp tăng dần theo điểm
     * (đầu tiên so sánh điểm trung bình, sau đó đến điểm toán).
     */
    public static void testSortStudentByGradeIncreasing() {
        /* TODO */
    }

    /**
     * Phương thức test dữ liệu được sắp xếp giảm dần theo điểm
     * (đầu tiên so sánh điểm trung bình, sau đó đến điểm toán).
     */
    public static void testSortStudentByGradeDecreasing() {
        /* TODO */
    }

    /**
     * Phương thức test dữ liệu được lọc theo điểm cao nhất
     * (đầu tiên so sánh điểm trung bình, sau đó đến điểm toán).
     */
    public static void testFilterStudentsHighestGrade() {
        /* TODO */
    }

    /**
     * Phương thức test dữ liệu được lọc theo điểm thấp nhất.
     * (đầu tiên so sánh điểm trung bình, sau đó đến điểm toán).
     */
    public static void testFilterStudentsLowestGrade() {
        /* TODO */
    }
}
