package coop.ch.chatforum.data;

public record Comment(
    User user,
    String text
) {
}
