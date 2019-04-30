package com.cognizant.util;

import com.cognizant.entity.ParentTask;
import com.cognizant.entity.Project;
import com.cognizant.entity.Task;
import com.cognizant.entity.User;
import com.cognizant.model.TaskRecord;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskMockData {

    public TaskRecord getTaskRecord(){

        return new TaskRecord("DummyTask",
                java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
                java.sql.Date.valueOf(LocalDate.parse("2019-04-03")),
                1,
                "New",
                new UserMockData().getSingleUser(),
                new ProjectMockData().getSingleProject(),
                new ParentTaskMockData().getSingleParentTask()
                );
    }

    public Task getSingleTask(){

        return new Task((long)1, (long)1, (long)1, "DummyTask",
                java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
                java.sql.Date.valueOf(LocalDate.parse("2019-04-03")),
                1,
                "New"
        );
    }

    public Task getSingleTaskWithoutTaskId(){

        return new Task((long)1, (long)1, "DummyTask",
                java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
                java.sql.Date.valueOf(LocalDate.parse("2019-04-03")),
                1,
                "New"
        );
    }

    public List<Task> getTaskList(){

        List<Task> taskList = new ArrayList<>();

        taskList.add(
                new Task(
                    (long)1, (long)1, (long)1, "DummyTask",
                    java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
                    java.sql.Date.valueOf(LocalDate.parse("2019-04-03")),
                    1,
                    "New"
                )
            );

        taskList.add(
                new Task(
                        (long)2, (long)1, (long)1, "DummyTask2",
                        java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
                        java.sql.Date.valueOf(LocalDate.parse("2019-04-03")),
                        1,
                        "New"
                )
        );

        return taskList;
    }
}
