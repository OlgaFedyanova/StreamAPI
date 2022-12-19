package com.example.javaIo;

import java.io.FileWriter;
import java.io.IOException;

public class ExampleFileWriter {
    public static void main(String[] args) {
        String text = "Я помню чудное мгновенье:\n" +
                "Передо мной явилась ты,\n" +
                "Как мимолетное виденье,\n" +
                "Как гений чистой красоты.";

        FileWriter writer;
        try {
        writer = new FileWriter("C\\Users\\Olga\\Desktop\\text.txt");

        for (int i =0; i<text.length(); i++) {
            writer.write(text.charAt(i));
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } //чего здесь не хватает?
    }
}
