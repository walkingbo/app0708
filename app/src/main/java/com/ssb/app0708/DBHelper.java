package com.ssb.app0708;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //생성자-Context를 호출해서 상위 클래스의 생성자를 호출
    public DBHelper(Context context){
        super(context,"datadb",null,1);
    }
    //처음 사용할 때  한 번 호출되는 메소드
    @Override
    public void onCreate(SQLiteDatabase db){
        //테이블을 생성하고 데이터 초기화 하는 작업
        //서버에 기본 데이터가 있으면 가져와서 저장
        String tableSql = "create table tb_data(_id integer primary key autoincrement,name text,phone text)";
        //SQL실행
        db.execSQL(tableSql);
        //기본 데이터 삽입
        db.execSQL("insert into tb_data(name,phone) values('에브라','01011112222')");
        db.execSQL("insert into tb_data(name,phone) values('데 리히트','01011112223')");
        db.execSQL("insert into tb_data(name,phone) values('포그바','01011112224')");
        db.execSQL("insert into tb_data(name,phone) values('박지성','01011112225')");
        db.execSQL("insert into tb_data(name,phone) values('구자철','01011112226')");
        db.execSQL("insert into tb_data(name,phone) values('박주호','01011112227')");
    }

    //데이터베이스 버전이 변경된 경우 호출되는 메소드
    //기존데이터를 삭제하고 테이블을 다시 생성
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table tb_data");
        onCreate(db);
    }


}
