# Result Callback

액티비티를 실행한 액티비티에 값을 되 넘겨주는 역할을 한다.

- A 액티비티
```java
Intent intent = new Intent(A.this, B.class);
startActivityForResult(intent, 100);
```

`startActivityForResult(Intent intent, int requestCode)` 메소드를 통해서 intent와 requestCode를 넘긴다.

- B 액티비티
```java
Intent intent = new Intent();
intent.putExtra("key", value);
setResult(200, intent);
finish();
```

`setResult(int resultCode, Intent intent)` 메소드를 통해서 resultCode와 intent를 넘긴다

- A 액티비티
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);

	if(requestCode == 100 && resultCode == 200) {
		String nickname = data.getStringExtra("key");
		textView.setText(key);
	}
} 
```

B 액티비티를 실행한 A 액티비티에서는 `onActivityResult()` 메소드를 오버라이딩 한다.  
액티비티를 실행할 때 사용한 `requestCode`와 액티비티를 종료할 때 사용한 `resultCode`를 이용해서 원하는 행동을 하면 된다.
