---
## [2026-07-02] Q: Python 흐름을 구술로 자세히 풀어줘

**질문**: 이 흐름을 구술로 자세히 풀어줘.

**핵심 개념**:
- 입력 → 처리 → 구조화 → 연결 → 반환: 프로그램이 돌아가는 가장 기본 흐름
- 함수와 클래스: 코드를 재사용 가능하게 묶는 방법

**Python 비교**:
```python
message = input("메시지 입력: ")

def process(text):
    if len(text) > 10:
        return text.upper()
    return text.lower()

result = process(message)
print(result)
```

**Java/Spring 연결**:
```java
@GetMapping("/hello")
public String hello(@RequestParam String message) {
    return service.process(message);
}
```

**흐름 타임라인**:
- 0ms: 사용자가 값을 넣음
- 20ms: 프로그램이 변수에 저장함
- 40ms: 조건/반복으로 가공함
- 60ms: 함수로 묶인 로직이 실행됨
- 80ms: 결과를 반환함

**한 줄 메모**:
- 코드는 결국 "받고, 처리하고, 돌려준다"로 이해하면 시작이 쉬워진다.

---
## [2026-07-02] Q: POJO가 뭐야? 자바 기업용은 또 머닝

**질문**: POJO가 뭐야? 자바 기업용은 또 머닝

**핵심 개념**:
- POJO: 특별한 프레임워크 상속 없이, 순수하게 만든 일반 자바 객체
- 기업용 자바: 웹 요청, DB, 보안, 트랜잭션 같은 큰 서비스 구조를 다루는 자바 생태계

**Python 비교**:
```python
class User:
    def __init__(self, name, age):
        self.name = name
        self.age = age
```

**Java/Spring 연결**:
```java
public class User {
    private String name;
    private int age;
}
```

**흐름 타임라인**:
- 0ms: 데이터를 담을 객체가 필요함
- 10ms: POJO를 하나 만듦
- 20ms: Spring이 이 객체를 요청/응답/DB와 연결해 씀

**한 줄 메모**:
- Python의 단순 클래스처럼, Java에서도 "데이터를 담는 기본 상자"가 먼저다.

---
## [2026-07-02] Q: Day1 수업 내용 page35-37을 수행해야 해. 읽고 같이 하나씩 해보자.

**질문**: 이게 오늘 수업 내용인데 page35-37의 내용을 수행해야 해. 읽고 같이 하나씩 해보자.

**핵심 개념**:
- Controller → Service → ChatClient: Spring AI Day1의 기본 호출 구조
- 엔드포인트: `/api/chat`, `/api/teacher`처럼 기능별 URL을 나눠서 사용

**Python 비교**:
```python
from flask import Flask, request

app = Flask(__name__)

@app.route("/chat")
def chat():
    message = request.args.get("message")
    return f"질문: {message}"
```

**Java/Spring 연결**:
```java
@GetMapping("/api/chat")
public String chat(@RequestParam String message) {
    return chatService.chat(message);
}
```

**흐름 타임라인**:
- 0ms: 브라우저가 `/api/chat?message=...` 요청
- 10ms: Controller가 `message`를 받음
- 20ms: Service가 AI 호출 로직 실행
- 100ms+: AI 응답이 반환됨

**한 줄 메모**:
- Day1은 "AI를 부르는 최소 구조"를 손으로 만들어보는 날이었다.

---
## [2026-07-02] Q: day01-chat-client가 IntelliJ에서 실행이 안 되네 왜 그럴까

**질문**: C:\Users\금정산2-PC02\p2-spring\day01-chat-client 여기서 프로젝트를 IntelliJ로 하는데 실행이 안되네 왜 그럴까

**핵심 개념**:
- 실행 문제는 코드 문제와 환경 문제를 분리해서 봐야 함
- Java 21, Gradle, IntelliJ 실행 대상이 맞아야 Spring Boot가 정상 기동함

**Python 비교**:
```python
# 코드가 맞아도
# python 버전이나 가상환경이 틀리면 실행이 안 될 수 있다.
print("환경 설정 확인")
```

**Java/Spring 연결**:
```java
@SpringBootApplication
public class Day01Application {
    public static void main(String[] args) {
        SpringApplication.run(Day01Application.class, args);
    }
}
```

**흐름 타임라인**:
- 0ms: IntelliJ가 실행 설정을 읽음
- 10ms: JDK 버전 확인
- 30ms: Gradle/Spring Boot 클래스 로드
- 100ms+: 톰캣 서버가 뜨면 실행 성공

**한 줄 메모**:
- 실행이 안 될 때는 "코드가 틀렸나?"보다 먼저 "환경이 맞나?"를 같이 봐야 한다.

---
## [2026-07-02] Q: chatService에 빨간 줄이 계속 떠

**질문**: chatService에 빨간 줄이 계속 떠

**핵심 개념**:
- 생성자 주입: Service를 Controller에 연결하는 가장 기본 방식
- 문법 오류 하나로도 IntelliJ 전체가 빨간 줄처럼 보일 수 있음

**Python 비교**:
```python
class ChatService:
    def chat(self, message):
        return message

class ChatController:
    def __init__(self, service):
        self.service = service
```

