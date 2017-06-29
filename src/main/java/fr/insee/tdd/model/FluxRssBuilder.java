package fr.insee.tdd.model;

import fr.insee.tdd.model.rss.Channel;
import fr.insee.tdd.model.rss.FluxRss;
import fr.insee.tdd.model.rss.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FluxRssBuilder {

    public static FluxRss from(List<Publication> publications) {
        FluxRss fluxRss = new FluxRss();
        Channel channel = new Channel();
        channel.setTitle("Dernières publications");
        List<Item> items = publications
                .stream()
                .map(FluxRssBuilder::from)
                .collect(Collectors.toList());
        channel.setItems(items);
        fluxRss.setChannel(channel);
        return fluxRss;
    }

    public static Item from(Publication publication) {
        Item item = new Item();
        item.setTitle(publication.getTitre());
        item.setDescription(publication.getSousTitre());
        item.setPubDate(publication.getDateParution());
        return item;
    }
}
