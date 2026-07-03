# Day 1 학습 기록

## 1. 오늘 학습의 큰 흐름

오늘 학습은 단순히 Spring AI만 따로 보는 방식이 아니라, 지금까지 배운 기술들을 하나의 흐름으로 다시 묶는 방식으로 정리했습니다.

```text
Python
→ 데이터 처리 흐름 이해

SQL
→ 근거 데이터 조회

ML/DL
→ LLM, 임베딩, RAG의 원리 이해

Java
→ Spring 계열 코드 작성 언어

Spring Boot
→ 웹 API 서버 구조

React
→ 사용자 화면과 API 호출

Spring AI
→ 위 구조 안에서 LLM을 실제 서비스 기능으로 연결
```

핵심 메시지는 다음과 같았습니다.

```text
Spring AI는 완전히 새로운 세계가 아니라,
지금까지 배운 기술을 AI 기능으로 연결하는 마지막 조각이다.
```

## 2. 기초 개념 복습 정리

### Python

Python은 다음 흐름으로 정리했습니다.

```text
데이터를 받는다
→ 변수에 담는다
→ 조건/반복으로 처리한다
→ 함수로 묶는다
→ 클래스/모듈로 구조화한다
→ 파일/DB/API/AI 모델과 연결한다
→ 결과를 반환한다
```

이 흐름은 나중에 Spring Boot와 Spring AI 구조를 이해하는 기반으로 연결했습니다.

### SQL

SQL은 AI가 참고할 실제 근거 데이터를 꺼내는 기술로 설명했습니다.

- `SELECT`: 조회
- `WHERE`: 조건 필터링
- `JOIN`: 여러 테이블 연결
- `GROUP BY`: 집계

Spring AI 관점에서는 다음처럼 연결했습니다.

```text
사용자 질문
→ DB에서 관련 데이터 조회
→ 조회 결과를 프롬프트에 포함
→ LLM이 근거 기반 답변 생성
```

### ML/DL

ML/DL은 직접 모델을 학습시키는 관점보다, 이미 학습된 모델을 사용하는 관점으로 정리했습니다.

- 학습과 추론의 차이
- LLM의 의미
- 임베딩과 벡터 검색
- RAG와 환각

핵심은 다음과 같았습니다.

```text
Spring AI 개발자는 보통 모델을 직접 학습시키는 사람이 아니라,
이미 학습된 모델을 서비스 맥락에 맞게 잘 호출하고 제어하는 사람이다.
```

### Java

Java는 객체 중심 구조로 설명했습니다.

- `class`
- `object`
- `method`
- `constructor`
- `interface`
- `record`
- `annotation`

Spring 코드를 읽기 위한 준비로 `Controller`, `Service`, `DTO`의 감각을 같이 연결했습니다.

### Spring Boot

Spring Boot는 다음 흐름으로 설명했습니다.

```text
사용자가 요청을 보낸다
→ Controller가 요청을 받는다
→ DTO에 요청 데이터가 담긴다
→ Service가 핵심 로직을 처리한다
→ Repository가 DB와 통신한다
→ 결과를 반환한다
```

그리고 `DI`, `Bean`, `application.yml`의 의미를 함께 정리했습니다.

### React

React는 사용자 입력을 받아 API를 호출하고 화면을 갱신하는 역할로 정리했습니다.

- Component
- JSX
- Props
- State
- Event
- fetch
- useEffect

특히 다음 연결을 강조했습니다.

```text
React
→ 질문 입력
→ Spring Boot API 호출
→ 응답 수신
→ 화면 업데이트
```

## 3. 개념 질문 정리

### POJO

POJO는 Plain Old Java Object로, 프레임워크에 강하게 묶이지 않은 평범한 자바 객체라고 정리했습니다.

### 기업용 Java

기업용 Java는 대형 업무 시스템을 위한 Java 생태계이며, Spring은 이를 더 쉽게 만들기 위한 대표적인 프레임워크라고 정리했습니다.

## 4. Day 1 프로젝트 목표

수업 PDF의 35-37쪽 요구사항을 확인했습니다.

핵심 과제는 다음과 같았습니다.

- `ChatClient` 패턴으로 미니 도구 만들기
- 4개 후보 중 최소 2개 완성
- README 정리
- 응답 캡처
- GitHub push

후보 예시는 다음과 같았습니다.

- 코드 설명 도우미
- README 생성 도우미
- 면접 질문 생성기
- 기업 FAQ 응답기

최소 제출 조건을 만족시키기 위해 다음 2개를 우선 구현했습니다.

- 코드 설명 도우미
- 면접 질문 생성기

## 5. 개발 환경 문제 해결 기록

### Java 21 문제

프로젝트 실행이 처음 실패한 원인은 Gradle이 `Java 21` toolchain을 요구하는데, 시스템이 다른 JDK를 가리키고 있었기 때문이었습니다.

진단 흐름은 다음과 같았습니다.

- `build.gradle`에서 `JavaLanguageVersion.of(21)` 확인
- 현재 `JAVA_HOME`과 `java -version` 확인
- IntelliJ의 Project SDK와 Gradle JVM 상태 확인

해결 과정은 다음과 같았습니다.

- 설치된 JDK 21 위치 확인
- Gradle과 IntelliJ가 JDK 21을 보도록 설정
- `C:\jdk21` 경로를 사용해 한글 사용자 경로 문제를 우회

### API 키 문제

서버가 떠도 `/api/chat` 요청이 500으로 실패했던 원인은 `GOOGLE_API_KEY`가 없거나 올바르지 않았기 때문이었습니다.

로그의 핵심 메시지는 다음과 같았습니다.

```text
API key not valid. Please pass a valid API key.
```

