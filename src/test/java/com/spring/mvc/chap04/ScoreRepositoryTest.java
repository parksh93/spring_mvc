package com.spring.mvc.chap04;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ScoreRepositoryTest {
//    @Test
//    public void ScoreRepositoryTest(){
//        System.out.println(ScoreRepositoryImpl.scoreMap);
//        System.out.println(ScoreRepositoryImpl.sequence);
//    }
    //테스트 대상인 클래스를 상단에 선언해둔다
    @Autowired
    ScoreRepository repository;

    @Test
    public void findAllTest(){
        //GWT 패턴(AAA 패턴)
        //GIVEN (테스트를 워해 사전에 설정해야 하는 데이터를 선언하는 구간)
        //findAll은 특별한 조건 없이 전체 데이터를 가져오므로 GIVEN이 없음

        //WHEN (테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성)
        List<Score> result = repository.findAll();

        //THEN (테스트 결과가 이렇게 나올것이다 하는 단언)
        // 나는 result 내부에 3개의 Score가 있다고 단언합니다.
        //ScoreMap에 사전설정으로 3개의 데이터를 넣었으므로, 3개가 나와야 정상인 상황
        //방식 1 (예전)
        System.out.println(result);
        //방식 2
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("저장소에서 2번 유저를 가져와서 이름과 국어성적 비교")
    public void findByStudentNumberTest(){
        //given
        int studentNumber = 2;
        //when
        Score result = repository.findByStudentNumber(studentNumber);
        //then
        assertEquals("이부트",result.getName());
        assertEquals(23,result.getKorScore());
    }

    @Test
    @DisplayName("없는 번호로 조회시 null이어야함")
    public void notFindByStudentNumberTest(){
        int studentNumber = 99;

        Score result = repository.findByStudentNumber(studentNumber);

        assertNull(result); //null이면 통과, 아니면 실패
    }

    @Test
    public void saveTest(){
        Score stu4 = new Score();
        stu4.setName("박상현");
        stu4.setKorScore(99);
        stu4.setEngScore(88);
        stu4.setMathScore(77);

        boolean saveboolean = repository.save(stu4);
        List<Score> result = repository.findAll();

        assertEquals(4,result.size());
        assertTrue(saveboolean);
    }
    @DisplayName("저장소에서 2번 학생 삭제 후 리스트 전체조회시 개수는 2개 , 다시 2번학생 조회는 null")
    @Test
    public void deleteByStudentNumberTest(){
        //given
        int studentNum = 2;
        //when
        boolean result = repository.deleteByStudentNumber(studentNum);
        List<Score> scoreList= repository.findAll();  //2개만 가져와야함
        Score score = repository.findByStudentNumber(studentNum);   //null이여야 함
        //then
        assertTrue(result);
        assertNull(score);
        assertEquals(2, scoreList.size());
//        assertThat(scoreList.size()).isEqualTo(2);
    }
}

