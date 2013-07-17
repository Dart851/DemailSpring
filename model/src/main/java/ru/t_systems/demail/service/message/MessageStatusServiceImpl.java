package ru.t_systems.demail.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.dao.message.MessageStatusDAO;
import ru.t_systems.demail.model.message.MessageStatuss;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class MessageStatusServiceImpl implements MessageStatusService {

    @Autowired
    private MessageStatusDAO messageStatusDAO;

    public MessageStatuss getMessageStatus(int id) {
        return messageStatusDAO.getMessageStatus(id);
    }

    public void addMessageStatus(MessageStatuss messageStatus) {
        messageStatusDAO.addStatusUser(messageStatus);

    }

    public void addMessageStatus(Set<MessageStatuss> messageStatus) {
        messageStatusDAO.addStatusUser(messageStatus);

    }

    public List<MessageStatuss> getMessageStatusByAccount1(
            List<Integer> accounts) {
        messageStatusDAO.getMessageStatussByAccount1(accounts);
        return null;
    }

    public List<MessageStatuss> getMessageStatusByAccount1(Integer accountId) {
        return messageStatusDAO.getMessageStatussByAccount1(Arrays
                .asList(accountId));

    }

    public void update(MessageStatuss messageStatus) {
        messageStatusDAO.update(messageStatus);

    }

    public List<MessageStatuss> getInputStatus(int accountId, int limit,
                                               int offset) {
        return messageStatusDAO.getInputStatus(accountId, limit, offset);

    }

    public List<MessageStatuss> getOutputStatus(int accountId, int limit,
                                                int offset) {
        return messageStatusDAO.getOutputStatus(accountId, limit, offset);
    }

    public List<MessageStatuss> getSpamStatus(int accountId, int limit,
                                              int offset) {
        return messageStatusDAO.getSpamStatus(accountId, limit, offset);
    }

    public List<MessageStatuss> getTrashStatus(int accountId, int limit,
                                               int offset) {
        return messageStatusDAO.getTrashStatus(accountId, limit, offset);
    }

    public Integer getInputStatusCount(List<Integer> accountsId) {
        return messageStatusDAO.getInputStatusCount(accountsId);
    }

    public Integer getOutputStatusCount(List<Integer> accountsId) {
        return messageStatusDAO.getOutputStatusCount(accountsId);
    }

    public Integer getSpamStatusCount(List<Integer> accountsId) {
        return messageStatusDAO.getSpamStatusCount(accountsId);
    }

    public Integer getTrashCount(List<Integer> accountsId) {
        return messageStatusDAO.getTrashCount(accountsId);
    }

    public List<MessageStatuss> getInputStatusFromLabel(int accountId,
                                                        int labelId, int limit, int offset) {
        return messageStatusDAO.getInputStatusFromLabel(accountId, labelId,
                limit, offset);

    }

    public MessageStatuss getMessageStatus(int statusId, int userId) {

        return messageStatusDAO.getMessageStatus(statusId, userId);
    }

}
