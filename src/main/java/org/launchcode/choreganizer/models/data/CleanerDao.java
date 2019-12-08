package org.launchcode.choreganizer.models.data;

import org.launchcode.choreganizer.models.Cleaner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CleanerDao extends CrudRepository<Cleaner, Integer> {
}
