package ru.unn.ooap.projectmanager.server.model;

import java.util.Observer;

public interface IObservable {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObservers();
}
