package com.example.policeproject.repository;

import com.example.policeproject.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {

}
