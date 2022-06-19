package com.charts.components.charts.linechart;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends JPanel {

    private JFreeChart chart;
    private ChartPanel panel;
    private DefaultCategoryDataset data;

    public LineChart() {
        super();
        setLayout(new CardLayout());
        init();
    }

    public void setChartOrientation(PlotOrientation orientation) {
        chart.getCategoryPlot().setOrientation(orientation);
        chart.fireChartChanged();
    }

    public void setChartTitle(String title) {
        chart.getTitle().setText(title);
        chart.fireChartChanged();
    }

    public void setBgChart(Color color) {
        chart.setBackgroundPaint(color);
        chart.fireChartChanged();

    }

    public void setBgColorPlot(Color color) {
        chart.getCategoryPlot().setBackgroundPaint(color);
        chart.fireChartChanged();
    }

    public void setBgLabelColor(Color color) {
        ValueAxis rangeAxis = chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setLabelPaint(color);
        rangeAxis.setTickLabelPaint(color);
        rangeAxis.setTickLabelsVisible(true);

        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();

        domainAxis.setLabelPaint(color);
        domainAxis.setTickLabelPaint(color);
        domainAxis.setTickLabelsVisible(true);
        domainAxis.setTickMarkPaint(color);
        domainAxis.setTickMarksVisible(true);
        domainAxis.setAxisLineVisible(true);

        chart.fireChartChanged();
    }

    public void setBgLineColor(Color color) {
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, color);
        chart.fireChartChanged();
    }

    public void setBgChartTitle(Color color) {
        chart.getTitle().setPaint(color);
        chart.fireChartChanged();
    }

    public void setCategoryPlotSize() {

    }

    public void setBgSeriesColor(Color color) {
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, color);
        chart.fireChartChanged();

    }

    public void setWeigth(int weigth) {
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getDomainAxis().setMinorTickMarksVisible(true);
        chart.fireChartChanged();
    }

    public void setLabelFont(Font font) {
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getRenderer().setSeriesItemLabelFont(0, font);
        chart.fireChartChanged();
    }

    public void setSeriesVisible(boolean visible) {

        chart.getCategoryPlot().getRenderer().setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        chart.getCategoryPlot().getRenderer().setBaseItemLabelsVisible(visible);
        chart.getCategoryPlot().getRenderer().setBasePositiveItemLabelPosition(new ItemLabelPosition());
        chart.fireChartChanged();
    }

    public void setSeriesPaint(Color color) {
        chart.getCategoryPlot().getRenderer().setBaseItemLabelPaint(color);
        chart.fireChartChanged();
    }

    public void setSeriesFont(Font font) {
        chart.getCategoryPlot().getRenderer().setBaseItemLabelFont(font);
        chart.fireChartChanged();
    }

    public void setOrientationVertical(boolean orientation) {
        if (orientation) {
            chart.getCategoryPlot().setOrientation(PlotOrientation.VERTICAL);
        } else {
            chart.getCategoryPlot().setOrientation(PlotOrientation.HORIZONTAL);
        }
        chart.fireChartChanged();
    }

    public void setData(CategoryDataset data) {
        chart.getCategoryPlot().setDataset(data);
        chart.fireChartChanged();
    }

    private void init() {
        data = new DefaultCategoryDataset();
        for (int i = 0; i < 10; i++) {
            data.addValue(Math.random(), "row", "column " + i);
        }
        chart = ChartFactory.createLineChart("", "", "", data, PlotOrientation.VERTICAL, true, true, true);

        panel = new ChartPanel(chart);
        setBgChart(Color.darkGray);
        setBgColorPlot(Color.darkGray);
        setBgLineColor(Color.red);
        setSeriesVisible(true);
        setSeriesPaint(Color.white);
        setSeriesVisible(true);
        setBgLabelColor(Color.white);
        this.add(panel);
    }
}
