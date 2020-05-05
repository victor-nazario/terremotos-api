package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.BaseResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BaseResourceRepository extends CrudRepository<BaseResource, Long> {
    @Query(value = "select * from base_resource br left outer join baby_food bf on br.id = bf.id left outer join battery b on br.id = b.id "+
            "left outer join canned_food cf on br.id = cf.id left outer join clothing c on br.id = c.id left outer join dry_food df on br.id = df.id "+
            "left outer join fuel f on br.id = f.id left outer join heavy_equipment he on br.id = he.id left outer join medical_devices md on br.id = md.id "+
            "left outer join power_gen pg on br.id = pg.id left outer join diesel d on f.id = d.id left outer join gasoline g on f.id = g.id "+
            "left outer join propane p on f.id = p.id left outer join water w on br.id = w.id left outer join ice i on br.id = i.id left outer join gallon_bottle gb on w.id = gb.id "+
            "left outer join medication m on br.id = m.id left outer join small_bottle sb on w.id = sb.id left outer join tool t on br.id = t.id ;"
            , nativeQuery = true)
    List<BaseResource> findAll();

    @Query(value = "select * from base_resource where id = :id", nativeQuery = true)
    BaseResource findById(@Param("id") Integer id);

    @Query(value = "select * from base_resource where name = :name", nativeQuery = true)
    List<BaseResource> findByName(@Param("name") String name);

    @Query(value = "select * from base_resource where available = true", nativeQuery = true)
    List<BaseResource> findAvailable();

    @Query(value = "select count(id) from base_resource", nativeQuery = true)
    String countAvailable();
}
