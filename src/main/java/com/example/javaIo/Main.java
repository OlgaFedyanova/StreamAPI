package com.example.javaIo;

import java.util.List;

import static com.example.javaIo.Dao.getTimeInfo;
import static com.example.javaIo.Dao.method;

public class Main {

    //получили два листа
    public static List<HumanModel> humanModelList = method();

    //System.out.println(humanModelList);

    public static List<TimeInfoModel> timeInfoModelList = getTimeInfo();

    // System.out.println(timeInfoModelList);

    //отдельный метод с фильтром:
    public static String getTime(ResultHumanModel humanResult){
      return timeInfoModelList.stream().filter(t -> t.getAbr().equals(humanResult.getAbr()))
                .findAny().orElse(null).getTime();

    }

    public static void main(String[] args) {


        //бежим по листу один и из него вытаскиваем каждую аббревиатуру и каждое имя и пушим эти данные
        // в новый результирующий лист

        humanModelList.stream().map(h ->
                {
                    ResultHumanModel resultHumanModel = new ResultHumanModel();
                    resultHumanModel.setAbr(h.getHumanAbbreviation());
                    resultHumanModel.setName(h.getHumanName());
                    return resultHumanModel;

        }).map(h -> {   //сравним абр из результирующего листа с абр из листа со временем и если они совпадают - вытянем время
         String time = timeInfoModelList.stream().filter(t -> t.getAbr().equals(h.getAbr())).findAny().orElse(null).getTime();
            System.out.println(time);
            return null;
        }).toList();

//                }).map(h -> {   //сравним абр из результирующего листа с абр из листа со временем и если они совпадают - вытянем время
//                    String time = timeInfoModelList.stream().filter(t -> t.getAbr().equals(h.getAbr())).findAny().orElse(null).getTime();
//                    h.setTime(time);
//                    return h; //возвращаем каждого заполненного хьюмана назад
//                }).peek(System.out::println)
//                .toList();


        //мы можем вынести фильтрацию по абр и вытаскивание времени в отдельный метод
//                }).peek(h -> h.setTime(getTime(h)))
//                .peek(System.out::println)
//                .toList();
    }



}

