package com.human.sqlite_kimilguk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * RecyclerAdapter클래스는 recyclerView콤포넌트와 SQLiteDB를 바인딩 시키는 기능.
 * 필수 클래스 2개 Adapter, ViewHolder 필요.
 * 중첩클래스를 만드는 방법: RecyclerAdaper.ItemViewHoler
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    //android에서 제공되는 OnItemClick리스너는 매개변수 4개 이기 때문에 2개로 추가
    public interface OnItemClickListener { //중첩클래스 내에서 사용.
        void onItemClick(View v,int position);//매개변수 2개인 메서드명세 생성.
    }
    //멤버변수
    public OnItemClickListener mOnItemClickListener;
    private List mList;

    //인터페이스 온클릭리스너에 대한 셋메서드생성(나중에 메인액티비티에서 사용예정, 아래)
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

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
        return mList.size();
    }

    //중첩클래스 생성(아래: 리사이클러뷰 콤포넌트에 데이터를 홀딩시키는 클래스)
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        //멤버변수선언:클래스전역변수
        private TextView itemGrade;//홀더내에 객체중 학년 아이템
        private TextView itemNumber;//학번 아이템
        private TextView itemName;//학생이름 아이템
        public ItemViewHolder(@NonNull View itemView) {//new 생성자 메서드
            super(itemView);//메모리에 ViewHolder클래스를 로딩하게 됨.
            //변수 객체로 만듬.(메로리에 로딩 = 실행가능하게 변경)
            itemGrade = itemView.findViewById(R.id.item_grade);//xml의 콤포넌트를 객체화 시킴
            itemNumber = itemView.findViewById(R.id.item_number);
            itemName = itemView.findViewById(R.id.item_name);
            //new키워드로 생성(객체가만들어질)될때 아이템클릭 이벤트 생성.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int pos = getAdapterPosition();//리사이클러뷰 클릭한 리스트 위치
                    System.out.println("디버그 itemView.setOnClickListener: " + pos);
                    if(pos != RecyclerView.NO_POSITION) {//손가락으로 클릭했을때
                        //선택한 학생이 있을때 실행(아래)
                        if(mOnItemClickListener != null) {
                            mOnItemClickListener.onItemClick(v,pos);
                        }
                    }
                }
            });
            //작동확인 후 나중에 람다식(자바버전8이후부터 지원가능)으로 변경예정.
        }
    }
}
