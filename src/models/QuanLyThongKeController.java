/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.awt.CardLayout;
//import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

import java.awt.Dimension;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author hoang
 */
public class QuanLyThongKeController {
        
        private ThongKeService thongKeService = null;

        public QuanLyThongKeController() {
            this.thongKeService = new ThongKeServiceImpl();
        }
        
        public void setDataToChart1(JPanel jpnItem) {
        List<Student> listItem = thongKeService.getListByStudent();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (Student item : listItem) {
                //dataset.addValue(item.getId(), "Số sinh viên", item.getRoom());
                dataset.addValue(Double.valueOf(item.getId()), "Số sinh viên", item.getRoom());

            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Số sinh viên ở từng dãy".toUpperCase(),
                "Dãy", "Số sinh viên",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
        
        
        public void setDataToChart2(JPanel jpnItem) {
        List<Student> listItem = thongKeService.getListByStudent();

        DefaultPieDataset dataset = new DefaultPieDataset();
        if (listItem != null) {
            for (Student item : listItem) {
                //dataset.addValue(item.getId(), "Số sinh viên", item.getRoom());
                dataset.setValue(item.getRoom(), Double.valueOf(item.getId()));

            }
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
            "Phân phối số sinh viên theo phòng".toUpperCase(),
            dataset, true, true, false);

        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}