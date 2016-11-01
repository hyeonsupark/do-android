# 커스텀 리스트뷰

커스텀 리스트뷰는 안드로이드에서 제공해주는 `ListView` 를 이용해서 자기가 원하는 UI로 리스트를 구성할 수 있는 것을 통칭한다.

같은 레이아웃을 가진 리스트들로 구성할 떄는 크게 네가지로 나누어진다.  
리스트에 들어갈 Layout XML파일,
리스트에 들어갈 데이터들을 관리하는 Model class,
리스트에 데이터들을 붙여주는 Adapter class,
이 ListView를 보여주는 Activity이다.

## 들어가며

일단 채팅 어플리케이션을 개발한다고 가정하고 이름하고 메세지를 유저가 확인할 수 있다고 가정한다.

## row.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
	xmlns:android="http://schemas.android.com/apk/res/android"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	android:orientation="vertical">
    <TextView
        android:id="@+id/name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="@android:color/black"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/message"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="@android:color/black" />
</LinearLayout>
```

간단하게 이름과 메세지를 보여줄 `TextView` 두개만 작성한다.

##  Model

모델은 Java 클래스로 만든다.
xml에서도 이름과 메세지만 있으니 이름, 메세지를 담을 변수 두개를 만든다.

```java
class Model {
	private String name;
	private String message;
	public Chat(String name, String message) {
		this.name = name;
		this.message = message;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void getName() {
		return this.name;
	}

	...
}
```

변수들을 외부에서 접근할 수 없게끔 `private` 접근제어자로 선언하고,  
메서드를 통해서 이름을 설정 및 가져올 수 있게 한다.

## Adapter

어댑터는 데이터들을 보여주는 역할을 한다.
안드로이드에서 제공하는 `ArrayAdapter<>` 클래스를 상속 받아서 활용한다.
ArrayAdapter뒤에 예제 코드와 같이 <>사이에 클래스 이름을 써주게 되면 그 클래스 형식만 받겠다는 뜻이고. 제네릭이라 불린다.
리스트 각각마다 `getView()`라는 메서드를 호출하여 뷰를 입혀줄 수 있다.

```java
class MyAdapter extends ArrayAdapter<Model> {
// 위에서 Model 클래스를 선언하여 <>사이에도 그대로 써준다.
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

	    Model model = models.get(position);
	    // Model객체들이 담겨있는 ArrayList에서 인덱스 별로 데이터를 가져온다.
	    convertView = inflater.inflate(resource, parent, false);
        // 리스트 별 뷰를 LayoutInflater를 통해 전개하여 객체를 가져온다.
        
	    TextView tvName = (TextView) convertView.findViewById(R.id.name);
	    TextView tvMessage = (TextView) convertView.findViewById(R.id.message);
		// 리스트 별 뷰 객체를 통해 `findViewById()` 메서드로 뷰를 가져온다.
		
	    tvName.setText(model.getName());
	    tvMessage.setText(model.getMessage());
		// 모델 객체에서 가져온 데이터로 `setText()` 한다.
		
        return convertView;
    }
}
```

## Activity

```java
listView = (ListView) findViewById(R.id.listView);
ArrayList<Model> models = new ArrayList<>();

MyAdapter myAdapter = new MyAdapter(getApplicationContext(), R.layoyt.row models);
// ArrayAdapter를 사용하듯이 초기화를 해주고, models에 데이터를 있으면 넣어주고 없으면 넣어주지 않는다. 
listView.setAdapter(myAdapter);
// ListView에 adapter 세팅

Model model = new Model();
model.setName("Name");
model.setMessage("Message");
myAdapter.add(model);
// myAdapter에 바로 데이터를 추가하면 뷰에 보인다.

models.add(model);
myAdapter.notifyDataSetChanged();
// ArrayList에 데이터를 추가하면 notifyDataSetChanged() 메서드를 호출해야 정상적으로 뷰가 갱신된다.
```
