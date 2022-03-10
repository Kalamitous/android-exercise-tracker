package com.example.androidexercisetracker;

import java.util.Optional;

public class User {
    public static java.util.Optional<String> name = Optional.empty();
    public static java.util.Optional<Integer> weight = Optional.empty();
    public static java.util.Optional<Integer> height = Optional.empty();
    public static java.util.Optional<Integer> age = Optional.empty();


    public User() {
       // weight = Optional.empty();
    }

    public static void updateName(java.util.Optional<String> newName) {
        name = newName;
    }

    public static void updateWeight(java.util.Optional<Integer> newWeight) {
        weight = newWeight;
    }

    public static void updateHeight(java.util.Optional<Integer> newHeight) {
        height = newHeight;
    }

    public static void updateAge(java.util.Optional<Integer> newAge) {
        age = newAge;
    }
}
