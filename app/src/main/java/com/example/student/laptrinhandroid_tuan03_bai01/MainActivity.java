package com.example.student.laptrinhandroid_tuan03_bai01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_TaiKhoan, et_MatKhau;
    private CheckBox cb_LuuThongTin;
    private Button bt_DangNhap, bt_Thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        XuLy();
        Thoat();
    }

    public void AnhXa() {
        et_MatKhau = (EditText) findViewById(R.id.et_MatKhau);
        et_TaiKhoan = (EditText) findViewById(R.id.et_TaiKhoan);

        cb_LuuThongTin = (CheckBox) findViewById(R.id.cb_LuuThongTin);

        bt_DangNhap = (Button) findViewById(R.id.bt_DangNhap);
        bt_Thoat = (Button) findViewById(R.id.bt_Thoat);
    }

    public void XuLy() {
        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_LuuThongTin.isChecked()) {
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_LONG).show();
                } else  {
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Thoat() {
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Bạn có muốn thoát không ?");
                builder.setTitle("Thông báo !");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
