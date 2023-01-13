package com.example.javaIo.streams;
//функциональный интерфейс имеет только ОДИН АБСТРАКТНЫЙ МЕТОД
@FunctionalInterface    //это нужно чтобы компилятор следил за тем чтобы в интерфейсе был только один абстрактный метод
public interface Worker {

    void work();
}
