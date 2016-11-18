package me.xudaojie.chart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart lineChart = (LineChart) findViewById(R.id.line_chart);

        List<String> xVals = new ArrayList<>();
        List<Entry> yVals = new ArrayList<>();

        int range = 50;

        for (int i = 0; i < 50; i++) {
            xVals.add(i + "xxxasd");
            float yVal = (float) (Math.random() * range) + 3;
            yVals.add(new Entry(i, yVal));
        }

        lineChart.getXAxis().setValueFormatter(new StringAxisValueFormatter(xVals));

        LineDataSet dataSet = new LineDataSet(yVals, "xxx");
        LineData data = new LineData(dataSet);
        lineChart.setData(data);
    }

    static class StringAxisValueFormatter implements IAxisValueFormatter {

        private List<String> mVals;

        public StringAxisValueFormatter(List<String> vals) {
            mVals = vals;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            int position = (int) value;

            return mVals.get(position);
        }
    }
}
