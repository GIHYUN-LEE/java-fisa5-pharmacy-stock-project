# 💊 창고형 약국 시스템 (Warehouse Pharmacy System)

> 자바 콘솔로 구현한 약국 재고 관리 프로그램
> 
> 
> 약의 입고, 출고, 조회, 수정 기능을 통해 **간단한 재고 시스템**을 경험할 수 있습니다.
> 

---

## 👥팀원
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/menzzi">
        <img src="https://github.com/menzzi.png" width="100px;" alt="menzzi"/><br />
        <sub><b>서민지</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/shin-kibeom">
        <img src="https://github.com/shin-kibeom.png" width="100px;" alt="shin-kibeom"/><br />
        <sub><b>신기범</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/shinjunsuuu">
        <img src="https://github.com/shinjunsuuu.png" width="100px;" alt="shinjunsuuu"/><br />
        <sub><b>신준수</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/GIHYUN-LEE">
        <img src="https://github.com/GIHYUN-LEE.png" width="100px;" alt="GIHYUN-LEE"/><br />
        <sub><b>이기현</b></sub>
      </a>
    </td>
  </tr>
</table>

---



## 🧾 프로젝트 개요

- **개발 환경**: Java 17+, JDK 설치 필수
- **실행 방식**: 콘솔 기반 메뉴 입력
- **사용 기술**: Java, OOP, MVC 패턴, Git 협업
- **참여 인원**: 4인 팀 프로젝트

---

## ✏️ 기능

### 1️⃣ 삽입 (약 추가)

- 사용자로부터 약 이름과 개수 입력 받기
    - 존재하지 않는 약이면 `Medicine` 객체를 생성하여 DB(Map)에 추가
    - 이미 있는 약이면 기존 재고에 수량 추가 (동일 이름 중복 X)
    - 예외 처리: 이미 존재하는 약에 대해 중복 생성 방지
    - 입력 유효성 검증

### 2️⃣ 삭제 (약 제거)

- 사용자로부터 약 이름 입력 받기
    - 저장소(Map)에서 해당 약 검색 후 재고 삭제
    - 예외 처리:
        - 존재하지 않는 약일 경우 → `"창고에 없는 약입니다."`

### 3️⃣ 재고 수량 변경

- 사용자로부터 수정할 약 이름 입력 받기
    - 존재하는 약일 경우 재고 수량 수정 가능
    - 예외 처리:
        - 없는 약일 경우 → `"약이 존재하지 않습니다."`
        - 플러스 수량 입력시 → 재고 추가
        - 마이너스 수량 입력 시 → 재고 삭제 (총 재고 개수가 음수가 되면 `“수량이 부족합니다”`)

### 4️⃣ 약 정보 수정

- 사용자로부터 수정할 약 이름 입력 받기
    - 존재하는 약일 경우 약 정보 수정 가능
    - 예외 처리:
        - 없는 약일 경우 → `"약이 존재하지 않습니다."`
        - 있는 약일 경우
            - 사용자로부터 새로운 약 이름 입력 받기
                - 엔터 입력 시 기존 이름 유지
            - 사용자로부터 새로운 수량 입력 받기
                - 예외 처리:
                    - 음수 입력 시 → `"수량은 음수가 될 수 없습니다."`
                - 0 입력 시 기존 수량 유지
            - 사용자로부터 새로운 가격 입력 받기
                - 예외 처리:
                    - 음수 입력 시 → `"가격은 음수가 될 수 없습니다."`
                - 0 입력 시 기존 가격 유지
        - 기존 약 정보 수정 성공 시 → `"약 수정 완료: 타이레놀 20개 5000원"`

### 5️⃣ 조회

- 전체 약 목록 출력
    - 특정 약 이름 기준 검색 가능
    - (선택) 정렬 기능: 이름순, 개수순
    - (선택) 특정 수량 이하 약 목록 출력 → 자동 구매 유도 기능 등으로 확장 가능

---

## ⚙️ 주요 기능 요약