**Java/Spring 연결**:
```java
private final ChatService chatService;

public ChatController(ChatService chatService) {
    this.chatService = chatService;
}
```

**흐름 타임라인**:
- 0ms: Spring이 Controller를 만들려고 함
- 5ms: 필요한 Service를 찾음
- 10ms: Service 코드에 문법 오류가 있으면 연결 실패

**한 줄 메모**:
- 빨간 줄은 "연결 문제"일 수도 있지만, 실제로는 중괄호/오타 같은 문법 문제인 경우도 많다.

---
## [2026-07-02] Q: HTML도 만들어서 디자인 적용시킬까

**질문**: 응 우리도 html 만들어서 각각에 디자인 적용시킬까?

**핵심 개념**:
- API만 있는 앱에서 UI를 붙이면 사용 흐름이 눈에 보이기 시작함
- 백엔드와 프론트의 연결을 작은 형태로 경험하는 단계

**Python 비교**:
```python
# Flask에서도 API만 만들 수 있지만
# template을 붙이면 브라우저 화면이 생긴다.
```

**Java/Spring 연결**:
```java
@Controller
public class ChatViewController {
    @GetMapping("/")
    public String home() {
        return "chat";
    }
}
```

**흐름 타임라인**:
- 0ms: 브라우저가 `/` 요청
- 10ms: HTML 템플릿 반환
- 30ms: 사용자가 폼 입력
- 50ms: API 호출
- 100ms+: 응답 표시

**한 줄 메모**:
- UI를 붙이면 API가 "보이지 않는 로직"에서 "직접 써보는 기능"으로 바뀐다.

---
## [2026-07-03] Q: Day2 수업 내용이 이해가 안 가. 처음부터 끝까지 설명해줘

**질문**: 오늘 학습 내용인데 이해가 안 가. 처음부터 끝까지 설명해줘,

**핵심 개념**:
- Prompt 설계: AI에게 그냥 질문하지 말고, 답의 형식과 대상까지 지정하는 것
- Structured Output: 문자열 말고 JSON, 객체, 리스트처럼 구조화된 결과 받기

**Python 비교**:
```python
prompt = f"{audience}가 이해하기 쉽게 요약해줘: {text}"
print(prompt)
```

**Java/Spring 연결**:
```java
return chatClient.prompt()
        .user(u -> u.text("{audience}가 이해하기 쉽게 요약해줘: {text}")
                .param("audience", audience)
                .param("text", text))
        .call()
        .content();
```

**흐름 타임라인**:
- 0ms: 요청이 들어옴
- 10ms: 프롬프트 템플릿 생성
- 20ms: 변수 치환
- 80ms+: AI 응답 수신
- 100ms+: 문자열/객체로 변환

**한 줄 메모**:
- Day2는 "AI에게 어떻게 말해야 원하는 형태로 답을 받는가"를 배우는 날이었다.

---
## [2026-07-03] Q: day02-prompt-output에 Gradle 설정 문제가 존재해. 문제가 뭘까?

**질문**: C:\Users\금정산2-PC02\p2-spring\spring-ai-study에서 day02에 Gradle 설정 문제가 존재해. 문제가 뭘까?

**핵심 개념**:
- 경로 문제: 한글 사용자 경로가 Gradle test executor를 흔들 수 있음
- `org.gradle.java.home`, `GRADLE_USER_HOME`: Java/Gradle 경로를 영어 경로로 고정하는 설정

**Python 비교**:
```python
# 라이브러리 코드는 맞아도
# 경로나 환경변수가 꼬이면 실행이 깨질 수 있다.
import os
print(os.environ.get("PYTHONPATH"))
```

**Java/Spring 연결**:
```properties
org.gradle.java.home=C:/jdk21
```

**흐름 타임라인**:
- 0ms: Gradle이 JDK 경로 확인
- 10ms: 캐시/worker 경로 확인
- 30ms: 테스트 실행기 로드
- 50ms+: 한글 경로에서 classpath 문제가 나면 실패

**한 줄 메모**:
- 코드가 아니라 "경로" 때문에 테스트가 깨질 수도 있다는 걸 확인했다.

---
## [2026-07-03] Q: Bruno에서 request를 만들었는데 에러가 뜨네

**질문**: 그냥 우리가 컨트롤러 만들어서 진행하는데 bruno에 request 만들어서 실행하니까 에러 뜨네.

**핵심 개념**:
- 404는 로직 오류보다 "주소가 없거나 다른 앱이 떠 있음"일 가능성이 큼
- Day1과 Day2가 같은 8080 포트를 쓰면, 어떤 앱이 실제로 떠 있는지 먼저 확인해야 함

**Python 비교**:
```python
# Flask에서도 다른 앱을 켜두고
# 없는 route를 치면 404가 난다.
```

**Java/Spring 연결**:
```java
@GetMapping("/api/summary")
public String summary(@RequestParam String text, @RequestParam String audience) {
    return promptService.summarize(text, audience);
}
```

