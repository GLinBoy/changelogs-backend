package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.MessageDTO;
import info.changelogs.app.entity.Message;
import info.changelogs.app.repository.MessageRepository;
import info.changelogs.app.service.MessageServiceApi;

@Service
public class MessageServiceImpl
	extends GenericServiceImpl<MessageDTO, Message, MessageRepository>
	implements MessageServiceApi {

	public MessageServiceImpl(MessageRepository repository, ModelMapper mapper) {
		super(repository, mapper, MessageDTO.class, Message.class);
	}

}
