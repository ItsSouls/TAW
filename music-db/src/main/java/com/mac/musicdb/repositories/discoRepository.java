package com.mac.musicdb.repositories;

import com.mac.musicdb.Entity.DiscoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface discoRepository extends JpaRepository<DiscoEntity,Integer> {
}
