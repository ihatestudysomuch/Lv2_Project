package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/analyses")
@Transactional
public class AnalysisController {

    // AnalysisPaused
    @Autowired
    AnalysisRepository analysisRepository;

    @RequestMapping(
            value = "/analyses/{id}/pause",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8"
    )
    public Analysis pause(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /analysis/pause  called #####");
        Optional<Analysis> optionalAnalysis = analysisRepository.findById(id);

        optionalAnalysis.orElseThrow(() -> new Exception("No Entity Found"));
        Analysis analysis = optionalAnalysis.get();
        analysis.pause();

        analysisRepository.save(analysis);
        return analysis;
    }

}
//>>> Clean Arch / Inbound Adaptor
