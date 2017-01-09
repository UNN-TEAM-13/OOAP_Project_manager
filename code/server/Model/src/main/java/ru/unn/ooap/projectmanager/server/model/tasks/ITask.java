package ru.unn.ooap.projectmanager.server.model.tasks;

import ru.unn.ooap.projectmanager.server.model.IObservable;

import java.io.Serializable;

public interface ITask extends IObservable, Serializable {
    int getID();
    String getTitle();
    String getDescription();
}
