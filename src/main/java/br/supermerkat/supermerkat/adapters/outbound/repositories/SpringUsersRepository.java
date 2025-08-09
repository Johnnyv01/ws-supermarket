package br.supermerkat.supermerkat.adapters.outbound.repositories;

import br.supermerkat.supermerkat.adapters.outbound.entity.UsuarioEntity;
import br.supermerkat.supermerkat.application.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringUsersRepository extends BaseRepository<UsuarioEntity> {
}
