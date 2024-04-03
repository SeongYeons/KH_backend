## 스트림(Stream) API
### 1. 스트림(Stream) API
* 스트림은 자바 8부터 추가된 기능으로 컬렉션(배열)의 저장 요소들을 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자이다.
* 스트림은 내부 반복자를 사용해서 병렬 처리와 중간 처리, 최종 처리 작업을 수행할 수 있다.
### 2. 스트림의 생성
* java.util.stream 패키지에 존재하고 BaseStream 인터페이스를 부모로 해서 자식 인터페이스들이 상속 관계를 이루고 있다.
  ```java
  public interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable {
    ...
  }

  public interface Stream<T> extends BaseStream<T, Stream<T>> {
    ...
  }

  public interface IntStream extends BaseStream<Integer, IntStream> {
    ...
  }

  public interface LongStream extends BaseStream<Long, LongStream> {
    ...
  }

  public interface DoubleStream extends BaseStream<Double, DoubleStream> {
    ...
  }
  ```
* IntStream, LongStream의 range(), rangeClosed() 메소드를 이용해서 숫자 범위로 스트림을 생성할 수 있다.
  ```java
  IntStream stream = IntStream.range(1, 10); 
  ```
* Arrays.stream(배열) 메소드를 이용해서 배열로부터 스트림을 생성할 수 있다.
  ```java
  String[] names = {"문인수", "홍길동", "이몽룡"};

  Stream<String> stream = Arrays.stream(names);
  ```
* 컬렉션의 stream() 메소드를 이용해서 컬렉션으로부터 스트림을 생성할 수 있다.
  ```java
  List<String> names = Arrays.asList("문인수", "홍길동", "이몽룡");

  Stream<String> stream = names.stream();
  ```
### 3. 중간 처리 메소드
* 스트림은 데이터의 필터링, 정렬, 매핑 등의 처리를 할 수 있는 중간 처리 메소드를 제공한다.
* 리턴 타입이 스트림이라면 중간 처리 메소드이다.
  ```java
  int[] array = {1, 2, 3, 4, 5, 6};

  Arrays.stream(array)
        .filter(value -> value % 2 == 0) // 중간 처리 메소드
        .forEach(value -> System.out.println(value)); // 최종 처리 메소드
  ```
### 4. 최종 처리 메소드
* 스트림은 데이터의 집계, 수집, 반복 처리 등의 처리를 할 수 있는 최종 처리 메소드를 제공한다.
* 리턴 타입이 기본 타입이거나 Optional 타입이라면 최종 처리 메소드이다.
  ```java
  int sum = 0;
  int[] array = {1, 2, 3, 4, 5, 6};
  
  sum = Arrays.stream(array).sum(); // 최종 처리 메소드
  ```
