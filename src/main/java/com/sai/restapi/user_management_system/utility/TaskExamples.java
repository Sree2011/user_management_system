package com.sai.restapi.user_management_system.utility;

import com.sai.restapi.user_management_system.controller.TaskController;

public class TaskExamples {
    private TaskExamples(){};

    public static final String TASK200 = """
            {
          "task_id": 2,
          "title": "user1",
          "description": "desc1",
          "status": "IN_PROGRESS",
          "priority": "HIGH",
          "dueDate": null,
          "project": null,
          "user": null,
          "comments": null
        }""";

    public static final String TASK_REQUEST = """
            {
          "title": "user1",
          "description": "desc1",
          "status": "IN_PROGRESS",
          "priority": "HIGH"
            }""";

    public static final String TASK_LIST = """
            [
              {
                "task_id": 1,
                "title": null,
                "description": "desc1",
                "status": "IN_PROGRESS",
                "priority": "HIGH",
                "dueDate": null,
                "project": null,
                "user": null,
                "comments": []
              },
              {
                "task_id": 2,
                "title": "user1",
                "description": "desc1",
                "status": "IN_PROGRESS",
                "priority": "HIGH",
                "dueDate": null,
                "project": null,
                "user": null,
                "comments": []
              }
            ]
            """;


}
