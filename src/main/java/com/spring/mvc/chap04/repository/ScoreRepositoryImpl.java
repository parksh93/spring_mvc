package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ScoreRepositoryImpl implements ScoreRepository{
    //key : 학번, value : 성적정보
    private static final Map<Integer,Score> scoreMap;
    private static int sequence;   //primary key로 사용할 학번을 체크

    static {
        scoreMap = new HashMap<>();
        Score stu1 = new Score("김자바",100, 50, 70, ++sequence,0,0);
        Score stu2 = new Score("이부트",23, 70, 80, ++sequence,0,0);
        Score stu3 = new Score("박디비",45, 40, 30, ++sequence,0,0);
        scoreMap.put(stu1.getStudentNumber(), stu1);
        scoreMap.put(stu2.getStudentNumber(), stu2);
        scoreMap.put(stu3.getStudentNumber(), stu3);
    }
    @Override
    public List<Score> findAll() {
        List<Score> studentList = new ArrayList<>();
        for (Score score: scoreMap.values()) {
            studentList.add(score);
        }
        return studentList;
    }

    @Override
    public boolean save(Score score) {
        if (scoreMap.containsKey(score.getStudentNumber())){
            return false;
        }
        score.setStudentNumber(++sequence);
        scoreMap.put(score.getStudentNumber(),score);
        return true;
    }

    @Override
    public boolean deleteByStudentNumber(int studentNumber) {
        return false;
    }

    @Override
    public Score findByStudentNumber(int studentNumber) {
        return  scoreMap.get(studentNumber);
    }
}
