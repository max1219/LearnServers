package org.ogr.gor.www.old.repositories.samples.simples;

import org.ogr.gor.www.old.entities.database.Subject;
import org.ogr.gor.www.old.repositories.interfaces.ISubjectRepository;

public class SimpleSubjectRepository implements ISubjectRepository {
    @Override
    public long add(Subject subject) {
        System.out.print("Add subject");
        return 0;
    }

    @Override
    public void delete(long id) {
        System.out.print("Delete subject");
    }

    @Override
    public void edit(Subject subject) {
        System.out.print("Edit subject");
    }

    @Override
    public Subject getById(long id) {
        return new Subject(0L, "N0");
    }

    @Override
    public Subject[] getAll() {
        return new Subject[]{
                new Subject(0L, "N0"),
                new Subject(1L, "N1")
        };
    }
}
