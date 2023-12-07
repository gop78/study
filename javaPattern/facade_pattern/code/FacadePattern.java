package javaPattern.facade_pattern.code;

class Washing {
    void wash() {
        System.out.println("do Washing");
    }
}

class Rinsing {
    void rinse() {
        System.out.println("do Rinsing");
    }
}

class Spinning {
    void spin() {
        System.out.println("do Spinning");
    }
}

/**
 * washing, rinsing, spinning을 하나로 묶어 "세탁"이라는 행위를 위한 공통 코드
 */
class WashingMachine {
    Washing washing = new Washing();
    Rinsing rinsing = new Rinsing();
    Spinning spinning = new Spinning();

    void startWashing() {
        washing.wash();
        rinsing.rinse();
        spinning.spin();
    }
}

public class FacadePattern {

    /**
     * subClass 사용
     * 객체들 간의 결합도 높음
     * @param args
     */
    /*public static void main(String[] args) {
        Washing washing = new Washing();
        Rinsing rinsing = new Rinsing();
        Spinning spinning = new Spinning();

        washing.wash();
        rinsing.rinse();
        spinning.spin();
    }*/

    /**
     * FacadePattern(퍼사드 패턴) 적용
     * 1. 결합도 낮음
     * 2. 가독성 상승
     * 3. 서브 시스템 직접 접근 가능
     * @param args
     */
    public static void main(String[] args) {
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.startWashing();
    }

}