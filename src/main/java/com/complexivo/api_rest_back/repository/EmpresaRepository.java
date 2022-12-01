/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.repository;

import com.complexivo.api_rest_back.modelo.Empresa;
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
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    public Optional<Empresa> findByEmpnombre(String empnombre);
	
    public Boolean existsByEmpruc(String empruc);
    
    
    @Query(value = "select e.empnombre, p.nombre, sum(c.cantidad) AS Total de cantidad, (p.precio*sum(c.cantidad)) as Total de venta from railway.empresa e inner join railway.producto p on e.idempresa = p.idempresa inner join railway.detalle c on p.idproducto = c.idproducto where p.idempresa =:id group by p.idproducto order by sum(c.cantidad) desc",nativeQuery=true)
    public List<Empresa> findByidpro(long id);
    
    @Query(value = "Select * from railway.empresa u where u.usu_id = :usu_id",nativeQuery=true)
    public Empresa findByUser(long usu_id);
    
    @Query(value = "select e.idempresa as 'idempresa', e.empruc as 'ruc', e.empnombre as 'empresa', sum(c.precio) as 'venta' \n" +
                    "from empresa e inner join producto p on e.idempresa = p.idempresa inner join detalle c on p.idproducto = c.idproducto \n" +
                    "group by e.idempresa\n" +
                    "order by sum(c.precio) desc;",nativeQuery=true)
    public List<Object> obtenerRankingByIdempresa();
    
    @Query(value = "select e.idempresa as 'idempresa',e.empruc as 'ruc', e.empnombre as 'empresa', month(f.fecha_factura) AS 'mes', year(f.fecha_factura) AS 'año',sum(c.precio) as 'venta'\n" +
                    "from empresa e inner join producto p on e.idempresa = p.idempresa inner join detalle c on p.idproducto = c.idproducto inner join factura f on c.idfactura = f.idfactura\n" +
                    "where MONTH(fecha_factura) = :mes and YEAR(fecha_factura)=:año and e.idempresa = :idempresa\n" +
                    "group by e.idempresa\n" +
                    "order by sum(c.precio) desc;",nativeQuery=true)
    public List<Object> obtenerReporteFechaByIdempresa(Long idempresa, int mes, int año);
}
