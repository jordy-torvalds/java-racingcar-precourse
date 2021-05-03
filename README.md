# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 필수 요구사항


### 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이
하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승 했는지를 알려준다. 우승자는 한 명 이상 일수있다.

### 프로그래밍 요구사항
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * https://naver.github.io/hackday-conventions-java/
* indent depth를 2가 넘지 않도록 구현한다.
* 자바8의 stream api를 사용하지 않고 구현 해야 한다. 람다는 사용 가능하다.
* else 예약어를 사용하지 않는다.,
* 함수 또는 메소드의 길이가 10라인을 넘어가지 않도록 구현한다.
* 일급콜렉션을 활용해 구현한다.
    * https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
* 모든 원시값과 문자열을 포장한다.
    * https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/
  
## 기능 구현 목록
- [x] 플레이어에게 자동차 이름을 입력받아 자동차를 생성한다.
  - [x] 각 자동차 이름은 쉼표(,) 구분자로 하여 생성한다.
  - [x] 입력할 이름을 1자 이상, 5자 이하만 가능하다. 
  - [x] 경주란 최소 2대 이상의 자동차 중 누가 더 빨리 목표에 도달하는지 경쟁하는 것을 말하므로, 생성 가능한 최소 자동차의 댓수는 2대로 한다.
  - [x] 최대 생성 가능한 자동차의 댓수는 int 양수 범위로 제한한다.
  - [x] **예외 처리 필요사항**
    - [x] 입력받은 자동차 이름을 어떤 문자도 입력하지 않은 경우 다시 입력을 요청한다.
    - [x] 입력받은 자동차 이름의 수가 한 개 일 경우 다시 입력을 요청한다.
    - [x] 입력받은 자동차 이름이 쉼표(,)로 끝날 경우 다시 입력을 요청한다.
    - [x] 입력받은 자동차 이름이 한 글자 이상, 다섯 글자 이하가 아닐 경우 다시 입력을 요청한다.
  
  
- [x] 시도할 횟수를 플레이어에게 입력받는다.
  - [x] 시도할 횟수는 1 이상의 int 만 입력 받는다.
  - [x] **예외 처리 필요사항** 
    - [x] 입력받은 시도할 횟수가 문자열일 경우 다시 입력을 요청한다.
    - [x] 입력받은 시도할 횟수가 1 미만의 숫자인 경우 다시 입력을 요청한다.
  

- [x] 0에서 9 사이에서 random 값을 구하여 정지/전진을 결정한다.
  - [x] random 값이 4이상 일 경우 전진하고, 3 이하의 값이면 멈춘다.
  - [x] 판별 결과가 전진일 경우, 해당 자동차의 위치 값에 적용한다.
  

- [x] 위치 캐싱 클래스를 동일한 위치인 자동차는 동일한 위치 클래스를 가지도록 한다.
  - [x] 위치 캐싱 클래스는 일급 콜렉션 클래스로 구현한다.
  - [x] 더 이상 사용되지 않는 위치인 경우 캐시에서 자동으로 삭제되도록 한다.


- [x] 위치 문자열 캐싱 클래스를 구현한다.
  - [x] 수 많은 자동차가 가지는 위치 정수 값만큼 하이픈(-) 문자열을 만드는 것을 방지하기 위한 위치값 문자열 캐싱 클래스이다.
  - [x] 위치 문자열 캐싱 클래스는 해쉬맵 일급 콜렉션 클래스로 개발하며, 해당 해쉬맵의 키는 위치 값 클래스
    , 밸루는 문자열 클래스를 포장한 위치 문자열 클래스로 한다.
    - [x] 특정 위치 값으로 하는 위치 문자열 클래스가 없을 시 캐시에 추가한다.
    - [x] 위치 문자열 클래스의 사용 가능 회수는 게임에서 생성된 자동차 수 만큼이다.
  

- [ ] 시도 회차별 결과 출력
  - [ ] 모든 참여 자동차는 회차 별로 한 번씩 정지/전진 여부가 결정된다.
  - [ ] 회차 별 정지/전지 결정을 적용하여 현재 위치를 하이픈(-) 으로 출력한다.
    - [ ] 현재 위치 출력시, 위치 문자열 캐싱 클래스에서 먼저 확인하고 있으면 출력한다.
    - [ ] 현재 위치 출력시, 위치 문자열 캐싱 클래스에 없는 경우 캐싱된 위치 문자열 클래스에 하이픈(-)을 하나 더 추가해서 캐싱 클래스에 추가


- [ ] 전체적인 프로그램 진행 처리
  - [ ] (1) **경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)** 이란 문구가 출력되고 플레이어에게 경주할 자동차 이름을 입력 받음
  - [ ] (2) **시도할 회수는 몇회인가요?** 란 문구가 출력되고 플레이어에게 시도할 횟수를 입력 받음
  - [ ] (3) **실행결과** 가 출력됨
  - [ ] (4) 각 회차 별로 전체 자동차의 전진/정지에 따른 현재 위치를 하이픈(-) 으로 출력
  - [ ] (5) 모든 회차를 종료한 후에 가장 전진을 많이한 자동차(들)의 
    이름을 **$자동차1, $자동차2 ... $자동차n가 최종 우승했습니다.** 란 포맷으로 출력
  
    