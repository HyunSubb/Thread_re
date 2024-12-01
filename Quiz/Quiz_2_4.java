package Quiz;

public class Quiz_2_4 {
    /*
     * Quiz-2-4. ThreadCounter class의 instance를 2개 이상 만들고 실행 후 동작에 대해 설명해보자


        요구 사항
        Threadcounter class의 instance를 2개 이상 생성하여 동시에 실행시켜 보자.



        예상 결과
        name을 counter1, counter2, …​으로 준다.

        maxCount를 10으로 준다.
     */
    public static void main(String[] args) {
        ThreadCounter threadCounter1 = new ThreadCounter("counter1", 10);
        ThreadCounter threadCounter2 = new ThreadCounter("counter2", 10);

        // 멀티스레딩 가능.
        threadCounter1.start();
        threadCounter2.start();
    }
}
