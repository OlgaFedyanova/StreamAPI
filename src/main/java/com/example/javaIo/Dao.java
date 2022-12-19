package com.example.javaIo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Dao {

    public List<String> method() {
        ClassLoader classLoader = Dao.class.getClassLoader();

        try
                (InputStream inputStream = classLoader.getResourceAsStream("abbreviations.txt")) {

            //Базовый класс InputStream - это абстрактный класс, определяющий входной поток данных, и является родителем для классов,
            // получающих данные из различных источников : массив байтов, строки (String), файлы, каналы.
            // Методы класса InputStream при возникновении ошибки вызывают исключение IOException.

            //теперь inputStream все что в нем лежит нам надо прочитать
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); //читает посимвольно
            //в примере курса было:
//            inputStreamReader.read();
//            while (inputStreamReader.ready()) {
//                s += (char) inChar;
//                inChar = inputStreamReader.read();
//            }
            //однако нам нужно прочитать текст построчно и потом по словам, а у inputStreamReader нет метода который бы читал построчно
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            //дальше мы каждую полученную строку поделим на слова
            //что-то сделаем в этими словами, куда-то их положим
            //возвращаем из метода полученный результат

            return null; //пока нам нечего возвращать, дальше здесь вернем list чего-то
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
