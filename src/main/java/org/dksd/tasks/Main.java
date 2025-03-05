package org.dksd.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Helper helper = new Helper("tasks.json", "links.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while (!"q".equals(line)) {
            try {
                helper.displayTasks();

                System.out.print("Enter choice: ");
                line = reader.readLine();

                switch (line) {
                    case "k": // Move up
                        helper.moveUp();
                        break;
                    case "j": // Move down
                        helper.moveDown();
                        break;
                    case "\r": // Enter key
                        //selectTask();
                        break;
                    case "ct":
                        System.out.print("Enter task name: ");
                        String tname = reader.readLine();
                        System.out.print("Enter description: ");
                        String tdesc = reader.readLine();
                        helper.createTask(tname, tdesc);
                        break;
                    case "cs":
                        System.out.print("Enter sub name: ");
                        String name = reader.readLine();
                        System.out.print("Enter description: ");
                        String desc = reader.readLine();
                        helper.createSubTask(name, desc);
                        break;
                    case "cd":
                        System.out.print("Enter dep name: ");
                        String dname = reader.readLine();
                        System.out.print("Enter description: ");
                        String ddesc = reader.readLine();
                        helper.createDepTask(dname, ddesc);
                        break;
                    case "q": // Quit
                        break;
                    default:
                        break;
                }
                helper.selectTasks();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        helper.writeJson("tasks.json", helper.toJson(helper.getTasks()));
        helper.writeJson("links.json", helper.toJson(helper.getLinks()));
    }

}