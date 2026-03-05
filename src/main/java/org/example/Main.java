package org.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class Main {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private final String FILE_NAME = "task.txt";

    public void run() {
        while (true) {
            System.out.println("\n=== Мои Задачи ===");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Показать задачу");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Выход");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addTask();
                saveTasks();
            } else if (choice.equals("2")) {
                showTask();
            } else if (choice.equals("3")) {
                deleteTask();
                saveTasks();
            } else if (choice.equals("4")) {
                System.out.println("Гудбай");
                break;
            } else {
                System.out.println("Не верный ввод чуть чуть внимательно");
            }
        }
    }

    private void addTask() {
        System.out.print("Введите задачу: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("Задача добавлена");
    }

    private void showTask() {
        if (tasks.isEmpty()) {
            System.out.println("Пустой список задач");
            return;
        }

        System.out.println("\n--- Все ваши задачки ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void deleteTask() {
        showTask();

        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("Введите номер задачи для удаления: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num >= 1 && num <= tasks.size()) {
                Task removed = tasks.remove(num - 1);
                System.out.println("Удалено: " + removed.getName());
            } else {
                System.out.println("Неверный номер!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите число!");
        }
    }

    private void saveTasks() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tasks);
            out.close();
            fileOut.close();
            System.out.println("Задача сохранена!");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        new Main().run();
    }
}

