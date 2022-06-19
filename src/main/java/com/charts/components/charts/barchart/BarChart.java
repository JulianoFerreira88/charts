package com.charts.components.charts.barchart;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;

public class BarChart extends javax.swing.JPanel implements DatasetChangeListener {

    private JFreeChart chart;
    private DefaultCategoryDataset data;
    private ChartPanel panel;

    public BarChart() throws SQLException {
        initComponents();
        init();

    }

    public void setChartData(CategoryDataset data) {
        chart.getCategoryPlot().setDataset(data);
        chart.fireChartChanged();
    }

    public void setChartTitle(String chartTitle) {
        chart.getTitle().setText(chartTitle);
        chart.fireChartChanged();
    }

    public void setAxisLabel(String axisLabel) {

    }

    public void setDomainAxisVisible(boolean visible) {
        ValueAxis rangeAxis = chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setTickLabelsVisible(visible);
        rangeAxis.setTickMarksVisible(visible);
        rangeAxis.configure();
        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        domainAxis.setTickLabelsVisible(visible);
        domainAxis.setTickMarksVisible(visible);
        domainAxis.setAxisLineVisible(visible);
        domainAxis.configure();
        chart.fireChartChanged();
    }

    public void setDomainAxisColor(Color color) {
        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        ValueAxis rangeAxis = chart.getCategoryPlot().getRangeAxis();
        domainAxis.setLabelPaint(color);
        domainAxis.setTickLabelPaint(color);
        domainAxis.setTickMarkPaint(color);
        domainAxis.configure();
        rangeAxis.setLabelPaint(color);
        rangeAxis.setTickLabelPaint(color);
        rangeAxis.setTickMarkPaint(color);
        rangeAxis.configure();
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

    public void setBgChartColor(Color color) {
        chart.setBackgroundPaint(color);
        chart.getCategoryPlot().setBackgroundPaint(color);
        chart.fireChartChanged();
    }

    public void setTitleColor(Color color) {
        chart.getTitle().setPaint(color);
        chart.fireChartChanged();
    }

    public void setTitleFont(Font font) {
        chart.getTitle().setFont(font);
        chart.fireChartChanged();
    }

    public void setShowTitle(boolean showTitle) {
        chart.getTitle().setVisible(showTitle);
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

    public void setTitle(String chartTitle) {
        chart.getTitle().setText(chartTitle);
        chart.fireChartChanged();
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
        CategoryItemRenderer renderer = chart.getCategoryPlot().getRenderer();
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(visible);

        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition());
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

    public void setData(CategoryDataset data) {
        chart.getCategoryPlot().setDataset(data);
        chart.fireChartChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.CardLayout());
        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void datasetChanged(DatasetChangeEvent event) {
        chart.fireChartChanged();
    }

    private void init() {
        data = new DefaultCategoryDataset();
        for (int i = 0; i < 10; i++) {
            data.addValue(Math.random(), "row", "column " + i);
        }

        chart = ChartFactory.createBarChart("",
                "",
                "",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                true);

        panel = new ChartPanel(chart, true, true, true, true, true);
        setSeriesVisible(true);
        setSeriesPaint(Color.white);
        setBgChartColor(Color.darkGray);
        setSeriesVisible(true);
        setTitleColor(Color.white);
        setDomainAxisVisible(true);
        this.jPanel1.add(panel);
    }

}
