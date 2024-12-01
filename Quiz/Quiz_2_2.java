package Quiz;

public class Quiz_2_2 {
    /*
     * Quiz-2-2. Thread class를 이용해 1초마타 횟수를 1씩 증가하는 ThreadCounter class를 정의하고, 실행 후 결과를 확인하라.

        - 요구 사항

        Thread로 동작할 수 있도록 정의하라.

        Thread class를 이용한다.

        Counter class를 정의하라.

        시작 후 1초마다 횟수를 1씩 증가 시킨다.

        횟수가 변경될 때마다 이름과 횟수를 출력한다.

        주어진 최대 횟수에 도달하면, 동작을 종료한다.

        Constructor를 정의하라.

        이름과 최대 횟수를 인수로 받아 초기화하다.

        시작 횟수는 0부터한다.

        - 참고

        Thread class에서 실행 코드는 run()에 정의되어야 한다.

        Thread class에서 run()은 거의 아무런 작업이 수행되지 않도록 정의되어 있으므로, 재정의가 필요하다.

        Extended class를 통해 method를 재정의할 경우,

        @Override annotation을 이용해 재정의됨을 표시하는게 좋다.

        method가 잘못 정의될 경우, 이를 알 수 있어 추가적인 문제를 방지한다.

        Thread class의 instance를 동작시키기 위해서는 start() 호출이 필요하다.
     */
    public static void main(String[] args) {
        ThreadCounter threadCounter1 = new ThreadCounter("counter1", 10);
        ThreadCounter threadCounter2 = new ThreadCounter("counter2", 10);
        // threadCounter1.run();
        // threadCounter2.run();

        threadCounter1.start();
        threadCounter2.start();
        /*
         * 자바에서 스레드를 사용하는 방식은 독특하다.
         * Thread 클래스의 run() 메서드는 스레드가 실행할 작업을 정의하는 곳이지만, 스레드를 시작할 때는 start()를 호출해야한다.
         * 그 이유는 다음과 같다.
         * 
         * start() vs run()
         * 
         * start()를 호출하면, 새로운 스레드가 생성되고, 그 스레드가 run() 메서드를 실행한다.
         * 즉, start()는 스레드의 수명 주기를 시작하는 역할을 한다.
         * 새로운 스레드에서 run() 메서드를 실행하기 때문에, 프로그램의 메인 스레드와는 독립적으로 동작한다.
         * 
         * run() 메서드는 Thread 클래스에서 오버라이드하여 스레드가 수행할 작업을 정의하는 곳이다.
         * 만약 run()을 직접 호출하면, 새로운 스레드가 생성되지 않고, 현재 실행중인 스레드에서 (ex : main 스레드)
         * run() 메서드를 동기적으로 실행하게 된다.
         * 따라서, 새로운 병렬 처리가 이루어지지 않는다.
         * 
         * 요약하자면, start()를 호출해야만 Java에서 진정한 멀티스레딩이 이루어진다. 이는 새로운 스레드를 생성하고
         * 그 안에서 run() 메서드를 실행하기 때문이다. 반면, run() 을 직접 호출하면 단순히 일반 메서드를 호출하는 것과 같아져
         * 멀티스레딩의 이점을 누릴 수 없다.
         */
    }
}

class ThreadCounter extends Thread{
    private String name;
    private int maxCount;
    private int currentCount;

    public ThreadCounter(String name, int maxCount) {
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
