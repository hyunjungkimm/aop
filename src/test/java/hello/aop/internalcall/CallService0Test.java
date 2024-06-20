package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(CallLogAspect.class)
@SpringBootTest
class CallService0Test {

    @Autowired
    CallService0 callService0;

    @Test
    void external() {
        callService0.external();
    }

    @Test
    void internal() {
        callService0.internal();
    }

}