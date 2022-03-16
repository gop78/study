# 아이템1 생성자 대신 정적 팩터리 메서드를 고려하라

클라이언트가 클래스의 인스턴스를 얻는 정통적인 수단은 public 생성자다. 클래스는 생성자와 별도로 정적 팩터리 메서드(static factory method)를 제공할 수 있다.

```markdown
public static Boolean valuOf(boolean b) {
	return b ? Boolean.TRUE : Boolean.FALSE;
}

이 메서드는 기본 타입인 boolean 값을 받아 Boolean 객체 참조로 변환해준다.
```

1. 5가지 장점
    1. 이름을 가질 수 있다.
        
        생성자에 넘기는 매개변수와 생성자 자체만으로는 반환될 객체의 특성을 제대로 설명하지 못한다.
        
        정적 팩터리는 이름만 잘 지으면 반환될 객체의 특성을 쉽게 묘사할 수 있다.
        
    2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
        - 인스턴스를 통제하면 클래스를 싱글턴으로 만들 수도, 인스턴스화 불가로 만들수도 있다.
        - 불변 값 클래스에서 동치인 인스턴스가 단 하나뿐임을 보장할 수 있다.
        - 인스턴스 통제는 플라이웨이트 패턴의 근간이 되며, 열거 타입은 인스턴스가 하나만 만들어짐을 보장한다.
    3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
        
        자바8 전에는 인터페이스에 정적 메서드를 선언할 수 없었다. 그렇기 때문에 이름이 “Type”인 인터페이스를 반환하는 정적 메서드가 필요하면, “Types”라는 (인스턴스화 불가인) 동반 클래스를 만들어 그 안에 정의하는 것이 관례였다.
        
        자바 8부터는 인터페이스가 정적 메서드를 가질 수 없다는 제한이 풀렸기 때문에 인스턴스화 불가 동반 클래스를 둘 이유가 별로 없다. 동반 클래스에 두었던 public 정적 멤버들 상당수를 그냥 인터페이스 자체에 두면 되는 것이다.
        
    4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
        
        반환 타입의 하위 타입이기만 하면 어떤 클래스의 객체를 반환하든 상관없다.
        
        EnumSet 클래스는 public 생성자 없이 오직 정적 패터리만 제공하는데 원소의 수에 따라 두 가지 하위 클래스 중 하나의 인스턴스를 반환한다.
        
        원소가 64개 이하면 원소들을 long변수 하나로 관리하는 RegularEnumSet의 인스턴스를, 65개 이상이면 long 배열로 관리하는 JumboEnumSet의 인스턴스를 반환한다.
        
        클라이언트는 팩터리가 건네주는 객체가 어느 클래스의 인스턴스인지 알 수도 없고 알 필요도 없다. (EnumSet의 하위 클래스이기만 하면되는 것이다.)
        
    5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
2. 2가지 단점
    1. 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
        
        앞서 이야기한 컬렉션 프레임워크이 유틸리티 구현 클래스들은 상속할 수 없다.
        
    2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.
    
    ```markdown
    핵심정리
    정적 팩터리 메서드와 public 생성자는 각자의 쓰임새가 있으니 상대적인 장단점을 이해하고 
    사용하는 것이 좋다. 그렇다고 하더라도 정적 팩터리를 사용하는 게 유리한 경우가 더 많으므로 
    무작정 public 생성자를 제공하던 습관이 있다면 고치자
    ```