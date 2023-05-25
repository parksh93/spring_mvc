package com.spring.mvc.controller;

import com.spring.mvc.controller01.NotebookDTO;
import org.junit.jupiter.api.Test;

public class NotebookDTOTest {
    @Test
    public void notebookDTOTest(){
        NotebookDTO notbook = new NotebookDTO();
        notbook.getModelName(); //롬복을 이용한 getter 생성
        notbook.setModelName("macbook m2");

    }
}
