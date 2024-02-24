package com.example.week03_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // Đảm bảo rằng tên layout đúng

        Button btnToMenu = findViewById(R.id.btnToMenu);
        btnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị PopupMenu khi nhấn vào button
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu()); // Thay thế menu_xml_file_name bằng tên file XML menu của bạn
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.menu_demo) {
                    // Xử lý sự kiện cho menu Demo
                    Toast.makeText(MenuActivity.this, "Demo selected", Toast.LENGTH_SHORT).show();
                    // Thêm bất kỳ hành động nào bạn muốn thực hiện ở đây
                    Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.menu_exercise) {
                    // Xử lý sự kiện cho menu Exercise
                    Toast.makeText(MenuActivity.this, "Exercise selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                    startActivity(intent);
                    // Thêm bất kỳ hành động nào bạn muốn thực hiện ở đây
                    return true;
                } else if (id == R.id.menu_logout) {
                    // Xử lý sự kiện cho menu Logout
                    Toast.makeText(MenuActivity.this, "Logout selected", Toast.LENGTH_SHORT).show();
                    // Thêm bất kỳ hành động nào bạn muốn thực hiện ở đây
                    return true;
                } else {
                    return false;
                }
            }
        });
        popupMenu.show();
    }
}
