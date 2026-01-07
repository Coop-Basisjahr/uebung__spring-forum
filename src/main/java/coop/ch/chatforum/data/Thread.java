package coop.ch.chatforum.data;

import java.util.List;

public record Thread (
    String title,
    String text,
    User user,
    List<Comment> comments
){
}
