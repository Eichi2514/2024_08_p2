package com.example.demo.repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Charac;
@Mapper
public interface CharacRepository {
		

	@Insert("""
			INSERT INTO `charac` 
			SET regDate = NOW(), 
			updateDate = NOW(),
			memberId = #{loginedMemberId}
			""")    
	public Charac characCreation(int loginedMemberId);

	@Select("""
			SELECT *
            FROM `charac`
            WHERE memberId = #{loginedMemberId}			
				""")
	public Charac characChack(int loginedMemberId);		
}