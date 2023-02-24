package web.project.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.project.app.model.Message;
import web.project.app.model.User;
import web.project.app.model.dto.MessageDTO;
import web.project.app.repositories.MessageRepository;

import javax.persistence.EntityManager;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;


    public Page<MessageDTO> messageList(Pageable pageable, String filter,User user) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepository.findByTag(filter, pageable,user);
        } else {
            return messageRepository.findAll(pageable,user);
        }
    }

    public Page<MessageDTO> messageListForUser(Pageable pageable, User currentUser, User author) {
        return messageRepository.findByUser(pageable,author,currentUser);
    }
}
