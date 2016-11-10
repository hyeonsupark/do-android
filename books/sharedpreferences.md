## SharedPreferences

어플리케이션 내의 설정같은 값들을 저장해야할 때 쓰이는 것이다.
파일로서 관리되며, 어플리케이션을 삭제하거나 데이터를 지우면 삭제된다.

```java
SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
SharedPreferences.Editor editor = pref.edit();

editor.putString("nickname", "hi");
editor.putInt("age", 20);
editor.remove("age");
editor.apply();
// pref.commit(); boolean으로 반환하여 성공 여부를 알려줌

String nickname = pref("nickname", "Not Found");

editor.clear(); // 값 모두 초기화
```
