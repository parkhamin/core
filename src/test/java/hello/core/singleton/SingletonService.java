package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance; // 참조를 꺼낼 수 있는 유일할 방법
    }

    private SingletonService(){

    }

    public void logig(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    // -> 이제 이 객체를 생성할 수 있는 곳은 아무데도 없다. 왜냐? 싱클톤 패턴을 사용했기 때문.
}