즉 실행환경 문제와 코드 문제를 분리해서 확인하는 과정을 함께 경험했습니다.

## 6. 백엔드 구조 구현

### Day01Application

`Day01Application`은 Spring Boot 실행 진입점입니다.

```text
main()
→ SpringApplication.run()
→ 서버 실행
```

### ChaViewController

`/chat` 요청을 받으면 `chat.html`을 반환하도록 구성했습니다.

```text
/chat
→ templates/chat.html
```

### ChatController

`ChatController`는 URL과 기능을 연결합니다.

- `/api/chat`
- `/api/teacher`
- `/api/safe-chat`
- `/api/code-explain`
- `/api/interview-questions`

즉 Controller는 어떤 주소가 어떤 Service 메서드로 이어지는지를 정의하는 역할입니다.

### ChatService

`ChatService`는 실제 Spring AI 호출을 담당합니다.

기본 패턴은 다음과 같습니다.

```java
chatClient.prompt()
        .system("역할 지시")
        .user("사용자 입력")
        .call()
        .content();
```

이 패턴을 기능별로 다르게 구성했습니다.

#### 1. 일반 채팅

사용자 질문만 전달하는 기본 모드입니다.

#### 2. 선생님 모드

Java, Spring Boot, Spring AI를 설명하는 선생님 역할을 `system()`으로 부여했습니다.

#### 3. 안정 응답

`temperature(0.2)`를 사용해 더 안정적인 성향의 답변을 유도했습니다.

#### 4. 코드 설명 도우미

코드의 목적, 실행 흐름, 핵심 문법, 주의점을 초보자 관점으로 설명하도록 프롬프트를 설계했습니다.

#### 5. 면접 질문 생성기

기술 스택을 입력하면 예상 질문과 답변 방향을 생성하도록 프롬프트를 설계했습니다.

## 7. UI 통합 전 상태

초기 `chat.html`은 기본 채팅 UI였고, 실제로는 `/api/chat` 하나만 호출하고 있었습니다.

즉 백엔드에는 여러 엔드포인트가 있었지만, 프론트는 일반 채팅만 연결된 상태였습니다.

## 8. UI 통합 작업

이후 `chat.html`을 멀티 툴 통합 UI로 개편했습니다.

### 통합한 모드

- 일반 채팅
- 선생님 모드
- 안정 응답
- 코드 설명
- 면접 질문

### UI 개편 방향

- 왼쪽에 모드 선택 패널 배치
- 오른쪽에 설명 카드, 대화 영역, 입력 영역 배치
- 현재 모드에 따라 안내 문구와 placeholder 변경
- 모드에 따라 호출 API 주소 자동 전환

### 프론트 동작 방식

JavaScript에서 모드 정보를 객체로 관리합니다.

```text
현재 모드 선택
→ 해당 엔드포인트 결정
→ message를 URL 파라미터로 인코딩
→ fetch 호출
→ 응답을 대화 영역에 출력
```

즉 프론트엔드도 이제 백엔드의 여러 기능을 실제로 사용할 수 있는 상태로 바뀌었습니다.

## 9. 최종 프로젝트 전체 흐름

최종적으로 오늘 프로젝트의 전체 흐름은 다음과 같습니다.

```text
Spring Boot 서버 실행
→ application.yaml에서 Gemini 설정 로드
→ 사용자가 /chat 접속
→ 통합 UI에서 원하는 모드 선택
→ 메시지 입력 후 전송
→ JavaScript가 해당 /api/... 주소 호출
→ ChatController가 요청 받음
→ ChatService가 ChatClient로 Gemini 호출
→ system prompt + user prompt 조합
→ Gemini 응답 생성
→ 브라우저에 결과 표시
```

## 10. 오늘 학습의 핵심 정리

오늘 가장 중요했던 개념은 다음 세 가지입니다.

### 1. Spring AI는 연결 기술입니다

Spring AI는 모델 자체를 새로 만드는 기술이 아니라, Spring Boot 서비스 안에서 LLM을 연결해 기능으로 만드는 기술입니다.

### 2. 같은 모델도 프롬프트에 따라 다른 도구가 됩니다

같은 Gemini 모델이라도 `system()`에 어떤 역할을 주느냐에 따라 완전히 다른 기능처럼 동작할 수 있음을 확인했습니다.

### 3. 백엔드와 프론트가 함께 완성되어야 실제 도구가 됩니다

엔드포인트만 만드는 것으로 끝나지 않고, 사용자가 실제로 선택하고 입력할 수 있는 UI를 붙이면서 프로젝트가 더 완성형으로 보이게 되었습니다.

## 11. 현재 레포 기준 주요 파일

- `build.gradle`
- `application.yaml`
- `src/main/java/com/study/day01/Day01Application.java`
- `src/main/java/com/study/day01/ChaViewController.java`
- `src/main/java/com/study/day01/ChatController.java`
- `src/main/java/com/study/day01/ChatService.java`
- `src/main/resources/templates/chat.html`
- `README.md`

## 12. 다음에 이어서 해볼 수 있는 주제

- 모드별 응답을 카드 형태로 더 보기 좋게 구조화하기
- `/api/teacher`, `/api/code-explain` 등에 JSON 응답 구조 적용하기
- 대화 기록 저장 기능 붙이기
- Markdown 렌더링 지원하기
- RAG용 문서 검색 기능 연결하기

## 13. 한 줄 결론

오늘은 Spring AI의 `ChatClient`를 이용해 하나의 LLM을 여러 도구처럼 분리해 사용하는 구조를 직접 만들고, 그것을 하나의 통합 UI에서 전환해 사용하는 미니 프로젝트를 완성한 날이었습니다.
