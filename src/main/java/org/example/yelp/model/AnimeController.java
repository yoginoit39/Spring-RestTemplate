package org.example.yelp.model;

import lombok.RequiredArgsConstructor;
import org.example.yelp.service.AnimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/anime")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping("allAnime")
    public ResponseEntity<?> callRapidEndPointToGetAnimData(){
        // Call the method on the instance of AnimeService
        return ResponseEntity.ok(animeService.allAnime());
    }

    @GetMapping("/anime-details")
    public String showAnimeDetails(Model model) {
        Map<String, Object> anime = new HashMap<>();
        anime.put("title_en", "Frieren: Beyond Journey's End");
        anime.put("synopsis", "During their decade-long quest to defeat the Demon King, the members of the hero's party...");
        anime.put("picture_url", "https://cdn.myanimelist.net/images/anime/1015/138006.jpg");
        anime.put("episodes", "28");
        anime.put("score", "9.39");
        anime.put("watch_link", "#");
        anime.put("myanimelist_url", "https://myanimelist.net/anime/52991/Frieren_Beyond_Journeys_End");

        model.addAttribute("anime", anime);

        return "index";
    }

}

