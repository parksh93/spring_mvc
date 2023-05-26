package com.spring.mvc.chap04.repository;

/*
    역할 명세(추상화)
    1. 전체 성적 조회
    2. 개별 성적 조회
    3. 성적 삭제
    4. 성적 등록
 */

import com.spring.mvc.chap04.entity.Score;

import java.util.List;

public interface ScoreRepository {
    // 전체 성적
    //entity계층에 score라는 정보가 어떻게 구송되는지 먼저 정의
    // score 객체에 담아와서 처리
     public List<Score> findAll();

     //등록 성공시 true, 실패시 false
     public boolean save(Score score);

     boolean deleteByStudentNumber(int studentNumber);

     Score findByStudentNumber(int studentNumber);

}
