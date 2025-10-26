package service;

import model.request.LinkedInProfileSearchDTO;
import model.response.SuccessResponseVO;

public interface PhantomBusterService {

    SuccessResponseVO<Object> searchLinkedInProfiles(LinkedInProfileSearchDTO linkedInProfileSearchDTO);
}
