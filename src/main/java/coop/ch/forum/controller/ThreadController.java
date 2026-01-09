package coop.ch.forum.controller;

import coop.ch.forum.data.Comment;
import coop.ch.forum.data.Thread;
import coop.ch.forum.service.ThreadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/threads")
public class ThreadController {

    private final ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @PostMapping()
    public Thread postThread(@RequestBody Thread thread) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @PostMapping("/{threadTitle}/comment")
    public Thread postComment(@PathVariable String threadTitle, @RequestBody Comment comment) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @GetMapping()
    public List<Thread> getThreads() {
        // TODO
        throw new UnsupportedOperationException();
    }
}
