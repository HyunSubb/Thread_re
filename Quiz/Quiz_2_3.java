package Quiz;

public class Quiz_2_3 {
    /*
     * Quiz-2-3. Counter class의 instance를 2개 이상 만들고 실행 후 동작에 대해 설명해보자


        요구 사항
        Counter class의 instance를 2개 이상 만들어서 동시에 실행시켜 보자.



        예상 결과
        name을 counter1, counter2, …​으로 준다.

        maxCount를 10으로 준다.
     */
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1", 10);
        Counter counter2 = new Counter("counter2", 10);

        // 얘는 멀티스레딩이 안된다.
        counter1.run();
        counter2.run();
    }
}
