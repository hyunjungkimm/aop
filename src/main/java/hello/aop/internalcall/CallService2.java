package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class CallService2 {

    //private final ApplicationContext applicationContext;
    private final ObjectProvider<CallService2> callService2Provider;

    public void external() {
        log.info("call external");
        //CallService2 callService2 = applicationContext.getBean(CallService2.class);
        CallService2 callService2 = callService2Provider.getObject(CallService2.class);
        callService2.internal();//외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }

}
