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
public class FileReaderThread1 extends Thread {
    private String fileName;
    private final Object lock;

    public FileReaderThread1(String fileName, Object lock) {
        this.fileName = fileName;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Reader " + Thread.currentThread().getName() + " doc: " + line);
                }
                System.out.println("Hoan thanh viec doc tu file: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
