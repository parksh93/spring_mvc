package com.spring.mvc.controller01;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DogDTO {
    private String name;
    private int age;
    private String kind;
}
