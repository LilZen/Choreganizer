package org.launchcode.choreganizer.models.data;

import org.launchcode.choreganizer.models.Chore;
import org.springframework.data.repository.CrudRepository;

public interface ChoreDao extends CrudRepository<Chore, Integer> {
}
