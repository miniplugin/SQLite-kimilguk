#### 개선사항
- 람다식으로 된 소스를 일반코드로 변경처리(수업시 람다식 연습예정)
- android.support.v7 버전코드를 androidx.~ 최신버전으로 마이그레이션

#### 목적: java메인액티비티를 이용한 xml메인디자인과 SQLite디비의 CRUD.
- Read구현. 리사이클러뷰에 SQLite데이터를 바인딩하기 위한 2개의 클래스 생성.
- Read_1. 리사이클러 어댑터클래스(List구현) 와 뷰 홀더클래스(아이템View구현) 생성(중첩클래스적용).
- Read_2. 뷰홀더에 넣을 자료의 xml아이템디자인 생성.
- Read_3. 위 어댑터를 사용하여 java메인액티비티에 SQLite데이터 바인딩 처리.
- -------------------------- 여기까지 --------------------------------
Update구현, Delete구현, Create구현OK.
위 버튼중 Update,Delete,Create는 수업시 람다식으로 변경연습예정.

#### 20210311(목)
- 안드로이드폰 내부에 내장된 SQLite 데이터베이스를 기반으로한
- CRUD 앱 실습.
- 리사이클러 뷰(recyler view) 콤포넌트사용
- 예전에 사용된 ListView 를 대체해서 RecylerView를 사용함.
- 특징1: 손가락으로 상하 스크롤 뿐아니라 좌우 스크롤도 가능함.
- 특징2: 레이아웃 매니저(LayoutManager클래스)와
- 뷰홀더패턴(View Holder Pattern)을 반드시 사용해야 함.
- 특징3: 리스트뷰 보다 다양한 형태로 커스터마이징이 가능함.
- RecyclerView 예제: https://webnautes.tistory.com/1214
- 3개 객체: List객체(DB)<->어댑터클래스<->리사이클러뷰 콤포넌트