## 람다식(Lambda Expressions)
### 1. 람다식(Lambda Expressions)
* 자바에서 함수적 프로그래밍을 위해서 자바 8부터 람다식을 지원한다.
* 람다식은 매개변수를 가지는 함수와 같은 코드 블록이지만 런타임 시에는 인터페이스의 익명 구현 객체를 생성한다.
* 람다식을 사용하면 코드가 간결해지고, 컬렉션의 요소들을 필터링하거나 매핑해서 원하는 결과를 쉽게 가져올 수 있다.
  ```java
    ([자료형 매개변수, ...]) -> {
    	// 실행 코드
    
    	[return 반환값;]
    };
  ```
### 2. 함수적 인터페이스(Functional Interface)
* 람다식은 인터페이스 타입의 변수에 대입되고 람다식은 인터페이스의 익명 구현 객체를 생성한다.
* 하나의 추상 메소드가 선언된 인터페이스만 람다식으로 익명 구현 객체를 생성할 수 있는데 이러한 인터페이스를 함수적 인터페이스라고 한다.
* 함수적 인터페이스를 선언할 때 @FunctionalInterface 어노테이션을 붙이면 두 개 이상의 추상메소드가 선언되지 않도록 컴파일러가 체크해 준다.
  ```java
  @FunctionalInterface
  public interface Runnable {

    public abstract void run();
  }
  ```
### 3. 표준 함수적 인터페이스
* 자바 8부터 빈번히 사용되는 함수적 인터페이스는 java.util.function 표준 API 패키지로 제공된다.
* 표준 함수적 인터페이스는 용도에 따라 크게 Consumer, Supplier, Function, Operator, Predicate로 구분된다.
  ```java
  @FunctionalInterface
  public interface Consumer<T> {

    void accept(T t);
  }

  @FunctionalInterface
  public interface Supplier<T> {

    T get();
  }
  
  @FunctionalInterface
  public interface Function<T, R> {

    R apply(T t);
  }

  @FunctionalInterface
  public interface IntBinaryOperator {

    int applyAsInt(int left, int right);
  }

  @FunctionalInterface
  public interface Predicate<T> {

    boolean test(T t);
  }
  ```
