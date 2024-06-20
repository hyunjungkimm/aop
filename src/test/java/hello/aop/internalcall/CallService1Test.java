package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@Import(CallLogAspect.class)
@SpringBootTest
//@SpringBootTest("spring.main.allow-circular-references=true") // 스프링 2.6부터 순환참조 기본적으로 금지
class CallService1Test {

    @Autowired
    CallService1 callService1;

    @Test
    void external() {
        callService1.external();
    }
}