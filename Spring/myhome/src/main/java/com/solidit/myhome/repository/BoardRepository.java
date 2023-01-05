package com.solidit.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.solidit.myhome.model.Board;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
