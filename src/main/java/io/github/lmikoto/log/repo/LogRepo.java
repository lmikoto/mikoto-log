package io.github.lmikoto.log.repo;

import io.github.lmikoto.jpa.query.BaseRepository;
import io.github.lmikoto.log.model.LogEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends BaseRepository<LogEntity,Long> {
}
