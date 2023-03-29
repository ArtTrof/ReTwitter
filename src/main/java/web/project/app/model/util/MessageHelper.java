package web.project.app.model.util;

import web.project.app.model.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
