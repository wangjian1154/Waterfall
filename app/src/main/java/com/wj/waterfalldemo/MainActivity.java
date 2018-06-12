package com.wj.waterfalldemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SmartRefreshLayout smartRefresh;

    private List<String> imgs;
    private List<ImgBean> list;
    private MyAdapter adapter;
    private StaggeredGridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loadData(true);

        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadData(false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadData(true);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                manager.invalidateSpanAssignments();
            }
        });
    }

    private void loadData(boolean isRefresh) {

        Toast.makeText(this, isRefresh + "", Toast.LENGTH_SHORT).show();
        if (isRefresh) {
            list.clear();
            list.add(new ImgBean(imgs.get(0), 100, 200));
            list.add(new ImgBean(imgs.get(1), 210, 300));
            list.add(new ImgBean(imgs.get(2), 500, 400));
            list.add(new ImgBean(imgs.get(3), 900, 260));
            list.add(new ImgBean(imgs.get(4), 800, 700));

            list.add(new ImgBean(imgs.get(5), 750, 500));
            list.add(new ImgBean(imgs.get(6), 600, 800));
            list.add(new ImgBean(imgs.get(7), 650, 900));
            list.add(new ImgBean(imgs.get(8), 450, 660));
            list.add(new ImgBean(imgs.get(9), 550, 450));
        } else {
            list.add(new ImgBean(imgs.get(10), 990, 480));
            list.add(new ImgBean(imgs.get(11), 1080, 540));
            list.add(new ImgBean(imgs.get(12), 950, 1920));
            list.add(new ImgBean(imgs.get(13), 480, 800));
            list.add(new ImgBean(imgs.get(14), 854, 996));

            list.add(new ImgBean(imgs.get(15), 1334, 766));
            list.add(new ImgBean(imgs.get(16), 1334, 733));
            list.add(new ImgBean(imgs.get(17), 950, 900));
            list.add(new ImgBean(imgs.get(18), 800, 660));
            list.add(new ImgBean(imgs.get(19), 800, 1950));
        }

        smartRefresh.finishRefresh();
        smartRefresh.finishLoadMore();
        adapter.notifyDataSetChanged();

    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        smartRefresh = findViewById(R.id.smart_layout);
        imgs = new ArrayList<>();
        list = new ArrayList<>();

        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/0F/05/ChMkJlsZ4B-ITPSjAAbpTatj3MAAAo30wNIWaoABull658.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/0F/05/ChMkJlsZ4B-IUlHDAAD9mLNDsi4AAo30wNHJxgAAP2w634.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/0F/05/ChMkJ1sZ4B6IA6TDAAg1yUI8JowAAo30wM-e_EACDXh172.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/0F/05/ChMkJlsZ4COIM2HFAAQuJ0RK0mAAAo30wOssq8ABC4_304.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/0E/0F/ChMkJlsYpoWIGyM4AALpWnaCWGcAAo2MAIyoe4AAuly645.jpg");

        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/07/04/ChMkJ1jlsBKIfYSjAAByNL_th2wAAbZHgCCrjMAAHJM171.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/07/04/ChMkJljlsBKIWPzyAAI9rPMhcE4AAbZHgCJLzAAAj3E286.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/07/04/ChMkJljlsBKIBeaoAAKuF7T7iIIAAbZHgB1UTwAAq4v485.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/07/04/ChMkJ1jlsBKILJeEAAD15bVnYxMAAbZHgB0Wz8AAPX9692.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/07/03/ChMkJljlp7mIVS74AAZe51VcP4AAAbZEQJ0SDoABl7_286.jpg");


        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/07/03/ChMkJ1jlp7qIDs9pAAEJM7oxm_cAAbZEQKRbtYAAQlL034.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/05/0F/ChMkJli2QJWISdaqAADU6_j_SssAAaUHAF5BeUAANUD627.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/00/04/ChMkJ1fJWEWIBalUAAsP-TYR2GoAAU-JAGvTPgACxAR788.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/00/04/ChMkJ1fJWEaIAetYAAkU3lYmkeIAAU-JAHCingACRT2756.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/00/03/ChMkJlfJV42IbkF6AAOKc-lQdiUAAU-EgFeijgAA4qL631.jpg");

        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/00/03/ChMkJlfJV42IP_FnAAbDow1gCfMAAU-EgFXxn0ABsO7141.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/00/03/ChMkJ1fJV4yIElpAAAeXXXt7Rv4AAU-EgErEksAB5d1679.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/03/0A/ChMkJlkL1-SIdi7RAAP7ySKVNh8AAcKfQGL_7IAA_vh904.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/03/0A/ChMkJ1kL1-6IZX5gAALHCQ6DcK4AAcKfQHOgjUAAsch590.jpg");
        imgs.add("https://sjbz-fd.zol-img.com.cn/t_s120x90c/g5/M00/03/0A/ChMkJlkL1-uIOz-sAAFMDO8s-l8AAcKfQHG1PcAAUwk573.jpg");


        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(manager);

    }
}
