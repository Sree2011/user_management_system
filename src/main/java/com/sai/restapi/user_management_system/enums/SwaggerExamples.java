package com.sai.restapi.user_management_system.enums;

public final class SwaggerExamples {

    private SwaggerExamples() {} // prevent instantiation

    public static final String USER_REQUEST =
            "{ \"name\": \"user1\", \"email\": \"user1@gmail.com\" }";

    public static final String USER200 =
            "{\n" +
            "  \"user_id\": 1,\n" +
            "  \"name\": \"string\",\n" +
            "  \"email\": \"string\",\n" +
            "  \"projects\": null,\n" +
            "  \"tasks\": null,\n" +
            "  \"comments\": null\n" +
            "}";
    public static final String USER404 = "{\n\"error\":\"404\",\n" + "\"description\":\"user not found\"\n}";
    public static final String PROJECT_EXAMPLE =
            "{ \"title\": \"AI Project\", \"description\": \"GenAI backend system\" }";

    public static final String TASK_EXAMPLE =
            "{ \"title\": \"Implement CRUD\", \"status\": \"IN_PROGRESS\" }";

    public static final String USER_UPDATE = "{ \"name\": \"user1\", \"email\": \"user1@gmail.com\" }";

    public static final String USER500 = "{\"error\":\"500\",\"description\":\"Internal Server Error\"}";
}