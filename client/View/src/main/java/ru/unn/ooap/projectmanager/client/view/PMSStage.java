package ru.unn.ooap.projectmanager.client.view;

import javafx.stage.Stage;
import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.dal.FakeDAL;

public class PMSStage extends Stage {
    private User user;
    private final IDAL storage = new FakeDAL();

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public IDAL getStorage() {
        return storage;
    }
}
