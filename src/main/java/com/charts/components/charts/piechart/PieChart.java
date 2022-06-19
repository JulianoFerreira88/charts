package com.charts.components.charts.piechart;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.AttributedString;
import java.util.function.Consumer;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChart extends JPanel {

    private JFreeChart chart;
    private ChartPanel panel;
    private DefaultPieDataset data;

    public PieChart() {
        super(new CardLayout());
        init();

    }

    public void setTitle(String title) {
        chart.getTitle().setText(title);
        chart.fireChartChanged();
    }

    public void setTitlePaint(Color color) {
        chart.getTitle().setPaint(color);
        chart.fireChartChanged();
    }

    public void setTitleFont(Font font) {
        chart.getTitle().setFont(font);
        chart.fireChartChanged();
    }

    public void setTitleVisible(boolean visible) {
        chart.getTitle().setVisible(visible);
        chart.fireChartChanged();
    }

    private void init() {
        data = new DefaultPieDataset();
        for (int i = 0; i < 5; i++) {
            double value = Math.random();
            data.insertValue(i, "Category " + i, value);
        }
        chart = ChartFactory.createPieChart("", data, true, true, true);
        panel = new ChartPanel(chart);

        chart.fireChartChanged();
        setBgChart(Color.darkGray);
        setBgPlot(Color.darkGray);
        setLabelBg(Color.darkGray);
        setLabelColor(Color.white);
        setOutLineVisible(false);
        this.add(panel);
    }

    public void setBgChart(Color color) {
        chart.setBackgroundPaint(color);
        chart.fireChartChanged();
    }

    public void setBgPlot(Color color) {
        chart.getPlot().setBackgroundPaint(color);
        chart.fireChartChanged();
    }

    public void setOutLineVisible(boolean visible) {
        chart.getPlot().setOutlineVisible(visible);
        chart.fireChartChanged();
    }

    public void setShadowPieColor(Color color) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowPaint(color);
    }

    public void setLabelColor(Color color) {
        PiePlot plot = (PiePlot) chart.getPlot();

        plot.setLabelPaint(color);
        chart.fireChartChanged();
    }

    public void setLabelBg(Color color) {
        PiePlot plot = (PiePlot) chart.getPlot();

        plot.setLabelBackgroundPaint(color);
        chart.fireChartChanged();
    }

    public void setLegendBgColor(Color color) {
        PiePlot plot = (PiePlot) chart.getPlot();
        LegendItemCollection itens = plot.getLegendItems();
        itens.iterator().forEachRemaining(new Consumer<LegendItem>() {
            @Override
            public void accept(LegendItem t) {
                t.setFillPaint(color);

            }
        });
        chart.fireChartChanged();
    }

    public void setLabelLinksVisible(boolean visbile) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinksVisible(visbile);
        chart.fireChartChanged();
    }

    public void setLegendType(String format) {

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLegendLabelGenerator(new PieSectionLabelGenerator() {
            @Override
            public String generateSectionLabel(PieDataset dataset, Comparable key) {
                return "Rotulo";
            }

            @Override
            public AttributedString generateAttributedSectionLabel(PieDataset dataset, Comparable key) {
                AttributedString at = new AttributedString("");
                return at;
            }
        });
        chart.fireChartChanged();
    }

}
