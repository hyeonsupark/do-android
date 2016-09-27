#인텐트 (Intent)

- Activity, Service 등 어플리케이션 구성요소 간의 정보를 전달하는 역할을 한다.
- 명시적 인텐트와 암시적 인텐트로 구분을 할 수 있다.
 - 명시적 인텐트 (Explicit Intent) : 인텐트를 통해 호출하는 대상의 이름이 확실히 명시되어 있는 경우
	 - Activity 실행
	 - Service 실행
	 - Broadcast 수행
 - 암시적 인텐트 (Implicit Intent) : 인텐트를 통해 호출하는 대상의 이름이 확실히 명시되어 있지 않고 속성에 따라 호출되는 대상이 다른경우
	 - 전화걸기
	 - URL 열기
	 - 문자 전송

###액티비티를 전환해보자

우선 새로운 액티비티로의 전환을 위해 레이아웃과 자바 파일을 만들어 준다.

- `res/layout/activity_second.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

  <TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="두번째 액티비티" />
</LiearLayout>
```
<br />

-  `src/main/java/[자신의 패키지명]/SecondActivity.java`

```java
package [자신의 패키지명];

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}

```
<br />

- `AndroidManifest.xml` 파일의 `<application>`안에  아래 한 줄을 추가 시켜준다
```xml
<activity android:name=".SecondActivity"></activity>
```
<br />

- `MainActivity.java`에서 버튼을 클릭 시에 아래 동작을 실행한다.
```java
Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
startActivity(intent);
```
 - `getApplicationContext()` : Intent를 호출하고 있는 위치로 `MainActivity`를 뜻함
 - `SecondActivity.class`의 경우에는 Intent로 호출하고자 하는 요소(액티비티)
 - 결과 : `SecondActivity`가 실행이 된다.
<br />

###Intent로 다양한 동작 수행
