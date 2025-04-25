/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomeritdemeritsystem;

import java.time.LocalDate;

public class EntryLog {
    private LocalDate date;
    private String description;
    private int points;
    private String actionType;  // Merit or Demerit
    private String loggedBy;
    private String branch;
    private String remarks;

    public EntryLog(String description, int points, String actionType, String loggedBy, String branch, String remarks) {
        this.date = LocalDate.now();
        this.description = description;
        this.points = points;
        this.actionType = actionType;
        this.loggedBy = loggedBy;
        this.branch = branch;
        this.remarks = remarks;
    }

    // Getters
    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    public String getActionType() {
        return actionType;
    }

    public String getLoggedBy() {
        return loggedBy;
    }

    public String getBranch() {
        return branch;
    }

    public String getRemarks() {
        return remarks;
    }
}
