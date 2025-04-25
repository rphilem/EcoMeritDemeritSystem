/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomeritdemeritsystem;

public class Main {
    public static void main(String[] args) {
        MeritDemeritManager manager = new MeritDemeritManager();

        manager.addEmployee("EMP001", "Phil");
        manager.addEmployee("EMP002", "Lorie");

        manager.addEntry("EMP001", "Guest commendation", 5, "Merit", "AIA", "Spaces Hotel Makati", "Commended by Room 201 guest");
        manager.addEntry("EMP001", "Unexcused absence", -5, "Demerit", "Toni", "Spaces Hotel Makati", "");
        manager.addEntry("EMP002", "Perfect monthly attendance", 2, "Merit", "Toni", "Spaces Hotel Makati", "");

        manager.showEmployeeSummary("EMP001");
        manager.showEmployeeSummary("EMP002");
    }
}