**흐름 타임라인**:
- 0ms: Bruno가 URL 요청
- 10ms: Spring이 매핑 테이블 확인
- 15ms: 주소가 없으면 404 반환
- 20ms: 정적 리소스까지 찾고 없으면 `NoResourceFoundException`

**한 줄 메모**:
- Bruno 에러는 종종 "요청이 틀린 서버로 갔다"가 원인이다.

---
## [2026-07-03] Q: Controller랑 PromptService.java를 한 줄씩 뜯어서 해석하자

**질문**: 우리 한 줄씩 뜯어서 Controller랑 PromptService.java 해석하자.

**핵심 개념**:
- Controller: 요청을 받는 창구
- Service: 실제 AI 호출과 프롬프트 구성 담당

**Python 비교**:
```python
def controller(text, audience):
    return service(text, audience)

def service(text, audience):
    return f"{audience}용 요약: {text}"
```

**Java/Spring 연결**:
```java
@GetMapping("/api/summary")
public String summary(@RequestParam String text, @RequestParam String audience) {
    return promptService.summarize(text, audience);
}
```

**흐름 타임라인**:
- 0ms: 사용자가 요청
- 10ms: Controller가 파라미터 추출
- 20ms: Service 메서드 호출
- 40ms: ChatClient 프롬프트 생성
- 100ms+: 응답 반환

**한 줄 메모**:
- 코드는 줄마다 따로 있지만, 실행은 하나의 물 흐르듯 연결된다.

---
## [2026-07-03] Q: day01만 Git에 추적되는 것 같아

**질문**: 지금 day01만 깃에 추적되는 거 같아.

**핵심 개념**:
- 중첩 저장소: `day01` 안에만 `.git`이 있으면 `day02`는 Git 추적 대상이 아님
- 루트 저장소 통합: `spring-ai-study`를 하나의 Git 저장소로 만들면 day01/day02를 함께 관리 가능

**Python 비교**:
```python
projects = {
    "day01": "git tracked",
    "day02": "not tracked"
}
```

**Java/Spring 연결**:
```java
// 코드 문제가 아니라 프로젝트 구조 문제였다.
```

**흐름 타임라인**:
- 0ms: IntelliJ가 Git 루트를 봄
- 10ms: `day01/.git`만 인식
- 20ms: `day02` 변경은 일반 폴더처럼 보임
- 30ms: 루트 저장소 생성 후 둘 다 추적 가능

**한 줄 메모**:
- 코드 변경이 안 보이는 건 Git 구조 문제일 수도 있다.

---
## [2026-07-03] Q: movie를 추가했는데 MovieResponse는 안 됐어

**질문**: movie를 새로 추가했는데 service와 controller는 구현 되었지만 MovieResponse는 안 됐어. 확인해바

**핵심 개념**:
- DTO/record: AI 응답을 객체 구조로 받기 위한 데이터 상자
- `ParameterizedTypeReference<List<MovieResponse>>() {}`: 리스트 안 타입까지 알려주는 문법

**Python 비교**:
```python
movies = [
    {"title": "영화1", "genre": "드라마", "reason": "잔잔해서"}
]
```

**Java/Spring 연결**:
```java
public record MovieResponse(
        String title,
        String genre,
        String reason
) {
}
```

**흐름 타임라인**:
- 0ms: `/api/movie?mood=...` 요청
- 20ms: Service가 프롬프트 작성
- 80ms+: AI가 영화 목록 반환
- 100ms+: `List<MovieResponse>`로 변환

**한 줄 메모**:
- 객체 응답을 받으려면 "응답 모양"을 담을 DTO가 꼭 필요하다.

---
## [2026-07-03] Q: /packing 호출이 안 돼

**질문**: http://localhost:8080/packing?destination=하와이&days=8 문제가 뭘까 안돼

**핵심 개념**:
- URL 매핑은 문자 하나까지 정확히 맞아야 함
- 실제 등록 주소가 `/api/packing`이면 `/packing`은 다른 주소다

**Python 비교**:
```python
# Flask에서도 /packing 과 /api/packing 은 다른 route다.
```

**Java/Spring 연결**:
```java
@GetMapping("/api/packing")
public List<String> packing(@RequestParam String destination,
                            @RequestParam(defaultValue = "3") int days) {
    return classifyService.packingList(destination, days);
}
```

**흐름 타임라인**:
- 0ms: 브라우저가 `/packing` 요청
- 10ms: Spring이 매핑 검사
- 15ms: 등록된 주소가 없어서 404
- 20ms: `/api/packing`으로 고치면 정상 연결

**한 줄 메모**:
- "안 된다"의 원인이 코드보다 URL 오타인 경우가 생각보다 많다.

---
## [2026-07-03] Q: Spring AI day1 개념부터 시작하자

**질문**: 자 Spring AI day 1 개념부터 시작하자.

**핵심 개념**:
- Spring AI Day1: AI를 웹 애플리케이션 안에서 처음 호출해보는 가장 기초 단계
- Controller → Service → ChatClient: 요청을 받고, AI를 부르고, 응답을 돌려주는 기본 구조

**Python 비교**:
```python
def chat(message):
    prompt = f"질문: {message}"
    return f"AI 응답: {prompt}"
```

