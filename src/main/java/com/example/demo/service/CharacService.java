package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CharacRepository;
import com.example.demo.vo.Charac;

@Service
public class CharacService {

	@Autowired
	private CharacRepository characRepository;

	public CharacService(CharacRepository characRepository) {
		this.characRepository = characRepository;
	}

	public void characCreation(int loginedMemberId) {
		characRepository.characCreation(loginedMemberId);
	}

	public Charac characChack(int loginedMemberId) {
		return characRepository.characChack(loginedMemberId);
	}

	public void update(int hp, int floor, int room, int memberId) {
		characRepository.update(hp, floor, room, memberId);
	}

	public void weaponChange(int memberId, int weaponId) {
		/* System.out.println("무기 체인지 서비스 실행"); */
		/* System.out.println(weaponId); */
		characRepository.weaponChange(memberId, weaponId);
	}

	public void reset(int memberId) {
		characRepository.reset(memberId);

	}

	public void itemGet(int memberId, int power, int speed) {
		int random_ability = (int) (Math.random() * 170) + 1;
		int ability = 0;
		int point = 0;
		if (random_ability <= 10) { // 힘 +1 = 1~10
			ability = 1;
			point = power + 1;
		} else if (random_ability <= 20) { // 힘 -1 = 11~20
			ability = 1;
			point = power - 1;
		} else if (random_ability <= 30) { // 속도 -10 = 21~30
			ability = 2;
			point = speed - 10;
		} else if (random_ability <= 40) { // 속도 +10 = 31~40
			ability = 2;
			point = speed + 10;
		} else if (random_ability <= 49) { // 힘 +2 = 41~49
			ability = 1;
			point = power + 2;
		} else if (random_ability <= 50) { // 힘 +10 = 50
			ability = 1;
			point = power + 10;
		} else if (random_ability <= 59) { // 힘 -2 = 51~59
			ability = 1;
			point = power - 2;
		} else if (random_ability <= 60) { // 힘 -10 = 60
			ability = 1;
			point = power - 10;
		} else if (random_ability <= 69) { // 속도 -20 = 61~69
			ability = 2;
			point = speed - 20;
		} else if (random_ability <= 70) { // 속도 -50 = 70
			ability = 2;
			point = speed - 50;
		} else if (random_ability <= 79) { // 속도 +20 = 71~79
			ability = 2;
			point = speed + 20;
		} else if (random_ability <= 80) { // 속도 +50 = 80
			ability = 2;
			point = speed + 50;
		} else if (random_ability <= 88) { // 힘 +3 = 81~88
			ability = 1;
			point = power + 3;
		} else if (random_ability <= 90) { // 힘 +9 = 89~90
			ability = 1;
			point = power + 9;
		} else if (random_ability <= 98) { // 힘 -3 = 91~98
			ability = 1;
			point = power - 3;
		} else if (random_ability <= 100) { // 힘 -9 = 99~100
			ability = 1;
			point = power - 9;
		} else if (random_ability <= 107) { // 힘 +4 = 101~107
			ability = 1;
			point = power + 4;
		} else if (random_ability <= 110) { // 힘 +8 = 108~110
			ability = 1;
			point = power + 8;
		} else if (random_ability <= 117) { // 힘 -4 = 111~117
			ability = 1;
			point = power - 4;
		} else if (random_ability <= 120) { // 힘 -8 = 118~120
			ability = 1;
			point = power - 8;
		} else if (random_ability <= 126) { // 힘 +5 = 121~126
			ability = 1;
			point = power + 5;
		} else if (random_ability <= 130) { // 힘 +7 = 127~130
			ability = 1;
			point = power + 7;
		} else if (random_ability <= 136) { // 힘 -5 = 131~136
			ability = 1;
			point = power - 5;
		} else if (random_ability <= 140) { // 힘 -7 = 137~140
			ability = 1;
			point = power - 7;
		} else if (random_ability <= 146) { // 속도 -30 = 141~146
			ability = 2;
			point = speed - 30;
		} else if (random_ability <= 150) { // 속도 -40 = 147~150
			ability = 2;
			point = speed - 40;
		} else if (random_ability <= 156) { // 속도 +30 = 151~156
			ability = 2;
			point = speed + 30;
		} else if (random_ability <= 160) { // 속도 +40 = 157~160
			ability = 2;
			point = speed + 40;
		} else if (random_ability <= 165) { // 힘 +6 = 161~165
			ability = 1;
			point = power + 6;
		} else if (random_ability <= 170) { // 힘 -6 = 166~170
			ability = 1;
			point = power - 6;
		}
		if (ability == 1 && point < 0) {
			point = 0;
		}
		if (ability == 2 && point < 10) {
			point = 10;
		}else if (ability == 2 && point > 100) {
			point = 100;
		}
		/*
		System.out.println("아이템 획득 서비스 실행");
		if (ability == 1) {
			System.out.println("힘 ? " + point);
		}else if (ability == 2) {
			System.out.println("스피드 ? " + point);
		}
		*/
		
		characRepository.itemGet(memberId, ability, point);
	}
}