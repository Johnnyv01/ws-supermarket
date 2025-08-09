package br.supermerkat.supermerkat.application.base;
import br.supermerkat.supermerkat.util.api.ResponseAPI;

import java.util.List;
import java.util.UUID;

public interface BaseService<RQ, RE> {

    ResponseAPI<RE> create(RQ request);
    ResponseAPI<RE> update(UUID uuid, RQ request);
    ResponseAPI<RE> deleteById(UUID ui);
    ResponseAPI<RE> findById(UUID ui);
    ResponseAPI<List<RE>> findAll();

}
