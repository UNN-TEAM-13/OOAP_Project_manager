package ru.unn.ooap.projectmanager.server.model.tasks;

public class Tasks {

    /*
    Этот класс должен предоставлять таски, заассигненные на экзекутораю.
    Что ещё от него нужно — хз.
     */

    private static Tasks ourInstance = new Tasks();

    public static Tasks getInstance() {
        return ourInstance;
    }

    private Tasks() {
    }
}
