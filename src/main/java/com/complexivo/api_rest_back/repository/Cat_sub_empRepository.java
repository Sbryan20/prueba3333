/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.repository;

import com.complexivo.api_rest_back.modelo.Cat_sub_emp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author Usuario
 */
@Repository
public interface Cat_sub_empRepository extends JpaRepository<Cat_sub_emp, Long>{
    public Optional<Cat_sub_emp> findByCsedetalle(String csedetalle);
	
    public Boolean existsByCsedetalle(String csedetalle);
    
    @Query(value = "select p.iddetalle, p.csedetalle, p.idempresa, p.idcatemp, p.idsubcatemp from railway.cat_sub_emp p inner join railway.empresa c on p.idempresa = c.idempresa where c.idempresa = :id",nativeQuery=true)
    public List<Cat_sub_emp> findByIdempresa(long id);
}