**Java/Spring 연결**:
```java
@GetMapping("/api/chat")
public String chat(@RequestParam String message) {
    return chatService.chat(message);
}
```

**흐름 타임라인**:
- 0ms: 사용자가 브라우저나 Bruno에서 질문 전송
- 10ms: Controller가 요청을 받음
- 20ms: Service가 AI에게 보낼 프롬프트를 만듦
- 80ms+: ChatClient가 모델을 호출함
- 120ms+: 응답 문자열을 사용자에게 반환함

**한 줄 메모**:
- Day1의 핵심은 "AI를 똑똑하게 쓰는 것"보다 먼저 "AI를 내 앱에서 한번 연결해보는 것"이다.

---
## [2026-07-03] Q: `public String chat(@RequestParam String message)` 이게 Python으로는 뭘까

**질문**: 이게 python으로는 뭘까

**핵심 개념**:
- 메서드 선언: "이름이 chat인 함수고, 문자열 하나를 받아서 문자열 하나를 돌려준다"는 뜻
- `@RequestParam`: URL이나 요청값에서 `message`를 꺼내 함수 인자로 넣는 장치

**Python 비교**:
```python
def chat(message):
    return f"받은 값: {message}"
```

**Java/Spring 연결**:
```java
public String chat(@RequestParam String message) {
    return "받은 값: " + message;
}
```

**흐름 타임라인**:
- 0ms: 사용자가 `?message=안녕` 값을 보냄
- 10ms: Spring이 `message` 값을 꺼냄
- 20ms: `chat(message)` 메서드에 넣어줌
- 30ms: 메서드가 문자열을 반환함

**한 줄 메모**:
- Python 함수와 거의 같고, 차이는 Spring이 요청값을 자동으로 함수 인자에 꽂아준다는 점이다.

---
## [2026-07-03] Q: `@RequestParam` 설명

**질문**: @RequestParam 설명

**핵심 개념**:
- `@RequestParam`: URL의 쿼리스트링 값이나 요청 파라미터를 메서드 인자로 꺼내오는 장치
- 기본값: 값이 없을 때 `defaultValue`로 대신 넣을 수 있음

**Python 비교**:
```python
from flask import request

def chat():
    message = request.args.get("message")
    return message
```

**Java/Spring 연결**:
```java
@GetMapping("/api/chat")
public String chat(@RequestParam String message) {
    return message;
}
```

**흐름 타임라인**:
- 0ms: 사용자가 `?message=안녕` 요청
- 10ms: Spring이 `message` 값을 찾음
- 20ms: 메서드 파라미터에 자동으로 넣음
- 30ms: 메서드 실행

**한 줄 메모**:
- `@RequestParam`은 "URL에서 이 값 꺼내서 여기 넣어줘"라고 Spring에게 부탁하는 표식이다.

---
## [2026-07-03] Q: `request.args`가 이해 안 가

**질문**: request.args 이거 이해 안가

**핵심 개념**:
- `request.args`: URL 뒤 `?` 뒤에 붙은 값들을 담고 있는 상자
- key-value 구조: `message=안녕`, `days=3`처럼 이름과 값으로 들어감

**Python 비교**:
```python
# /chat?message=안녕&days=3
message = request.args.get("message")
days = request.args.get("days")
```

**Java/Spring 연결**:
```java
public String chat(@RequestParam String message) {
    return message;
}
```

**흐름 타임라인**:
- 0ms: 사용자가 `/chat?message=안녕&days=3` 요청
- 10ms: Flask/Spring이 `?` 뒤를 읽음
- 20ms: `message`, `days`를 이름표처럼 구분함
- 30ms: 필요한 값을 꺼내서 함수에 넣음

**한 줄 메모**:
- `request.args`는 URL 쿼리스트링 보관함이고, Spring의 `@RequestParam`은 그 보관함에서 값을 자동으로 꺼내주는 역할이다.

---
## [2026-07-03] Q: `private final`과 `public class`의 차이가 뭐야

**질문**: 애하고 public class의 차이가 뭐야? class는 파이썬처럼 class인 건 알아

**핵심 개념**:
- `public class`: 클래스 자체를 밖에서 볼 수 있게 여는 선언
- `private final`: 클래스 안에 있는 변수 하나에 대한 규칙 선언

**Python 비교**:
```python
class ChatService:
    def __init__(self, client):
        self._client = client  # private 비슷한 관례
```

**Java/Spring 연결**:
```java
public class ChatService {
    private final ChatClient chatClient;
}
```

**흐름 타임라인**:
- 0ms: 자바가 클래스를 읽음
- 10ms: `public class`로 이 클래스를 밖에서 쓸 수 있는지 판단
- 20ms: 클래스 안 필드를 읽음
- 30ms: `private final`로 이 변수를 어디서 접근/변경 가능한지 판단

**한 줄 메모**:
- `public class`는 "이 상자 자체를 공개할까?"이고, `private final`은 "상자 안 물건을 누가 만지고 바꿀 수 있나?"이다.

---
## [2026-07-03] Q: `chatService.chat(message)` 이게 어떻게 넘긴다는 거임?

