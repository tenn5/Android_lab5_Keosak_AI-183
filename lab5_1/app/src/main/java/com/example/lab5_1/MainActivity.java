package com.example.lab5_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<Circle> circle = createList();

        RecyclerView rv = findViewById(R.id.list);
        rv.setHasFixedSize(true);

        rv.setLayoutManager( new GridLayoutManager (this, 4));

        rv.setAdapter(new MyAdapter(circle, this));
    }
    
    private List<Circle> createList() {
        List<Circle> circles = new ArrayList<>();
        Random rand = new Random();
        int size = 28;

        for (int i = 0; i < size; i++){
            circles.add(new Circle(Integer.toString(rand.nextInt(99)),
                    Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))));
        }

        return circles;
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.CircleViewHolder> {

    private List<Circle> list;
    private LayoutInflater layoutInflater;
    private FragmentManager fragmentManager;

    public MyAdapter(List<Circle> list, MainActivity activity) {
        this.list = list;
        layoutInflater = LayoutInflater.from(activity);
        fragmentManager = activity.getSupportFragmentManager();
    }

    @NonNull
    @Override
    public CircleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = layoutInflater.inflate(R.layout.circle_item, viewGroup, false);
        CircleViewHolder holder = new CircleViewHolder(v, fragmentManager);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CircleViewHolder circleViewHolder, int i) {
        circleViewHolder.button.setText(list.get(i).getText());
        circleViewHolder.button.setBackgroundColor(list.get(i).getColor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CircleViewHolder extends RecyclerView.ViewHolder {

        public Button button;

        public CircleViewHolder(@NonNull View itemView, FragmentManager fragmentManager) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            button.setOnClickListener(v -> {
                MyDialog dialog = MyDialog.newInstance(button.getText().toString());
                dialog.show(fragmentManager, "dlg");
            });
        }
    }
}

class Circle {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private String text;
    private int color;

    public Circle(String text, int color) {
        this.text = text;
        this.color = color;
    }
}

