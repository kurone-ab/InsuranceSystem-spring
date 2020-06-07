package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.announcement.Announcement;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.exception.NoEmployeeException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    List<Announcement> findAllByTitle(String title);
    List<Announcement> findAllByAuthor(Employee author) throws NoEmployeeException;
    List<Announcement> findAllByDate(Date date);
}
