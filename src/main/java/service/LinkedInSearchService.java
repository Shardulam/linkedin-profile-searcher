package service;

import model.request.LinkedInProfileSearchDTO;
import model.response.AlumniVO;
import model.response.SuccessResponseVO;

import java.util.List;
import java.util.UUID;

public interface LinkedInSearchService {

    SuccessResponseVO<Object> searchAlumniLinkedInProfiles(LinkedInProfileSearchDTO searchDTO);

    SuccessResponseVO<Object> fetchScrapedAlumniLinkedInProfiles(UUID trackingId);

    SuccessResponseVO<List<AlumniVO>> fetchAllAlumni(int page, int limit);
}
