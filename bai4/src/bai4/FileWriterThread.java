package bai4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

// Kế thừa lớp Thread
public class FileWriterThread extends Thread {
    private String fileName;

    // Constructor nhận tên tệp tin cần viết
    public FileWriterThread(String fileName) {
        this.fileName = fileName;
    }

    // Phương thức run sẽ ghi dãy số ngẫu nhiên vào tệp tin
    @Override
    public void run() {
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(200); // Tạo số ngẫu nhiên từ 0 đến 99
                writer.write(randomNumber + "");
                System.out.println( Thread.currentThread().getName() + " da ghi: " + randomNumber + " vao tep " + fileName);
                Thread.sleep(500); // Ngủ 500ms để mô phỏng công việc
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Tạo 3 đối tượng FileWriterThread, mỗi đối tượng viết vào một tệp tin khác nhau
        FileWriterThread thread1 = new FileWriterThread("file1.txt");
        FileWriterThread thread2 = new FileWriterThread("file2.txt");
        FileWriterThread thread3 = new FileWriterThread("file3.txt");

        // Chạy 3 đối tượng trên 3 tiến trình (thread) khác nhau
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