**질문**: 이게 어떻게 넘긴다는 거임?

**핵심 개념**:
- 메서드 호출: `객체.메서드(값)` 형태로 다른 메서드에 값을 전달하는 문법
- 인자 전달: 괄호 안 `message`가 `chat(String message)`의 파라미터로 들어감

**Python 비교**:
```python
service.chat(message)
```

**Java/Spring 연결**:
```java
return chatService.chat(message);
```

**흐름 타임라인**:
- 0ms: Controller 안에 `message` 값이 들어있음
- 10ms: `chatService.chat(message)` 호출
- 20ms: Service의 `chat(String message)` 파라미터에 값이 들어감
- 30ms: Service 로직 실행

**한 줄 메모**:
- `chatService.chat(message)`는 "chatService야, 여기 message 값 줄 테니까 chat 함수 실행해줘"라는 뜻이다.

---
## [2026-07-03] Q: `.Builder builder` 이건 왜 이렇게 해?

**질문**: 이건 왜 이렇게 해?

**핵심 개념**:
- `ChatClient.Builder`: 완성품 `ChatClient`를 만들기 전에 설정을 담는 조립 도구
- 생성자 주입: Spring이 필요한 도구를 생성자에 넣어주고, 클래스는 그걸 받아 사용함

**Python 비교**:
```python
class ClientBuilder:
    def build(self):
        return "client"

builder = ClientBuilder()
client = builder.build()
```

**Java/Spring 연결**:
```java
public ChatService(ChatClient.Builder builder) {
    this.chatClient = builder.build();
}
```

**흐름 타임라인**:
- 0ms: Spring이 `ChatService`를 만들려고 함
- 10ms: 먼저 `ChatClient.Builder`를 준비함
- 20ms: 생성자에 `builder`를 넣어줌
- 30ms: `builder.build()`로 실제 `ChatClient` 생성
- 40ms: 이후부터 `chatClient`로 AI 호출

**한 줄 메모**:
- `Builder`는 완성품이 아니라 "조립 도구"이고, `build()`를 호출해야 실제 객체가 나온다.

---
## [2026-07-03] Q: `prompt()`는 프롬프트가 시작한다는 의미야? 전체적으로 이 코드들이 어떻게 돌아가?

**질문**: 프롬프트가 시작한다는 의미야?
전체적으로 이 코드들이 어떻게 돌아가?

**핵심 개념**:
- `prompt()`: AI에게 보낼 대화 한 묶음을 만들기 시작하는 출발점
- `user() -> call() -> content()`: 사용자 메시지 넣기 → 실제 호출하기 → 응답 본문 꺼내기 순서

**Python 비교**:
```python
message = "스프링 AI가 뭐야?"
payload = {"user": message}
response = call_ai(payload)
content = response["content"]
```

**Java/Spring 연결**:
```java
return chatClient.prompt()
        .user(message)
        .call()
        .content();
```

**흐름 타임라인**:
- 0ms: `prompt()`로 대화 한 세트를 만들 준비
- 10ms: `user()`로 사용자 질문 넣기
- 20ms: `call()`로 실제 AI 서버 호출
- 200ms+: AI가 응답 반환
- 210ms: `content()`로 답변 본문만 꺼냄

**한 줄 메모**:
- `prompt()`는 "대화 시작 버튼"이라기보다, "이번에 보낼 질문 꾸러미를 만들기 시작하는 첫 줄"에 가깝다.

---
## [2026-07-03] Q: 왜 최종적으로 우리가 실제로 쓸 건 `ChatClient`라고 해?

**질문**: 왜 이렇게 써?

**핵심 개념**:
- `Builder`는 만드는 도구이고, `ChatClient`는 실제로 일하는 완성품
- 필드에는 보통 "계속 사용할 완성 객체"를 저장하고, Builder는 생성 시점에만 잠깐 씀

**Python 비교**:
```python
builder = ClientBuilder()
client = builder.build()

# 이후 계속 쓰는 건 client
result = client.ask("안녕")
```

**Java/Spring 연결**:
```java
private final ChatClient chatClient;

public ChatService(ChatClient.Builder builder) {
    this.chatClient = builder.build();
}
```

**흐름 타임라인**:
- 0ms: Spring이 Builder 준비
- 10ms: 생성자에서 `build()` 호출
- 20ms: `ChatClient` 완성
- 30ms 이후: 실제 AI 호출은 계속 `chatClient`로 수행

**한 줄 메모**:
- Builder는 만드는 순간에만 필요하고, 진짜 질문을 보내는 건 완성된 `ChatClient`다.

---
## [2026-07-03] Q: `builder`는 어디에 만들어져 있어?

**질문**: 애는 어디에 만들어져있어?

**핵심 개념**:
- Spring이 자동 생성: `ChatClient.Builder`는 내가 직접 `new` 하지 않아도 Spring이 준비해줌
- 빈(Bean): Spring 컨테이너 안에 미리 만들어두고 필요할 때 주입하는 객체

**Python 비교**:
```python
# 내가 직접 만든 경우
builder = ClientBuilder()
service = ChatService(builder)
```

