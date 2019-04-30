package com.cognizant.util;

import com.cognizant.entity.Project;
import com.cognizant.model.ProjectRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectMockData {

    public Project getSingleProject(){

        return new Project(
                (long)1,
                "DummyProject",
                java.sql.Date.valueOf(LocalDate.parse("2019-04-01")),
                java.sql.Date.valueOf(LocalDate.parse("2019-04-20")),
                1
        );
    }

    public ProjectRecord getProjectRecord(){

        return new ProjectRecord(
                "DummyProject",
                java.sql.Date.valueOf(LocalDate.parse("2019-04-01")),
                java.sql.Date.valueOf(LocalDate.parse("2019-04-20")),
                1,
                new UserMockData().getSingleUser(),
                new TaskMockData().getSingleTask()
        );
    }

    public Project getSingleProjectWithoutProjectId(){

        return new Project(
                "DummyProject",
                java.sql.Date.valueOf(LocalDate.parse("2019-04-01")),
                java.sql.Date.valueOf(LocalDate.parse("2019-04-20")),
                1
        );
    }

    public List<Project> getProjectList(){

        List<Project> projectList = new ArrayList();

        projectList.add(
                new Project(
                    (long)1,
                    "DummyProject",
                    java.sql.Date.valueOf(LocalDate.parse("2019-04-01")),
                    java.sql.Date.valueOf(LocalDate.parse("2019-04-20")),
                    1
                )
        );

        projectList.add(
                new Project(
                        (long)2,
                        "DummyProject2",
                        java.sql.Date.valueOf(LocalDate.parse("2019-04-01")),
                        java.sql.Date.valueOf(LocalDate.parse("2019-04-20")),
                        1
                )
        );

        return projectList;
    }
}
