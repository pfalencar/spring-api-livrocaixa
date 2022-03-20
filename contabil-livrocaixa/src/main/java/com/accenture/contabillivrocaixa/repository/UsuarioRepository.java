package com.accenture.contabillivrocaixa.repository;

import com.accenture.contabillivrocaixa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {


//    @Query(value = "SELECT coalesce(count(dna),0) FROM Dna dna where dna.tipoDna = :tipoDna ")
//    Long getCountTipoDna(@Param("tipoDna") TipoDna tipoDna);

    @Query(value = "SELECT u FROM Usuario u WHERE u.nome LIKE :nome OR u.email LIKE :email")
    List<Usuario> getUsuarioByNomeOrEmail(@Param("nome") String nome, @Param("email") String email);
}
