package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
 * 참고 : 생성자 주입은 순환 사이클을 만들기 때문에 실패함 -스프링 2.6부터 순환참조 기본적으로 금지 (수정자 주입도 실패함)
 */
@Component
@Slf4j
public class CallService1 {

    private CallService1 callService1;

    @Lazy
    @Autowired
    public void setCallService1(CallService1 callService1) {
        this.callService1 = callService1;
    }

    public void external() {
        log.info("call external");
        callService1.internal(); //외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }

}
