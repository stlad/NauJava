package ru.naumen.vagnov.naujava.controller.view;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.vagnov.naujava.entity.Message;
import ru.naumen.vagnov.naujava.repository.MessageRepository;

@Controller
@RequestMapping("/messages/view")
@Slf4j
@RequiredArgsConstructor
public class ChatControllerView {
    private final MessageRepository messageRepository;

    @GetMapping("/list")
    public String mewssagesListView(Model model)
    {
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "messages";
    }
}
