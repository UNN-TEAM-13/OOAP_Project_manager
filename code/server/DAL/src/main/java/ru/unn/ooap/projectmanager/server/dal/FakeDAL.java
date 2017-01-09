package ru.unn.ooap.projectmanager.server.dal;

import org.omg.PortableInterceptor.INACTIVE;
import ru.unn.ooap.projectmanager.server.model.IDAL;

import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FakeDAL implements IDAL {
    private final List<User> usersList = new ArrayList<>();
    private final List<Project> projectsList = new ArrayList<>();
    private final List<Task> tasksList = new ArrayList<>();
    //private Users users;
    //private Projects projects;
    //private Tasks tasks;

    private void saveLists() {
        try {
            ObjectOutputStream usersOOS = new ObjectOutputStream(new FileOutputStream("users.db"));
            usersOOS.writeObject(usersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream projectsOOS = new ObjectOutputStream(new FileOutputStream("projects.db"));
            projectsOOS.writeObject(projectsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream tasksOOS = new ObjectOutputStream(new FileOutputStream("tasks.db"));
            tasksOOS.writeObject(tasksList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream adminsIDOOS = new ObjectOutputStream(
                    new FileOutputStream("admins.db"));
            ArrayList<Integer> adminsIDs = new ArrayList<>();
            for (User user : usersList) {
                if (user instanceof Administrator) {
                    adminsIDs.add(user.getID());
                }
            }
            adminsIDOOS.writeObject(adminsIDs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream managersIDOOS = new ObjectOutputStream(
                    new FileOutputStream("managers.db"));
            ArrayList<Integer> managersIDs = new ArrayList<>();
            for (User user : usersList) {
                if (user instanceof Manager) {
                    managersIDs.add(user.getID());
                }
            }
            managersIDOOS.writeObject(managersIDs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream executorsIDOOS = new ObjectOutputStream(
                    new FileOutputStream("executors.db"));
            ArrayList<Integer> executorsIDs = new ArrayList<>();
            for (User user : usersList) {
                if (user instanceof Executor) {
                    executorsIDs.add(user.getID());
                }
            }
            executorsIDOOS.writeObject(executorsIDs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkIDinList(List<Integer> l, int id) {
        for (Integer integer : l) {
            if (integer.equals(id)) {
                return true;
            }
        }
        return false;
    }

    private void loadLists() {
        ArrayList<Integer> adminsIDs = new ArrayList<Integer>();
        try {
            ObjectInputStream adminsIS = new ObjectInputStream(new FileInputStream("admins.db"));
            try {
                adminsIDs = (ArrayList<Integer>) adminsIS.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> managersIDs = new ArrayList<Integer>();
        try {
            ObjectInputStream managersIS = new ObjectInputStream(new FileInputStream("managers.db"));
            try {
                managersIDs = (ArrayList<Integer>) managersIS.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> executorsIDs = new ArrayList<Integer>();
        try {
            ObjectInputStream executorsIS = new ObjectInputStream(new FileInputStream("executors.db"));
            try {
                executorsIDs = (ArrayList<Integer>) executorsIS.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream usersIS = new ObjectInputStream(new FileInputStream("users.db"));
            try {
                ArrayList<User> tmp = (ArrayList<User>) usersIS.readObject();
                for (User user : tmp) {
                    if (checkIDinList(adminsIDs, user.getID())) {
                        usersList.add(new Administrator(user.getID(), user.getUsername(),
                                user.getPassword(), this));
                    } else if (checkIDinList(managersIDs, user.getID())) {
                        usersList.add(new Manager(user.getID(), user.getUsername(),
                                user.getPassword(), this));
                    } else if (checkIDinList(executorsIDs, user.getID())) {
                        usersList.add(new Executor(user.getID(), user.getUsername(),
                                user.getPassword(), this));
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream projectsIS = new ObjectInputStream(new FileInputStream("projects.db"));
            try {
                ArrayList<Project> tmp = (ArrayList<Project>) projectsIS.readObject();
                for (Project project : tmp) {
                    projectsList.add(new Project(project.getId(),
                            project.getTitle(), project.getDescription(), new ArrayList<Task>(), this));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream tasksIS = new ObjectInputStream(new FileInputStream("tasks.db"));
            try {
                ArrayList<Task> tmp = (ArrayList<Task>) tasksIS.readObject();
                for (Task task : tmp) {
                    Project prj = null;
                    for (Project project : projectsList) {
                        if (project.getId() == task.getProject().getId()) {
                            prj = project;
                            break;
                        }
                    }
                    User executor = null;
                    for (User user : usersList) {
                        if (task.getExecutor() != null
                                && user.getID() == task.getExecutor().getID()) {
                            executor = user;
                        }
                        break;
                    }
                    tasksList.add(new Task(task.getID(), task.getTitle(), task.getDescription(), prj, (Executor)executor,
                            task.getGivenHours(), task.getSpentHours(),
                            task.isOpen(),task.isDone(),this));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FakeDAL() {
        /*
        Подключаемся к хранилищу.
        (Здесь же?) конструируем объекты,
        сохранённые в хранилище.
         */
        if (new File("users.db").exists()
                && new File("projects.db").exists()
                && new File("tasks.db").exists()) {
            loadLists();
        } else {
            usersList.add(new Manager(1, "TestManager", " ", this));

            Executor testExecutor1 = new Executor(2, "TestExecutor 1", " ", this);
            usersList.add(testExecutor1);
            Executor testExecutor2 = new Executor(testExecutor1.getID() + 1, "TestExecutor 2",
                    " ", this);
            usersList.add(testExecutor2);

            Administrator testAdministrator
                    = new Administrator(testExecutor2.getID() + 1, "TestAdministrator", " ", this);
            usersList.add(testAdministrator);


            Project project = new Project(1, "Test Project",
                    "Project, created just to proof of work",
                    new ArrayList<>(), this);
            projectsList.add(project);

            Task testTask1 = new Task(1, "Test task 1", "", project, testExecutor1,
                    0, 0, true, false, this);
            project.addTask(testTask1);
            tasksList.add(testTask1);

            Task testTask2 = new Task(2, "Test task 2", "", project, testExecutor1,
                    2, 1, true, true, this);
            project.addTask(testTask2);
            tasksList.add(testTask2);
            saveLists();
        }
    }

    @Override
    public void setUsers(final Users users) {
        //this.users = users;
        /*
        Вставляем в объект класса Users
        список уже сконструированных объектов юзеров.
         */
        saveLists();
    }

    @Override
    public void setProjects(final Projects projects) {
        //this.projects = projects;
        /*
        Вставляем в объект класса Projects
        список уже сконструированных проектов.
         */
        saveLists();
    }

    @Override
    public void setTasks(final Tasks tasks) {
        //this.tasks = tasks;
        /*
        Вставляем в объект класса Users
        список уже сконструированных задач.
         */
        saveLists();
    }

    @Override
    public void sync(final Project project) {
        saveLists();
    }

    @Override
    public void sync(final Projects projects) {
        projects.setProjects(projectsList);
        saveLists();
    }

    @Override
    public void sync(final Task task) {
        saveLists();
    }

    @Override
    public void sync(final Tasks tasks) {
        tasks.setTasks(tasksList);
        saveLists();
    }

    @Override
    public void sync(final User user) {
        //if (user.getID() == -1) {
        // here we save new user and set it's ID
        //} else {
        // here we update information about existing user
        //}
        saveLists();
    }

    @Override
    public void sync(final Users users) {
        users.setUsers(usersList);
        saveLists();
    }

    @Override
    public void sync(final Administrator admin) {
        saveLists();
    }

    @Override
    public void sync(final Manager manager) {
        saveLists();
    }

    @Override
    public void sync(final Executor executor) {
        saveLists();
    }
}
