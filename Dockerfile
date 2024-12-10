# 첫 번째 스테이지: 빌드 스테이지
FROM maven:3.8.6-openjdk-17 AS builder

# 작업 디렉토리 설정
WORKDIR /app

# pom.xml 파일 복사 (Maven 프로젝트의 경우 필수)
COPY pom.xml .

# 의존성 다운로드
RUN mvn clean install -DskipTests

# 소스 코드 복사
COPY src /app/src

# WAR 파일 빌드
RUN mvn package -DskipTests

# 두 번째 스테이지: 실행 스테이지
FROM openjdk:17-slim

# 작업 디렉토리 설정
WORKDIR /app

# 첫 번째 스테이지에서 빌드된 WAR 파일 복사
COPY --from=builder /app/target/your-app.war app.war

# 내장 톰캣을 사용하여 실행 (JAR처럼 실행)
ENTRYPOINT ["java", "-jar", "app.war"]