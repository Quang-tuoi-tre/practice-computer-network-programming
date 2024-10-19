/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4;
import java.io.FileReader;
/**
 *
 * @author honha
 */
public class FileSyncExample {
     public static void main(String[] args) {
        String fileName = "data.txt";
        Object lock = new Object(); // Dùng để đồng bộ hóa giữa tiến trình đọc và viết

        // Tạo đối tượng ghi và đọc dữ liệu trên cùng một file
        FileWriterThread1 writerThread = new FileWriterThread1(fileName, lock);
        FileReaderThread1 readerThread = new FileReaderThread1(fileName, lock);

        // Bắt đầu tiến trình ghi và đọc
        writerThread.start();
        readerThread.start();

        // Đợi cho các tiến trình kết thúc
        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
