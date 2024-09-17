package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ChatRepository;
import com.example.demo.vo.Chat;

@Service
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;

	public List<Chat> chatList() {
		return chatRepository.chatList();
	}

	public void write(int loginedMemberId, String body) {
		chatRepository.write(loginedMemberId, body);
	}

	public Chat update() {
		return chatRepository.update();
	}
}