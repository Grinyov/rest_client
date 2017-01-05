package com.grinyov.spring.rest_client.service;

import com.google.common.collect.ImmutableList;
import com.grinyov.spring.rest_client.model.StackOverflowWebsite;
import com.grinyov.spring.rest_client.persistence.StackOverflowWebsiteRepository;
import com.grinyov.spring.rest_client.service.dto.SiteDto;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created by vgrinyov.
 */
@Service
public class StackoverflowService {

    @Autowired
    private StackOverflowWebsiteRepository repository;

    @Autowired
    private StackExchangeClient stackExchangeClient;


//    private static List<StackOverflowWebsite> items = new ArrayList<>();
//
//    static {
//        items.add(new StackOverflowWebsite("stackoverflow", "http://stackoverflow.com",
//                "http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
//                "Stack Overflow {StackExchange}", "for professional programmers and enthusiast programmers"));
//        items.add(new StackOverflowWebsite("serverfault", "http://serverfault.com",
//                "http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico",
//                "Server Fault {StackExchange}", "for system and network administrators"));
//        items.add(new StackOverflowWebsite("askubuntu", "http://askubuntu.com",
//                "http://cdn.sstatic.net/Sites/askubuntu/img/favicon.ico",
//                "Ask Ubuntu {StackExchange}", "for Ubuntu users and programmers"));
//        items.add(new StackOverflowWebsite("apple", "http://apple.com", "http://cdn.sstatic.net/Sites/apple/img/favicon.ico",
//                "Apple Enthusiasts {StackExchange}", "for power users Apple hardware and software"));
//        items.add(new StackOverflowWebsite("andriod", "http://andriod.com",
//                "http://cdn.sstatic.net/Sites/andriod/img/favicon.ico",
//                "Andriod Enthusiasts {StackExchange}", "for enthusiasts and power users Android OS"));
//    }
//
//    @PostConstruct
//    public void init() {
//        repository.save(items);
//    }

    public List<StackOverflowWebsite> findAll(){
        return stackExchangeClient.getSites().stream()
                .map(this::toStackoverflowWebsite)
                .filter(this::ignoreMap)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMap(@NonNull StackOverflowWebsite stackOverflowWebsite) {
        return !stackOverflowWebsite.getId().startsWith("meta.");
    }

    private StackOverflowWebsite toStackoverflowWebsite(@NonNull SiteDto input){
        return new StackOverflowWebsite(
                input.getSite_url().substring("http://".length(), input.getSite_url().length() - ".com".length()),
                input.getSite_url(),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());

    }
//    public List<StackOverflowWebsite> findAll(){
//        return repository.findAll();
//    }
}
