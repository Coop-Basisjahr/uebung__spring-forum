package coop.ch.chatforum.service;

import coop.ch.chatforum.data.Comment;
import coop.ch.chatforum.data.Thread;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThreadService {
    private final List<Thread> threads = new ArrayList<>();

    public List<Thread> getThreads() {
        return threads;
    }

    public Thread addThread(Thread thread) {
        if (thread.title().isEmpty() || thread.text().isEmpty())
            throw new IllegalArgumentException("Thread must contain a title and text.");
        if (threadExists(thread))
            throw new IllegalArgumentException("Thread with this title already exists");
        threads.add(thread);
        return thread;
    }

    public Thread addComment(String threadTitle, Comment comment) {
        Thread thread = getThreadByTitle(threadTitle);
        thread.comments().add(comment);
        return thread;
    }

    private Thread getThreadByTitle(String title) {
        if (title == null) throw new IllegalArgumentException("Can't find thread with title 'null'");
        for (Thread t : threads) {
            if (title.equals(t.title())) return t;
        }
        throw new IllegalArgumentException("No thread with title '" + title + "'");
    }

    private boolean threadExists(Thread thread) {
        if (thread.title().isEmpty()) return false;
        for (Thread t : threads) {
            if (thread.title().equals(t.title())) return true;
        }
        return false;
    }
}
