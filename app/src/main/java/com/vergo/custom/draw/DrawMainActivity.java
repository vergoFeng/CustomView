package com.vergo.custom.draw;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vergo.custom.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fenghj
 */
public class DrawMainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.draw_color_view, R.string.title_draw_color));
        pageModels.add(new PageModel(R.layout.draw_circle_view, R.string.title_draw_circle));
        pageModels.add(new PageModel(R.layout.draw_rect_view, R.string.title_draw_rect));
        pageModels.add(new PageModel(R.layout.draw_point_view, R.string.title_draw_point));
        pageModels.add(new PageModel(R.layout.draw_oval_view, R.string.title_draw_oval));
        pageModels.add(new PageModel(R.layout.draw_line_view, R.string.title_draw_line));
        pageModels.add(new PageModel(R.layout.draw_roundrect_view, R.string.title_draw_round_rect));
        pageModels.add(new PageModel(R.layout.draw_arc_view, R.string.title_draw_arc));
        pageModels.add(new PageModel(R.layout.draw_path_view, R.string.title_draw_path));
        pageModels.add(new PageModel(R.layout.draw_bitmap_view, R.string.title_draw_bitmap));
        pageModels.add(new PageModel(R.layout.draw_text_view, R.string.title_draw_text));
        pageModels.add(new PageModel(R.layout.draw_histogram_view, R.string.title_draw_histogram));
        pageModels.add(new PageModel(R.layout.draw_piechart_view, R.string.title_draw_pie_chart));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PagerFragment.newInstance(pageModel.sampleLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setVisibility(View.GONE);
    }

    private class PageModel {
        @LayoutRes int sampleLayoutRes;
        @StringRes int titleRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
        }
    }
}
