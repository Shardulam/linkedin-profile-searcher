package rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import model.request.LinkedInProfileSearchDTO;
import model.response.AlumniVO;
import model.response.SuccessResponseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.LinkedInSearchService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/linked-in")
@RequiredArgsConstructor
@Validated
public class LinkedInProfileController {

    private final LinkedInSearchService linkedInSearchService;

    @PostMapping("/search")
    public ResponseEntity<SuccessResponseVO<Object>> searchAlumniLinkedInProfiles(
            @RequestBody @Valid LinkedInProfileSearchDTO linkedInProfileSearchDTO) {
        return ResponseEntity.ok(linkedInSearchService.searchAlumniLinkedInProfiles(linkedInProfileSearchDTO));
    }

    @GetMapping("/fetch/{trackingId}")
    public ResponseEntity<SuccessResponseVO<Object>> fetchScrapedAlumniProfiles(@PathVariable UUID trackingId) {
        return ResponseEntity.ok(linkedInSearchService.fetchScrapedAlumniLinkedInProfiles(trackingId));
    }

    @GetMapping("/fetch/all")
    public ResponseEntity<SuccessResponseVO<List<AlumniVO>>> fetchAllAlumni(@RequestParam int page,
                                                                            @RequestParam int limit) {
        return ResponseEntity.ok(linkedInSearchService.fetchAllAlumni(page, limit));
    }
}
