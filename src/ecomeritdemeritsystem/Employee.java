/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomeritdemeritsystem;

import java.util.ArrayList;

public class Employee {
    private String id;
    private String name;
    private String branch;
    private ArrayList<EntryLog> logs;

    public Employee(String id, String name, String branch) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.logs = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getBranch() { return branch; }

    public void addLog(EntryLog log) {
        logs.add(log);
    }

    public ArrayList<EntryLog> getLogs() {
        return logs;
    }

    public int getTotalPoints() {
        int total = 0;
        for (EntryLog log : logs) {
            total += log.getPoints();
        }
        return total;
    }
}
