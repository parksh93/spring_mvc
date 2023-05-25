package com.spring.mvc.controller01;

import lombok.Data;

@Data   //자동으로 getter, setter,생성자를 만들어줌
        // 순환 참조 문제가 있어서 쓰지 않는걸 권장
public class NotebookDTO {
    // 커멘드 객체 패턴으로 컨트롤러의 파라미터로 처리하는 경우
    // 반드시 세터와 기본생성자가 만들어져 있어야 작동하는데
    // 위쪽에 롬복의 Date 어노테이션을 이용해 생성할 수 있다
    private String modelName;
    private  int price;
    private int ssd;
    private int ram;
}
