package Quiz;

public class Quiz_2_1 {
    /*
     * Quiz-2-1. 1초마다 횟수를 1씩 증가하는 Counter class로 정의하고, 실행 후 결과를 확인하라.

        요구 사항
        Counter class를 정의하라.

        시작 후 1초마다 횟수를 1씩 증가 시킨다.

        횟수가 변경될 때마다 이름과 횟수를 출력한다.

        주어진 최대 횟수에 도달하면, 동작을 종료한다.

        Constructor를 정의하라.

        이름과 최대 횟수를 인수로 받아 초기화하다.

        시작 횟수는 0부터한다.

        run()을 이용해 실행하도록 구성한다.
     */
    public static void main(String[] args) {
        Counter counter = new Counter("counter", 10);

        counter.run();
    }
}

class Counter {
    private String name;
    private int maxCount;
    private int currentCount;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.currentCount = 0;
    }

    public void run() {
        while(currentCount < maxCount) {
            currentCount++;
            System.out.println(name + " : " + currentCount);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("오류 발생");
                Thread.currentThread().interrupt();
                // 스레드에게 종료 또는 중단할 필요가 있음을 알리는 매커니즘
            }
        }
    }
}
