package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Charac;
import com.example.demo.vo.Scoreboard;

@Mapper
public interface ScoreboardRepository {

	@Insert("""
			INSERT INTO charac
			SET regDate = NOW(),
			updateDate = NOW(),
			memberId = #{loginedMemberId}
			""")
	public Charac characCreation(int loginedMemberId);

	@Select("""
			SELECT S.*, M.nickname extra__user
			FROM scoreboard S
			LEFT JOIN `member` M
			ON m.id = S.memberId
			ORDER BY `floor` DESC, room DESC
			LIMIT 0, 3
			""")
	public List<Scoreboard> scoreboardTop3();

	@Select("""
			SELECT S.*, M.nickname extra__user
			FROM scoreboard S
			LEFT JOIN `member` M
			ON m.id = S.memberId
			ORDER BY `floor` DESC, room DESC
			""")
	public List<Scoreboard> scoreboardList();
}