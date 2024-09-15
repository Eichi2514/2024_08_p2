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
		int random_ability = (int) (Math.random() * 1000) + 1;
		int ability = 0;
		int point = 0;
		if (random_ability <= 100) { // 1~100
			ability = 1;
			point = power - 1;
			System.out.println("힘 -1");
		} else if (random_ability <= 150) {  // 101~150
			ability = 1;
			point = power - 2;
			System.out.println("힘 -2");
		} else if (random_ability <= 185) { // 151~185
			ability = 1;
			point = power - 3;
			System.out.println("힘 -3");
		} else if (random_ability <= 210) { // 186~210
			ability = 1;
			point = power - 4;
			System.out.println("힘 -4");
		} else if (random_ability <= 229) { // 211~229
			ability = 1;
			point = power - 5;
			System.out.println("힘 -5");
		} else if (random_ability <= 237) { // 230~237
			ability = 1;
			point = power - 6;
			System.out.println("힘 -6");
		} else if (random_ability <= 243) { // 238~243
			ability = 1;
			point = power - 7;
			System.out.println("힘 -7");
		} else if (random_ability <= 247) { // 244~247
			ability = 1;
			point = power - 8;
			System.out.println("힘 -8");
		} else if (random_ability <= 249) { // 248~249
			ability = 1;
			point = power - 9;
			System.out.println("힘 -9");
		} else if (random_ability <= 250) { // 250
			ability = 1;
			point = power - 10;
			System.out.println("힘 -10");
		} else if (random_ability <= 450) { // 251~450
			ability = 1;
			point = power + 1;
			System.out.println("힘 +1");
		} else if (random_ability <= 550) { // 451~550
			ability = 1;
			point = power + 2;
			System.out.println("힘 +2");
		} else if (random_ability <= 620) { // 551~620
			ability = 1;
			point = power + 3;
			System.out.println("힘 +3");
		} else if (random_ability <= 670) { // 621~670
			ability = 1;
			point = power + 4;
			System.out.println("힘 +4");
		} else if (random_ability <= 710) { // 671~710
			ability = 1;
			point = power + 5;
			System.out.println("힘 +5");
		} else if (random_ability <= 725) { // 711~725
			ability = 1;
			point = power + 6;
			System.out.println("힘 +6");
		} else if (random_ability <= 737) { // 726~737
			ability = 1;
			point = power + 7;
			System.out.println("힘 +7");
		} else if (random_ability <= 745) { // 738~745
			ability = 1;
			point = power + 8;
			System.out.println("힘 +8");
		} else if (random_ability <= 749) { // 746~749
			ability = 1;
			point = power + 9;
			System.out.println("힘 +9");
		} else if (random_ability <= 750) { // 750
			ability = 1;
			point = power + 10;
			System.out.println("힘 +10");
		} else if (random_ability <= 825) { // 751~825
			ability = 2;
			point = speed - 10;
			System.out.println("속도 +10");
		} else if (random_ability <= 863) { // 826~863
			ability = 2;
			point = speed - 20;
			System.out.println("속도 +20");
		} else if (random_ability <= 885) { // 864~885
			ability = 2;
			point = speed - 30;
			System.out.println("속도 +30");
		} else if (random_ability <= 899) { // 886~899
			ability = 2;
			point = speed - 40;
			System.out.println("속도 +40");
		} else if (random_ability <= 900) { // 900
			ability = 2;
			point = speed - 50;
			System.out.println("속도 +50");
		} else if (random_ability <= 950) { // 901~950
			ability = 2;
			point = speed + 10;
			System.out.println("속도 -10");
		} else if (random_ability <= 975) { // 951~975
			ability = 2;
			point = speed + 20;
			System.out.println("속도 -20");
		} else if (random_ability <= 990) { // 976~990
			ability = 2;
			point = speed + 30;
			System.out.println("속도 -30");
		} else if (random_ability <= 999) { // 991~999
			ability = 2;
			point = speed + 40;
			System.out.println("속도 -40");
		} else if (random_ability <= 1000) { // 1000
			ability = 2;
			point = speed + 50;
			System.out.println("속도 -50");
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
		*/
		
		characRepository.itemGet(memberId, ability, point);
	}
}