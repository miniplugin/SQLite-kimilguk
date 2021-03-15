package com.human.sqlite_kimilguk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerAdapter클래스는 recyclerView콤포넌트와 SQLiteDB를 바인딩 시키는 기능.
 * 필수 클래스 2개 Adapter, ViewHolder 필요.
 * 중첩클래스를 만드는 방법: RecyclerAdaper.ItemViewHoler
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    //ItemViewHolder클래스가 호출되면 자동으로 onCreateViewHolder메서드가 실행됨(아래)
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //레이아웃 xml을 자바단에서 화면을 로딩할때 inflater메서드 사용(아래)=startActivity(화면을 띄울때)
        //inflate()매개변수 xml이 디자인이 필수. 리사이클러뷰 내에 들어가는 아이템디자인 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //중첩클래스 생성(아래: 리사이클러뷰 콤포넌트에 데이터를 홀딩시키는 클래스)
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        //멤버변수선언:클래스전역변수
        private TextView itemGrade;//홀더내에 객체중 학년 아이템
        private TextView itemNumber;//학번 아이템
        private TextView itemName;//학생이름 아이템
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);//메모리에 ViewHolder클래스를 로딩하게 됨.
            //변수 객체로 만듬.(메로리에 로딩 실행가능하게 변경)
            itemGrade = itemView.findViewById(R.id.item_grade);//xml의 콤포넌트를 객체화 시킴
            itemNumber = itemView.findViewById(R.id.item_number);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }
}
