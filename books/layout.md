# 레이아웃

- 사용자 인터페이스에 대한 시각적 구조
- 액티비티 또는 앱 위젯에 대한 UI가 이에 해당된다.

## 레이아웃을 선언하는 방법

- XML
 - Android가 위젯과 레이아웃 등 클래스와 상응하는 XML 제공
- JAVA
 - 런타임에 레이아웃 요소를 인스턴트화
 - ViewGroup 객체를 만들고 조작

## 레이아웃을 XML로 짜보자

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >
    
  <TextView android:id="@+id/text"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="TextView ~" />
    
  <Button android:id="@+id/button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="This is a Button" />
</LinearLayout>
```

- 이러한 레이아웃 파일은 `res/layouts/`에 저장됨
- 각 레이아웃 파일의 root는 단 하나의 ViewGroup으로 이루어져야함

```java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}
```
`onCreate()` 메서드에서 `setContentView()`를 통해 레이아웃이 보여짐

## XML 속성

- 컴포넌트들과 ViewGroup은 모두 XML 속성을 지원한다.
- 공통 속성이 존재한다(ex: id)
- 몇몇 속성은 컴포넌트에 특화되어있다.(ex: TextView textSize)
 - TextView를 상속하는 컴포넌트들도 이 속성을 사용할 수 있음(ex: Button)

## ID

- 모든 객체에는 유니크한 정수 ID를 부여할 수 있다.
- XML에서는 정수가 부여된 string name으로 참조함
```xml
android:id="@+id/my_button"
```
- `@+id`는 ID 리소스로 식별해야 한다는 것을 나타낸다.
- +는 이것이 새 리소스 일때에 `R.java`에 추가하기 위함으로 쓰임
- Android 리소스 id를 참조하려면 `@android:id`와 같이 네임스페이스를 붙이면됨
```java
Button button = (Button) findViewById(R.id.button);
```
- 자바 코드에서에 참조하는 법

## 레이아웃 종류

- LinearLayout
 - 컴포넌트들을 가로 방향 또는 세로 방향으로 배치하는 레이아웃
 - 컴포넌트들이 화면을 넘어가게되면 스크롤버룰 생성함
 - `android:orientation="vertical|horizontal"`
 - `android:layout_weight`

- RelativeLayout
 - 컴포넌트들을 서로 관련지어 배치하거나, 상위와 관련지어 배치하는 레이아웃
 - `android:layout_alignParent(Top|Right|Bottom|Left)`
 - `android:layout_center(Horizontal|Vertical)`
 - `android:layout_centerInParent`
 - `android:layout_(above|below)`
 - `android:layout_to(Left|Right)Of`
 - `android:layout_align(Top|Right|Bottom|Left)`
