/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author honha
 */
public class FileReaderThread extends Thread {
     private String fileName;

    // Constructor nhận tên tệp tin cần đọc
    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    // Phương thức run() để thực hiện công việc đọc tệp tin
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println( Thread.currentThread().getName() + " doc: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Tạo 3 đối tượng FileReaderThread để đọc từ 3 tập tin khác nhau
        FileReaderThread thread1 = new FileReaderThread("file1.txt");
        FileReaderThread thread2 = new FileReaderThread("file2.txt");
        FileReaderThread thread3 = new FileReaderThread("file3.txt");

        // Chạy 3 tiến trình đồng thời
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
