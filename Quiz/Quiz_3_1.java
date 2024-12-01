package Quiz;

public class Quiz_3_1 {
    /*
     * Quiz-3-1. Runnable interface를 이용해 RunnableCounter class를 구현해 보자.


        요구 사항

        Runnable interface를 지원하도록 RunnableCounter를 구현하라.

        ThreadCounter와 동일하게 1초에 1씩 증가하며, maxCount까지 출력한다.



        예상 결과

        name을 runnableCounter로 준다.

        maxCount를 10으로 준다.

        참고

        Runnable interface는 run() 구현만을 요구하는 functional interface이다.

        Runnable interface 구현시 실행을 위해서는 별도의 Thread object가 필요하다.

        - Thread 클래스 보다 Runnable 인터페이스의 사용이 권장되는 이유

        1. 다중 상속의 제한 해결:
        Java는 다중 상속을 지원하지 않기 때문에, 한 클래스가 두 개 이상의 클래스를 상속받을 수 없습니다. 
        Thread 클래스를 상속받으면 다른 클래스를 상속받을 수 없지만, 
        Runnable 인터페이스는 구현할 수 있기 때문에 다른 클래스도 상속받을 수 있습니다. 
        이는 클래스의 확장성을 높여줍니다.

        2. 객체 지향 설계 원칙 준수:
        Runnable을 사용하면 스레드 실행 코드와 비즈니스 로직을 분리할 수 있습니다. 
        이렇게 하면 스레드 관련 로직과 비즈니스 로직을 별도로 관리할 수 있어 코드 구조가 더 깔끔하고 유지보수성이 높아집니다.

        3. 재사용성과 메모리 효율성:
        Runnable 인터페이스를 구현한 객체는 여러 Thread에서 재사용할 수 있습니다. 
        즉, 동일한 작업을 여러 스레드에서 실행하고 싶을 때 유용합니다. 
        반면, Thread 클래스를 상속받으면 각 스레드 객체가 고유해야 하므로 메모리 사용이 증가할 수 있습니다.
     */
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("runnableCounter", 10);
        Thread thread1 = new Thread(runnableCounter);
        Thread thread2 = new Thread(runnableCounter);
        thread1.start();
        thread2.start();
    }
}

class RunnableCounter implements Runnable{
    /*
     * Runnable 인터페이스는 Java 에서 멀티스레딩을 구현할 때 사용되는 간단한 인터페이스이다.
     * 이 인터페이스는 단 하나의 메서드인 void run() 을 포함하고 있으며, 이를 통해 스레드에서 실행할 코드를 정의한다.
     */

    private String name;
    private int maxCount;
    private int currentCount;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.currentCount = 0;
    }

    @Override
    public void run() { // 스레드에서 run 메서드는 스레드가 실행할 것을 정의하는 곳
        // TODO Auto-generated method stub
        while (currentCount < maxCount) {
            try {
                Thread.sleep(1000); // 1초 대기
                currentCount++;
                System.out.println(name + " : " + currentCount);
            } catch (Exception e) {
                // TODO: handle exception
                Thread.currentThread().interrupt();
            }
        }
    }
    
}
