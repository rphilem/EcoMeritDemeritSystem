/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomeritdemeritsystem;

import java.util.HashMap;
import ecomeritdemeritsystem.Employee;
import ecomeritdemeritsystem.EntryLog;

public class MeritDemeritManager {
    private HashMap<String, Employee> employeeMap;

    public MeritDemeritManager() {
        employeeMap = new HashMap<>();
    }

    public void addEmployee(String id, String name) {
        if (!employeeMap.containsKey(id)) {
            employeeMap.put(id, new Employee(id, name, "Unknown"));
            System.out.println("✅ Employee added: " + name);
        } else {
            System.out.println("⚠️ Employee already exists.");
        }
    }

    public void addEntry(String employeeId, String description, int points, String actionType, String loggedBy, String branch, String remarks) {
        Employee emp = employeeMap.get(employeeId);
        if (emp != null) {
            EntryLog log = new EntryLog(description, points, actionType, loggedBy, branch, remarks);
            emp.addLog(log);
            System.out.println("📌 " + actionType + ": " + description + " (" + points + " pts) added to " + emp.getName());
        } else {
            System.out.println("❌ Employee not found.");
        }
    }

    public void showEmployeeSummary(String employeeId) {
        Employee emp = employeeMap.get(employeeId);
        if (emp != null) {
            System.out.println("\n🧾 Summary for " + emp.getName());
            System.out.println("Total Points: " + emp.getTotalPoints());
            System.out.println("Logs:");
            for (EntryLog log : emp.getLogs()) {
                System.out.println("- [" + log.getDate() + "] " + log.getActionType() + ": " + log.getDescription()
                        + " (" + log.getPoints() + " pts) | Branch: " + log.getBranch() + " | Logged by: " + log.getLoggedBy());
                if (log.getRemarks() != null && !log.getRemarks().isEmpty()) {
                    System.out.println("   Remarks: " + log.getRemarks());
                }
            }
        } else {
            System.out.println("❌ Employee not found.");
        }
    }
}
