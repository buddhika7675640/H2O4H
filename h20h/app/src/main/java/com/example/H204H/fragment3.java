package com.example.H204H;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;

public class fragment3 extends Fragment {

    Button button;



    private ProgressBar circular_pro;
    private Button click_btn;
    private TextView status;
    H2O4H ie = new H2O4H();
    int k=45;

    private int progressStautus=0;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3layout,container,false);


        circular_pro=(ProgressBar)v.findViewById(R.id.pro1);
        status=(TextView)v.findViewById(R.id.text11);



        //circular_pro=(ProgressBar)findViewById(R.id.pro);
        //status=(TextView)findViewById(R.id.text1);




        AnyChartView anyChartView = v.findViewById(R.id.any_chart_view);
        //anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();

        data.add(new ValueDataEntry("1_week", 50));
        data.add(new ValueDataEntry("2_week", 42));
        data.add(new ValueDataEntry("3_week", 36));
        data.add(new ValueDataEntry("4_week", 60));




        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }");

        cartesian.animation(true);
        //cartesian.title("Top 10 Cosmetic Products by Revenue");

        cartesian.yScale().minimum(0d);
        cartesian.yAxis(0).labels("000");

        //cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");


        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("time");
        cartesian.yAxis(0).title("Usage(ml)");

        anyChartView.setChart(cartesian);




        new Thread(new Runnable() {
            @Override
            public void run() {

                while (progressStautus<ie.i){
                    progressStautus+=1;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            circular_pro.setProgress(progressStautus);
                            status.setText(progressStautus+"%");

                        }
                    });
                    try {
                        Thread.sleep(70);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }


            }
        }).start();
        status.setText(progressStautus+"%");





        button=v.findViewById(R.id.b3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if (k>50) {
                    Intent intent=new Intent(getActivity(),goodmonth.class);
                    startActivity(intent);


                }
                else {
                    Intent intent=new Intent(getActivity(),badmonth.class);
                    startActivity(intent);

                }






            }
        });



        return v;


    }
}
