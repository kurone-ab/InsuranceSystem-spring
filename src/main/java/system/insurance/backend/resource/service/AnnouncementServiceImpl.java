package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import system.insurance.backend.announcement.Announcement;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.dto.AnnouncementDTO;
import system.insurance.backend.resource.repository.AnnouncementRepository;
import system.insurance.backend.resource.repository.EmployeeRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public AnnouncementServiceImpl(EmployeeRepository employeeRepository, AnnouncementRepository announcementRepository) {
        this.employeeRepository = employeeRepository;
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<AnnouncementDTO> findAll() {
        List<Announcement> announcements = this.announcementRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return this.createResponseData(announcements);
    }

    @Override
    public List<AnnouncementDTO> findAllByAuthor(int id) throws NoEmployeeException {
        List<Announcement> announcements = this.announcementRepository.findAllByAuthor(this.employeeRepository.findById(id).orElseThrow(NoEmployeeException::new));
        return this.createResponseData(announcements);
    }

    @Override
    public List<AnnouncementDTO> findAllByDate(String date) {
        List<Announcement> announcements = this.announcementRepository.findAllByDate(Date.valueOf(date));
        return this.createResponseData(announcements);
    }

    @Override
    public List<AnnouncementDTO> findAllByTitle(String title) {
        List<Announcement> announcements = this.announcementRepository.findAllByTitle(title);
        return this.createResponseData(announcements);
    }

    private List<AnnouncementDTO> createResponseData(List<Announcement> announcements){
        List<AnnouncementDTO> announcementDTOS = new ArrayList<>();
        for (Announcement announcement : announcements) {
            Employee author = announcement.getAuthor();
            announcementDTOS.add(AnnouncementDTO.builder()
                    .id(announcement.getId())
                    .title(announcement.getTitle())
                    .content(announcement.getContent())
                    .authorId(author.getId())
                    .authorName(author.getAuthority().getAuth())
                    .date(announcement.getDate())
                    .priority(announcement.isPriority())
                    .build());

        }
        return announcementDTOS;
    }
}