**Java/Spring 연결**:
```java
public ChatService(ChatClient.Builder builder) {
    this.chatClient = builder.build();
}
```

**흐름 타임라인**:
- 0ms: Spring Boot가 시작됨
- 10ms: Spring AI 자동설정이 실행됨
- 20ms: `ChatClient.Builder` 빈이 준비됨
- 30ms: `ChatService` 생성자 호출 시 builder를 넣어줌

**한 줄 메모**:
- `builder`는 내가 손으로 만든 게 아니라, Spring이 뒤에서 만들어놓고 생성자에 꽂아주는 객체다.

---
## [2026-07-03] Q: 2일차 정리해봐

**질문**: 2일차 정리해봐

**핵심 개념**:
- Prompt 설계: AI에게 질문만 던지는 게 아니라, 답의 대상과 형식을 같이 지시하는 것
- Structured Output: 문자열뿐 아니라 JSON, 객체, 리스트 형태로 응답을 받는 것

**Python 비교**:
```python
prompt = f"{audience}가 이해하기 쉽게 요약해줘: {text}"

result = {
    "category": "배송",
    "priority": "HIGH",
    "reason": "배송 지연 문의"
}
```

**Java/Spring 연결**:
```java
return chatClient.prompt()
        .user(u -> u.text("{audience}가 이해하기 쉽게 요약해줘: {text}")
                .param("audience", audience)
                .param("text", text))
        .call()
        .content();
```

**흐름 타임라인**:
- 0ms: 사용자가 요청과 파라미터 전송
- 10ms: Controller가 값을 받음
- 20ms: Service가 프롬프트 템플릿 작성
- 30ms: `param()`으로 실제 값 치환
- 80ms+: AI 호출
- 120ms+: 문자열/객체/리스트 형태로 응답 변환

**한 줄 메모**:
- Day2의 핵심은 "AI를 부른다"에서 끝나지 않고, "원하는 모양으로 답하게 만든다"까지 간 것이다.

---
## [2026-07-03] Q: `ch03-prompt` 프로젝트를 분석해서 교육자료로 쓰자

**질문**: C:\Users\금정산2-PC02\p2-spring\spring-ai-study\ch03-prompt 여기 들어가서 분석해서 교육자료로 쓰자

**핵심 개념**:
- 프롬프트 기법 모음: prompt-template, multi-messages, zero-shot, few-shot, role-assignment, step-back, chain-of-thought, self-consistency를 각각 예제로 분리해둔 학습용 프로젝트
- Controller + Service + HTML 데모 구조: 버튼/폼으로 질문을 보내고, 각 Service가 다른 프롬프트 전략으로 AI를 호출함

**Python 비교**:
```python
def zero_shot(review):
    prompt = f"리뷰를 긍정/중립/부정으로 분류해줘: {review}"
    return call_ai(prompt)

def few_shot(order):
    prompt = f"예시를 보고 JSON으로 바꿔줘: {order}"
    return call_ai(prompt)
```

**Java/Spring 연결**:
```java
@PostMapping("/zero-shot-prompt")
public String zeroShotPrompt(@RequestParam("review") String review) {
    return aiService.zeroShotPrompt(review);
}
```

**흐름 타임라인**:
- 0ms: 사용자가 홈 화면에서 기법 선택
- 10ms: 해당 HTML 페이지가 열림
- 20ms: 폼 입력 후 `/ai/...` 엔드포인트 호출
- 30ms: Controller가 Service 메서드 실행
- 50ms: Service가 각 프롬프트 기법으로 AI 호출
- 200ms+: 응답을 문자열/스트림으로 반환

**한 줄 메모**:
- 이 프로젝트는 "Spring AI로 어떤 프롬프트 기법을 어떻게 코드에 옮기는지"를 데모별로 보여주는 교재형 프로젝트다.

---
## [2026-07-03] Q: 어제부터 오늘까지 한 내용을 한 눈에 시각화하고 싶은데 어떻게 하면 좋을까?

**질문**: 자 이제 어제부터 오늘까지 한 내용을 한 눈에 시각화하고 싶은데 어떻게 하면 좋을까?

**핵심 개념**:
- 학습 시각화: 시간순 흐름, 개념 지도, 프로젝트 구조를 한 장에 나누어 보여주면 복습이 쉬움
- 한 장 요약: "무엇을 배웠는지"보다 "어떻게 연결되는지"를 보이게 만드는 것이 중요함

**Python 비교**:
```python
study_map = {
    "Day1": ["Controller", "Service", "ChatClient"],
    "Day2": ["Prompt", "JSON", "record", "List"]
}
```

**Java/Spring 연결**:
```java
Controller -> Service -> ChatClient -> AI Response
```

**흐름 타임라인**:
- 0ms: 학습 내용을 날짜별로 나눔
- 10ms: 공통 흐름과 기능별 예제를 분리함
- 20ms: 다이어그램/표/로드맵 중 한 형식 선택
- 30ms: 핵심만 남겨 한 장 요약 제작

**한 줄 메모**:
- 지금 단계에서는 "전체 로드맵 1장 + 코드 흐름 1장" 조합이 가장 복습 효율이 좋다.

