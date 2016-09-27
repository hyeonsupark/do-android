# 리소스 관리

안드로이드의 리소스는 색, 크기, 문자열, 이미지, 애니메이션 등이 있다.  
여기서 다룰 것은 값으로 관리되는 색, 크기, 문자열으로 `res/values` 폴더에서 관리되는 것들이고 `xml`로 관리 된다.


## 문자열
- `strings.xml`

### xml에서의 관리
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>    

  <string name="main.hello.world">Hello, World!</string>    
  <string name="main.nickname">Input your nickname</string>
  <string name="main.info">이름: %1$s, 나이: %2$d세</string>

</resources>
```

### 자바에서의 쓰임
``` java
String inputNickname = getString(R.string.main_nickname);

String info = getString(R.string.main_info);
String.format(info, "Hyeonsu Park", 20)
```

## 색
- `colors.xml`

### xml에서의 관리
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>    
  <color name="main.red">#FF0000</color>    
  <color name="main.blue">#0000FF</color>    

</resources>
```

### 자바에서의 쓰임
```java
int colorRed = getResources().getColor(R.color.main_red);
```

## 크기
- `dimens.xml`

### xml에서의 관리
```xml
<?xml version="1.0" encoding="utf-8"?>

<resources>    
  <dimen name="main.button.width">100dp</dimen>
  <dimen name="main.button.height">60dp</dimen>    
</resources>
```

### 자바에서의 쓰임
```java
float buttonWidth = getResources().getDimension(R.dimen.main_button_width);
```

## 결과
```xml
<Button   
  android:id="@+id/button"   
  android:layout_width="@dimen/main_button_width"    
  android:layout_height="@dimen/main_button_height" 
  android:text="@string/main_hello_world"
  android:textColor="@color/main_red" 
  android:background="@color/main_blue"
  />
```
