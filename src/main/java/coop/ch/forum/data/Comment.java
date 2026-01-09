package coop.ch.forum.data;

public record Comment(
    User user,
    String text
) {
}
