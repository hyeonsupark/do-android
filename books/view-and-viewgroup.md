# 뷰그룹과 뷰

## ViewGroup

ViewGroup은 View와 ViewGroup을 포함하는 컨테이너의 개념
레이아웃들이 ViewGroup들을 상속하여 화면 배치의 개념을 가짐  

## View

ViewGroup의 상위 개념  
TextView, Button과 같은 위젯부터 보이는 것의 모든 것이라고 볼 수 있음

- 공통 속성
 - `android:layout_width`: 뷰의 폭
 - `android:layout_height`: 뷰의 높이
 - `android:layout_gravity`: 뷰 정렬
 - `android:layout_margin`: 뷰의 바깥 여백
 - `android:padding`: 뷰의 안쪽 여백
 - `android:gravity`: 뷰의 안쪽 정렬

- TextView (Button, EditText)
 - textSize: 폰트 크기
 - textStyle: 폰트 스타일(bold,italic,normal)
 - text: 출력될 문자열
 - textColor: 문자열의 색
 - singleLine : 문자열이 뷰 크기보다 크면 강제로 한줄로
 - background: 배경(이미지나 색)

- ImageView
 - src: 이미지 아이디
 - scaleType: 뷰에 맞추는 크기 속성
 - maxWidth,maxHeight : 이미지 최대 크기
 - adjustViewBounds : 비율 관련 옵션
 - tint : 이미지에 틴트 컬러 입히는 속성


