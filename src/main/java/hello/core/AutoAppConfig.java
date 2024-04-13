package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
/*
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
*/
    // 자동 빈 등록을 하려는데 수동 빈 등록하는 빈 이름과 동일하기 때문에 충돌이 난다.
    // 자동 빈 등록과 수동 빈 등록 중에서는 수동 빈 등록이 우선권을 가진다.
}
