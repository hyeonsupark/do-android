# 안드로이드 프로젝트 구조

## 프로젝트 생성
1. 새 프로젝트 생성: File -> New -> New Project
 - Application Name: 어플리케이션 이름 (ex: `GoodApp`)
 - Company Domain: 회사 도메인 또는 자신의 도메인 (ex: `soh.ee`)
 - Package Name: 패키지 명(ex: `ee.soh.goodapp`)
 - Project Location: 자신이 원하는 프로젝트 경로

2. 플랫폼 선택 및 Min SDK 선택
 - 스마트폰 어플리케이션은 `Phone and Tablet` 체크
 
3. 기본 액티비티 선택
 - 여러 액티비티가 있지만 기본적으론 `Blank Activity`
 
4. 액티비티 설정
 - ActivityName: 액티비티 이름 / 자바 코드의 클래스가 되므로 자바 클래스 네이밍 규칙을 따름(ex: MainActivity)
 - LayoutName: 레이아웃 이름 / Xml 파일로 보통 컴포넌트_이름의 구조를 가짐 (ex: activity_main)
 
## 프로젝트 구조 살펴보기

 - app : 스마트폰 어플리케이션 모듈
 
  ```
  Project
  ㄴ Module(app)
    ㄴ java
    ㄴ res
    ㄴ manifests
  ㄴ Module(wear)
  Gradle Scripts
 ```
 
 - java/com.example : 자바 코드가 있는 폴더
 - res/ : 리소스 폴더
   - 이미지, 레이아웃, 값들을 관리함
 - manifests/AndroidManifest.xml : 어플리케이션의 화면 정보, 서비스, 퍼미션 등을 관리함
 - build.gradle(app): dependency, version, sdk version 등을 관리함
