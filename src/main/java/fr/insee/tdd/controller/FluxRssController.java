package fr.insee.tdd.controller;

import fr.insee.tdd.dao.PublicationDao;
import fr.insee.tdd.model.FluxRssBuilder;
import fr.insee.tdd.model.Publication;
import fr.insee.tdd.model.rss.FluxRss;
import fr.insee.tdd.service.FluxRssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import java.io.IOException;
import java.util.List;

@Controller
public class FluxRssController {

    @Autowired
    private FluxRssService fluxRssService;

	@GetMapping("/rss")
	public void fluxRss(HttpServletResponse response) throws IOException {
        FluxRss fluxRss = fluxRssService.fluxRss();
        response.setContentType(MediaType.APPLICATION_RSS_XML_VALUE);
        JAXB.marshal(fluxRss, response.getOutputStream());
	}
}
