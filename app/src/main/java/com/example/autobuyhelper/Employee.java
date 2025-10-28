package com.example.autobuyhelper.models;

public class Employee {
    private String id;
    private String name;
    private int salesCount;
    private double totalSales;
    private String position;

    public Employee(String id, String name, int salesCount, double totalSales, String position) {
        this.id = id;
        this.name = name;
        this.salesCount = salesCount;
        this.totalSales = totalSales;
        this.position = position;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getSalesCount() { return salesCount; }
    public double getTotalSales() { return totalSales; }
    public String getPosition() { return position; }
}
