package ru.unn.ooap.projectmanager.server.model.tasks;

import ru.unn.ooap.projectmanager.server.model.IObservable;

public interface ITask extends IObservable {
    int getID();
    String getTitle();
    String getDescription();
}
