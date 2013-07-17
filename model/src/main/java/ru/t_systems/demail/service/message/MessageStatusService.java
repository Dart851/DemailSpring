package ru.t_systems.demail.service.message;

import ru.t_systems.demail.model.message.MessageStatuss;

import java.util.List;
import java.util.Set;

public interface MessageStatusService {

    public MessageStatuss getMessageStatus(int id);

    public void addMessageStatus(MessageStatuss messageStatus);

    public void addMessageStatus(Set<MessageStatuss> messageStatus);

    @Deprecated
    public List<MessageStatuss> getMessageStatusByAccount1(List<Integer> accounts);

    @Deprecated
    public List<MessageStatuss> getMessageStatusByAccount1(Integer accountId);

    public void update(MessageStatuss messageStatus);

    public List<MessageStatuss> getInputStatus(int accountId, int limit, int offset);

    public List<MessageStatuss> getOutputStatus(int accountId, int limit, int offset);

    public List<MessageStatuss> getSpamStatus(int accountId, int limit, int offset);

    public List<MessageStatuss> getTrashStatus(int accountId, int limit, int offset);

    public Integer getInputStatusCount(List<Integer> accountsId);

    public Integer getOutputStatusCount(List<Integer> accountsId);

    public Integer getSpamStatusCount(List<Integer> accountsId);

    public Integer getTrashCount(List<Integer> accountsId);

    public List<MessageStatuss> getInputStatusFromLabel(int accountId, int labelId, int limit, int offset);

    public MessageStatuss getMessageStatus(int statusId, int userId);
}
