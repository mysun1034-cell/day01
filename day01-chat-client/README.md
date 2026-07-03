# Spring AI Day 1 - ChatClient Mini Tools

Spring AI `ChatClient`의 `.system()`, `.user()`, `.call()` 패턴을 사용해 만든 Day 1 학습용 미니 프로젝트입니다.

## UI 구성 화면

![UI 구성](images/capture.PNG)

## 프로젝트 개요

이 프로젝트는 하나의 Gemini 모델을 여러 역할로 나누어 사용하는 연습을 목표로 합니다.

- 일반 채팅
- 선생님 모드
- 안정 응답 모드
- 코드 설명 도우미
- 면접 질문 생성기

현재 `/chat` 화면에서는 위 기능들을 하나의 통합 UI에서 전환해 사용할 수 있습니다.

## 실행 방법

Google GenAI API 키를 환경변수로 설정한 뒤 실행합니다.

```powershell
$env:GOOGLE_API_KEY="본인_API_KEY"
.\gradlew.bat bootRun
```

기본 접속 주소는 다음과 같습니다.

```text
http://localhost:8080/chat
```

## API 엔드포인트

### 1. 일반 채팅

```text
GET /api/chat?message=안녕
```

### 2. 선생님 모드

```text
GET /api/teacher?message=POJO가 뭐야?
```

### 3. 안정 응답

```text
GET /api/safe-chat?message=Spring AI 학습 순서를 5줄로 정리해줘
```

### 4. 코드 설명 도우미

```text
GET /api/code-explain?message=public class User { private String name; }
```

### 5. 면접 질문 생성기

```text
GET /api/interview-questions?message=Java, Spring Boot, Spring AI
```

## 코드 구조

- `src/main/java/com/study/day01/Day01Application.java`: Spring Boot 실행 진입점
- `src/main/java/com/study/day01/ChaViewController.java`: `/chat` 화면 반환
- `src/main/java/com/study/day01/ChatController.java`: API 엔드포인트 연결
- `src/main/java/com/study/day01/ChatService.java`: Spring AI `ChatClient` 호출 로직
- `src/main/resources/templates/chat.html`: 통합 멀티 툴 UI
- `src/main/resources/application.yaml`: Gemini 모델 및 API 키 설정

## 학습 기록

오늘 학습 내용 전체 정리는 아래 문서에 기록했습니다.

- [Day 1 학습 기록](docs/day01-study-log.md)
