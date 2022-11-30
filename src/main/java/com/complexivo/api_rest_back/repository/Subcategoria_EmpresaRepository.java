/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.repository;

import com.complexivo.api_rest_back.modelo.Subcategoria_Empresa;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface Subcategoria_EmpresaRepository extends JpaRepository<Subcategoria_Empresa, Long>{
    public Optional<Subcategoria_Empresa> findBySubcatnombre(String subcatnombre);
	
    public Boolean existsBySubcatnombre(String subcatnombre);
    
    @Query(value = "select e.idsubcatemp, e.subcatnombre, e.subcatdescripcion, e.idcatemp from railway.subcategoria_empresa e inner join railway.categoria_empresa c on e.idcatemp = c.idcatemp where c.idcatemp = :id",nativeQuery=true)
    public List<Subcategoria_Empresa> findByIdcatemp(long id);
}
