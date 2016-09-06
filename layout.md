# 레이아웃

- 사용자 인터페이스에 대한 시각적 구조
- 액티비티 또는 앱 위젯에 대한 UI가 이에 해당됩니다.

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

이러한 레이아웃 파일은 `res/layouts/`에 저장됨

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