---
## [2026-07-03] Q: 어제부터 오늘까지 내용을 시각화하고 PPT도 만들고 싶어

**질문**: 응 그리고 PPT도 만들어.

**핵심 개념**:
- Markdown 시각화: Mermaid와 표로 흐름을 한눈에 정리
- 발표 자료화: 같은 구조를 PPT 슬라이드로 옮겨서 복습과 발표에 모두 쓰기

**Python 비교**:
```python
summary = {
    "roadmap": ["Day1", "Day2"],
    "slides": ["전체 흐름", "기능 비교", "문제 정리"]
}
```

**Java/Spring 연결**:
```java
Controller -> Service -> ChatClient -> Response
```

**흐름 타임라인**:
- 0ms: 어제/오늘 학습 내용을 범주별로 묶음
- 10ms: Markdown 시각화 초안 작성
- 20ms: 발표용 슬라이드 목차 구성
- 30ms: PPT 파일 생성

**한 줄 메모**:
- 복습용은 Markdown, 발표용은 PPT로 같은 구조를 두 번 재사용하는 게 효율적이다.

---
## [2026-07-03] Q: PPT를 팔란티어 스타일로 만들어줘

**질문**: 잠시만 PPT 팔란티어 스타일로 만들어줘.

**핵심 개념**:
- 슬라이드 톤앤매너: 같은 내용도 색, 여백, 카드 구조를 바꾸면 발표 인상이 달라짐
- 정보형 디자인: 짙은 배경 + 청록 포인트 + 짧은 문장 중심 구성이 학습 발표에 잘 맞음

**Python 비교**:
```python
theme = {
    "background": "dark",
    "accent": "teal",
    "layout": "clean cards"
}
```

**Java/Spring 연결**:
```java
Controller -> Service -> ChatClient
```

**흐름 타임라인**:
- 0ms: 기존 PPT 구조 확인
- 10ms: 디자인 톤을 다크/정보형으로 재설계
- 20ms: 생성 스크립트 수정
- 30ms: 새 스타일로 PPT 재생성

**한 줄 메모**:
- 발표 자료는 내용 정리와 별개로, 톤을 통일해주면 훨씬 더 “정리된 프로젝트”처럼 보인다.

---
## [2026-07-03] Q: PPT가 안 바뀐 것 같으니 팔란티어 스타일로 확실히 다시 만들어줘

**질문**: PPT 안 바꼈는데? 뭐가 바꼈다는 거야. 팔란티어 스타일로 만들어.

**핵심 개념**:
- 결과 확인: 파일 생성 후 크기와 수정 시각을 확인해야 실제 반영 여부를 알 수 있음
- 스타일 재설계: 기본 템플릿 느낌을 없애고, 정보 상황판형 레이아웃으로 다시 구성

**Python 비교**:
```python
deck_style = {
    "background": "near-black",
    "visuals": ["grid", "nodes", "metrics", "matrix"],
    "accent": "cyan"
}
```

**Java/Spring 연결**:
```java
Controller -> Service -> ChatClient -> AI
```

**흐름 타임라인**:
- 0ms: 기존 PPT가 눈에 띄게 바뀌지 않은 문제 확인
- 10ms: PPT 생성 스크립트 전면 재작성
- 20ms: 어두운 배경, 격자, 노드 맵, 기능 매트릭스 구성
- 30ms: 기존 파일과 새 스타일 파일을 모두 재생성
- 40ms: 파일 크기와 수정 시각으로 변경 확인

**한 줄 메모**:
- 시각 자료는 “생성했다”보다 “실제로 열었을 때 달라 보이는가”가 더 중요하다.

---
## [2026-07-03] Q: 오늘 자습 내용으로 `ch03-prompt` 프로젝트 분석을 누적 기록해줘

**질문**: 아니 오늘 자습내용이야. 누적기록해.

**핵심 개념**:
- `ch03-prompt`: Spring AI 프롬프트 기법을 기능별 데모로 모아둔 자습용 프로젝트
- 오늘 자습 포인트: Day1/Day2에서 배운 `Controller -> Service -> ChatClient` 흐름을 여러 프롬프트 전략에 적용해보기

**Python 비교**:
```python
def prompt_template(text, language):
    prompt = f"{text}를 {language}로 번역해줘"
    return call_ai(prompt)

def few_shot(order):
    examples = ["예시1", "예시2"]
    return call_ai(examples + [order])
```

**Java/Spring 연결**:
```java
@PostMapping("/ai/prompt-template")
public Flux<String> promptTemplate(@RequestParam String statement,
                                   @RequestParam String language) {
    return aiService.promptTemplate1(statement, language);
}
```

**흐름 타임라인**:
- 0ms: `ch03-prompt` 프로젝트 구조 확인
- 10ms: `HomeController`가 각 HTML 화면을 연결하는 구조 파악
- 20ms: 각 `AiController...`가 `/ai/...` 요청을 받는 구조 확인
- 30ms: 각 `AiService...`가 서로 다른 프롬프트 기법으로 `ChatClient`를 호출하는 구조 분석
- 40ms: `prompt-template`, `multi-messages`, `zero-shot`, `few-shot`, `role-assignment`, `step-back`, `chain-of-thought`, `self-consistency`를 자습 항목으로 정리

