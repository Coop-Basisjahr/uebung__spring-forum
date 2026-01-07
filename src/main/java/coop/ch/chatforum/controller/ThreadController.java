package coop.ch.chatforum.controller;

import coop.ch.chatforum.data.Comment;
import coop.ch.chatforum.data.Thread;
import coop.ch.chatforum.service.ThreadService;
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
        return threadService.addThread(thread);
    }

    @PostMapping("/{threadTitle}/comment")
    public Thread postComment(@PathVariable String threadTitle, @RequestBody Comment comment) {
        return threadService.addComment(threadTitle, comment);
    }

    @GetMapping()
    public List<Thread> getThreads() {
        return threadService.getThreads();
    }
}
