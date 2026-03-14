package com.sai.restapi.user_management_system.utility;

public class ProjectExamples {
    private ProjectExamples(){};

    public static final String PROJECT200 = """
{
  "project_id": 4,
  "name": "AI Platform",
  "description": "A project to build a scalable AI research and deployment platform.",
  "createdAt": "2026-03-14T10:36:16.6248282",
  "owner": null,
  "tasks": null
}
""";

    public static final String PROJECT_REQUEST = """
                    {
                      "name": "AI Platform",
                      "description": "A project to build a scalable AI research and deployment platform."
                    }
                    """;

    public static final String PROJECT204 = """
            {
              "response": "204",
              "description": "Project deleted successfully"
            }
            """;

    public static final String PROJECT_LIST = """
            [
              {
                "project_id": 1,
                "name": "AI Research Platform",
                "description": "A project to build a scalable AI research and deployment platform.",
                "createdAt": null,
                "owner": null,
                "tasks": []
              },
              {
                "project_id": 2,
                "name": "ML Research Platform",
                "description": "A project to build a scalable ML research and deployment platform.",
                "createdAt": null,
                "owner": null,
                "tasks": []
              },
              {
                "project_id": 3,
                "name": "Research Platform",
                "description": "A project to build a scalable AI research and deployment platform",
                "createdAt": null,
                "owner": null,
                "tasks": []
              },
              {
                "project_id": 4,
                "name": "AI Platform",
                "description": "A project to build a scalable AI research and deployment platform.",
                "createdAt": "2026-03-14T10:36:16.624828",
                "owner": null,
                "tasks": []
              }
            ]
            """;
}
