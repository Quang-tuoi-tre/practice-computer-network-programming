/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 *
 * @author honha
 */
public class FileWriterThread1 extends Thread {
     private String fileName;
    private final Object lock;

    public FileWriterThread1(String fileName, Object lock) {
        this.fileName = fileName;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try (FileWriter writer = new FileWriter(fileName, true)) { // true: append to file
                Random random = new Random();
                for (int i = 0; i < 10; i++) {
                    int randomNumber = random.nextInt(100);
                    writer.write(randomNumber + "");
                    System.out.println("Writer " + Thread.currentThread().getName() + " ghi: " + randomNumber);
                    Thread.sleep(500);
                }
                System.out.println("Hoan thanh viec ghi vao file: " + fileName);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
