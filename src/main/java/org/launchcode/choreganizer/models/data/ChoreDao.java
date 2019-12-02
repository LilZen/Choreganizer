package org.launchcode.choreganizer.models.data;

import org.launchcode.choreganizer.models.Chore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ChoreDao extends CrudRepository<Chore, Integer> {
}