| 기능 | 설명 |
| --- | --- |
| ➕ 약 추가 | 약 이름과 개수를 입력받아 재고에 추가 |
| ➖ 약 삭제 | 약 이름을 입력받아 재고에서 삭제
※ 보유 수량보다 많이 삭제 시 예외 처리 |
| 🔍 약 조회 | 전체 약 목록 조회 또는 특정 약 이름으로 검색 |
| 🛠️ 약 수정 | 약 이름 또는 개수 변경 가능 |
| ❌ 종료 | 프로그램 종료 |

---

## 🧱 프로젝트 구조 (MVC 기반)

```
📁 controller/
├── Controller.java
├── EditMedicineInfo.java
├── InsertDeleteMedicine.java
├── SearchMedicine.java
└── UpdateMedicineStock.java

📁 domain/
└── Medicine.java

📁 model/
├── Database.java
└── Model.java

📁 view/
├── EditInfoView.java
├── InputView.java
├── InsertDeleteView.java
├── OutputView.java
├── SearchView.java
└── StartView.java
```

---

## 🧑‍💻 팀원 역할

| 팀원 | 담당 기능 | 주요 작업 |
| --- | --- | --- |
| 서민지 | 삭제 & 제거 (InsertDelete) | 삭제 기능 구현, 예외처리, 입력 검증 |
| 신기범 | 재고 수량 변경 (Update) | 재고 수정 로직, 음수 처리, 예외처리 |
| 이기현 | 조회 (Search) | 목록 출력, 검색 기능 구현 |
| 신준수 | 기본 정보 수정 (Edit) | 기본 정보 수정 기능, UI 연결, 예외 처리 |

---

## 🚀 실행 방법

1. Java IDE 또는 CLI에서 프로젝트 폴더 열기
2. `StartView.java` 실행
3. 콘솔에서 메뉴 선택

```
╭ ◜◝ ͡ ◜◝ ͡  ◜◝ ͡ ◜◝ ͡  ◜◝ ╮
        💊  M Y          
    P H A R M A C Y  🏥   
╰ ◟◞ ͜  ◟ ͜   ◟◞ ͜  ◟ ͜ ◟◞ ╯
                      O
                    °
===== 창고형 약국 시스템 =====
1. 약 삽입
2. 약 삭제
3. 약 수량 변경
4. 약 정보 변경
5. 약 조회
0. 프로그램 종료
```

---

## 📌 향후 개선 예정 기능

- 💾 파일 입출력 (종료 후에도 데이터 저장)
- 📊 약 개수 기준 정렬 및 검색 필터
- 📈 재고 부족 알림 기능

## 🗄️ 데이터베이스 연동 (DB Schema)

### 💊 Medicine 테이블

| 컬럼명 | 타입 | 제약 조건 |  |
| --- | --- | --- | --- |
| name | VARCHAR(50) | PRIMARY KEY |  |
| price | INT | NOT NULL |  |
| amount | INT | NOT NULL |  |

```sql
CREATE TABLE Medicine (
  name VARCHAR(50) PRIMARY KEY,
  price INT NOT NULL,
  amount INT NOT NULL
);

```

---

### 👤 User 테이블

| 컬럼명 | 타입 | 제약 조건 |
| --- | --- | --- |
| id | INT | PRIMARY KEY, AUTO_INCREMENT |
| name | VARCHAR(50) | NOT NULL |
| role | VARCHAR(20) | NOT NULL, DEFAULT 'user' |

```sql
CREATE TABLE User (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  role VARCHAR(20) NOT NULL DEFAULT 'user'
);
```

---

## ⚙️ MySQL 선택 이유

### 🚀 성능과 확장성 측면에서 소규모 시스템에 적합

- MySQL은 **읽기 중심 애플리케이션** 및 **빠른 CRUD 연산**에 최적화
- Oracle DB는 **대규모 트랜잭션 처리**와 **복잡한 쿼리, 분산 시스템**에 강점

> 따라서 약국 재고 관리 시스템처럼 단순 삽입과 조회가 주를 이루는 서비스에는
> 
> 
> MySQL이 가볍고 빠르며 적합한 선택이라 판단.
>
