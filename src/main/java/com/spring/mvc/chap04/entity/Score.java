package com.spring.mvc.chap04.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
@NoArgsConstructor  //기본생성자
@AllArgsConstructor //모든 멤버변수를 요구하는 생성자
public class Score {
    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;

    private int studentNumber;
    private int total;
    private double average;
}
