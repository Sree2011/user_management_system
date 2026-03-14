package com.sai.restapi.user_management_system.utility;

public class CommentExamples {

    private CommentExamples(){};

    public static final String COMMENT200 = """
            {
                "comment_id": 1,
                "content": "string",
                "task": null,
                "author": null
              }
            """;

    public static final String COMMENT_REQUEST = """
            {
                "content": "string1"
            }
            """;

    public static final String LIST_COMMENTS = """
            [
            {
                "comment_id": 1,
                "content": "string",
                "task": null,
                "author": null
              },
              {
                  "comment_id": 2,
                  "content": "string0",
                  "task": null,
                  "author": null
                }
                ]
            """;

    public static final String COMMENT204 = """
            {
              "response": "204",
              "description": "Comment deleted successfully"
            }
            """;
}
