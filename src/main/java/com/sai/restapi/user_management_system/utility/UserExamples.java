package com.sai.restapi.user_management_system.utility;

public final class UserExamples {

    private UserExamples() {} // prevent instantiation

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
    public static final String USER404 = "{\n\"error\":\"404\",\n" + "\"description\":\"not found\"\n}";
    public static final String USER204 = "{\n\"RESPONSE\":\"204\",\n" + "\"description\":\"Deleted Successfully\"\n}";

    public static final String USER_LIST = """
            [
              {
                "user_id": 1,
                "name": "user1",
                "email": "user1@gmail.com",
                "projects": [],
                "tasks": [],
                "comments": []
              },
              {
                "user_id": 2,
                "name": "user2",
                "email": "user2@gmail.com",
                "projects": [],
                "tasks": [],
                "comments": []
              }
            ]
            """;


    public static final String USER_UPDATE = "{ \"name\": \"user1\", \"email\": \"user1@gmail.com\" }";

    public static final String USER500 = "{\"error\":\"500\",\"description\":\"Internal Server Error\"}";
}