**오늘 자습 정리**:
- `prompt-template`: 빈칸이 있는 프롬프트 틀을 만들고 값만 바꿔 끼우는 방식
- `multi-messages`: 이전 대화 내용을 `chatMemory`로 보관해서 이어서 대화하는 방식
- `default-method`: `ChatClient.Builder`에 기본 시스템 메시지와 옵션을 미리 설정하는 방식
- `zero-shot-prompt`: 예시 없이 바로 분류나 작업을 시키는 방식
- `few-shot-prompt`: 예시를 몇 개 보여준 뒤 같은 형식으로 답하게 하는 방식
- `role-assignment`: AI에게 여행 가이드 같은 역할을 부여하고 답하게 하는 방식
- `step-back-prompt`: 큰 질문을 작은 질문들로 쪼갠 뒤 단계적으로 답을 만드는 방식
- `chain-of-thought`: 생각 과정을 단계적으로 풀어 쓰게 하는 방식
- `self-consistency`: 같은 질문을 여러 번 던져 다수결로 더 안정적인 답을 고르는 방식

**한 줄 메모**:
- 오늘 자습은 `ch03-prompt`를 통해 “같은 ChatClient라도 프롬프트 전략이 달라지면 AI의 답변 방식이 달라진다”는 점을 확인한 시간이다.

---
## [2026-07-03] Q: `prompt()` 같은 건 Spring이 제공하는 거야? 우리가 정의한 거야?

**질문**: 이런 함수가 Spring에서 제공하는 거야? 아니면 우리가 정의한 거야?

**핵심 개념**:
- 라이브러리 메서드: `prompt()`, `user()`, `call()`, `content()`는 Spring AI가 제공하는 기능
- 사용자 정의 메서드: `chat()`, `classify()`처럼 우리가 직접 클래스 안에 선언한 함수

**Python 비교**:
```python
def chat(message):
    return message.upper()

text = "hello"
result = text.upper()
```

**Java/Spring 연결**:
```java
public String chat(String message) {
    return chatClient.prompt()
            .user(message)
            .call()
            .content();
}
```

**흐름 타임라인**:
- 0ms: 우리가 만든 `chat()` 메서드 시작
- 10ms: Spring AI의 `prompt()` 호출
- 20ms: Spring AI의 `user()` 호출
- 30ms: Spring AI의 `call()` 호출
- 40ms: Spring AI의 `content()` 호출

**한 줄 메모**:
- 내가 직접 선언한 건 내 함수고, `import`해온 객체가 제공하는 메서드는 보통 라이브러리 함수다.

---
## [2026-07-03] Q: 라이브러리 함수와 내가 만든 함수를 코드에서 어떻게 구분해?

**질문**: 응

**핵심 개념**:
- 함수 선언 위치: 내 파일 안에 `public String ...`처럼 선언돼 있으면 내가 만든 함수
- 객체의 메서드: `chatClient.prompt()`처럼 점 앞 객체가 제공하면 라이브러리 메서드일 가능성이 큼

**Python 비교**:
```python
def chat(message):
    return message.upper().strip()
```

**Java/Spring 연결**:
```java
public String chat(String message) {
    return chatClient.prompt()
            .user(message)
            .call()
            .content();
}
```

**흐름 타임라인**:
- 0ms: 내가 만든 `chat()` 실행
- 10ms: 내부에서 라이브러리 메서드 `prompt()` 사용
- 20ms: `user()`, `call()`, `content()` 순서로 실행
- 40ms: 최종 결과를 내 메서드가 반환

**한 줄 메모**:
- 코드에서 "누가 선언했는가"를 보면 내 함수인지 라이브러리 함수인지 구분할 수 있다.

---
## [2026-07-03] Q: `chatClient` 자체는 어디서 왔는지 알려줘

**질문**: 응 알려줘. 그리고 지금 너가 준 답변이랑 내가 한 질문 STUDY_LOG.md에 넣을 수 있어?

**핵심 개념**:
- `ChatClient`: Spring이 준비해서 넣어주는 AI 호출 객체
- `ChatClient.Builder`: 그 `ChatClient`를 만들기 위한 조립 도구

**Python 비교**:
```python
builder = ClientBuilder()
client = builder.build()
service = ChatService(client)
```

**Java/Spring 연결**:
```java
private final ChatClient chatClient;

public ChatService(ChatClient.Builder builder) {
    this.chatClient = builder.build();
}
```

**흐름 타임라인**:
- 0ms: Spring Boot 시작
- 10ms: Spring AI 자동설정 실행
- 20ms: `ChatClient.Builder` 준비
- 30ms: `ChatService` 생성자 호출
- 40ms: `builder.build()`로 `chatClient` 생성
- 50ms 이후: `chatClient`로 실제 AI 호출

**한 줄 메모**:
- `chatClient`는 내가 직접 만든 게 아니라, Spring이 준비해 준 AI 호출 도구다.
