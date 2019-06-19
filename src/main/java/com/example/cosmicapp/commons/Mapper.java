package com.example.cosmicapp.commons;

import org.springframework.stereotype.Component;

public interface Mapper<F, T> {

    T map (F from);
    F reverseMap(T to);
}
